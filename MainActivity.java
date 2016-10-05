package com.learn.bdc.nationalsday;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.learn.bdc.nationalsday.adapters.MyBillAdapter;
import com.learn.bdc.nationalsday.adapters.NotebookAdapter;
import com.learn.bdc.nationalsday.adapters.ViewPagerAdapter;
import com.learn.bdc.nationalsday.datalists.Account;
import com.learn.bdc.nationalsday.datalists.NoteBookList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private ViewPager viewPager;
    private List<View> datas;
    private Button addBill, addNote;
    private LayoutInflater inflater;
    private TextView bottom_noteboook, bottom_bill, bottom_account;
    private List<TextView> widgetList = new ArrayList<>();
    private List<View> lineViewlist = new ArrayList<>();
    private View bookView, billView, accountView;
    NotebookAdapter myBookadapter;
    MyBillAdapter billAdapter;
    private static TextView totalMoney_tv,cash_tv,deposit_tv,creditCard_tv,alipay_tv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        init();

    }



    @Override
    protected void onRestart() {
        super.onRestart();
        myBookadapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        billAdapter.notifyDataSetChanged();

    }

    private void init() {
        //获取导航栏按钮对象，设置监听
        bottom_noteboook = (TextView) findViewById(R.id.bottom_notebook);
        bottom_bill = (TextView) findViewById(R.id.bottom_bill);
        bottom_account = (TextView) findViewById(R.id.bottom_account);
        widgetList.add(bottom_noteboook);
        widgetList.add(bottom_bill);
        widgetList.add(bottom_account);
        bottom_account.setOnClickListener(MainActivity.this);
        bottom_bill.setOnClickListener(MainActivity.this);
        bottom_noteboook.setOnClickListener(MainActivity.this);

        lineViewlist.add(findViewById(R.id.bottom_line1));
        lineViewlist.add(findViewById(R.id.bottom_line2));
        lineViewlist.add(findViewById(R.id.bottom_line3));

        // 实例化viewPager，获取view数据
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        getViewdatas();

        //创建vp适配器并绑定
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(datas);
        viewPager.setAdapter(vpAdapter);

        //设置Viewpager的监听事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                clearStyle();
                setStyle(position);




            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }



        });


        //实例化记事本listView，并设定适配器；
        ListView bookLv = (ListView) bookView.findViewById(R.id.notebookLV);
        myBookadapter=new NotebookAdapter(MainActivity.this);

        bookLv.setAdapter(myBookadapter);




        //设置监听
        bookLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NoteInfoActivity.class);
                intent.putExtra("item_position", position);
                startActivity(intent);
            }
        });

        bookLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               NoteBookList.getInstance().getlist().remove(position);
                myBookadapter.notifyDataSetChanged();

                return true;
            }
        });

        //实例化账单listview，设定适配器
        ListView billLv = (ListView) billView.findViewById(R.id.billLV);
        billAdapter=new MyBillAdapter(MainActivity.this);
        billLv.setAdapter(billAdapter);



        //实例化加号按钮,并设置监听
        addBill = (Button) billView.findViewById(R.id.addBill);
        addBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoneyRecordActivity.class);
                startActivity(intent);
            }
        });

        addNote = (Button) bookView.findViewById(R.id.addNote);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteInfoActivity.class);
                startActivity(intent);

            }
        });


        cash_tv= (TextView) accountView.findViewById(R.id.cash_tv);
        deposit_tv= (TextView) accountView.findViewById(R.id.deposit_tv);
        creditCard_tv= (TextView) accountView.findViewById(R.id.creditCard_tv);
        alipay_tv= (TextView) accountView.findViewById(R.id.alipay_tv);
        totalMoney_tv= (TextView) accountView.findViewById(R.id.totalMoney_tv);
        showAccountMoney();




    }

    public  static void showAccountMoney() {
        cash_tv.setText(Account.cash+"");
        deposit_tv.setText(Account.deposit+"");
        creditCard_tv.setText(Account.creditCard+"");
        alipay_tv.setText(Account.alipay+"");
        totalMoney_tv.setText(Account.cash+Account.deposit+Account.creditCard+Account.alipay+"");
    }


    private void getViewdatas() {
        inflater = LayoutInflater.from(MainActivity.this);
        datas = new ArrayList<>();
        //添加记事本的View
        bookView = inflater.inflate(R.layout.notebook, null);
        datas.add(bookView);
        //添加账单View
        billView = inflater.inflate(R.layout.bill, null);
        datas.add(billView);
        //添加帐户View
        accountView = inflater.inflate(R.layout.account, null);
        datas.add(accountView);
    }

    private void setStyle(int position) {
        widgetList.get(position).setTextColor(getResources().getColor(R.color.selected_color));
        lineViewlist.get(position).setBackgroundResource(R.color.selected_color);
    }

    private void clearStyle() {
        for (TextView tv : widgetList) {
            tv.setTextColor(getResources().getColor(R.color.unselected_color));
        }
        for (View view : lineViewlist) {
            view.setBackgroundColor(getResources().getColor(R.color.unselected_color));
        }

    }


    //viewpager的点击事件；
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_notebook:
                clearStyle();
                setStyle(0);
                viewPager.setCurrentItem(0);
                break;

            case R.id.bottom_bill:
                clearStyle();
                setStyle(1);
                viewPager.setCurrentItem(1);
                break;

            case R.id.bottom_account:
                clearStyle();
                setStyle(2);
                viewPager.setCurrentItem(2);
                break;
        }
    }

}
