package com.learn.bdc.nationalsday;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.learn.bdc.nationalsday.datalists.Account;
import com.learn.bdc.nationalsday.datalists.Bill;
import com.learn.bdc.nationalsday.datalists.BillList;
import com.learn.bdc.nationalsday.datalists.IconLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MoneyRecordActivity extends Activity {
    private GridView incomeAndPay_gv;
    private SimpleAdapter adapterForPay;
    private SimpleAdapter adapterForIncome;
    private Spinner routeSp;
    private Button pay_button, income_button;
    private List<Button> buttonList=new ArrayList<>();
    private EditText output_et;
    private ImageView reason_img;
    private TextView reason_tv;
    private boolean balance=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_record);
        init();

    }

    private void init() {
        //初始化控件，并添加到list中
        reason_img= (ImageView) findViewById(R.id.reason_img);
        reason_tv= (TextView) findViewById(R.id.reason_tv);
        incomeAndPay_gv= (GridView) findViewById(R.id.income_gv);
        routeSp= (Spinner) findViewById(R.id.route_sp);
        pay_button= (Button) findViewById(R.id.pay_button);
        income_button= (Button) findViewById(R.id.income_button);
        output_et= (EditText) findViewById(R.id.output_et);
        buttonList.add((Button) findViewById(R.id.num_1));
        buttonList.add((Button) findViewById(R.id.num_2));
        buttonList.add((Button) findViewById(R.id.num_3));
        buttonList.add((Button) findViewById(R.id.num_4));
        buttonList.add((Button) findViewById(R.id.num_5));
        buttonList.add((Button) findViewById(R.id.num_6));
        buttonList.add((Button) findViewById(R.id.num_7));
        buttonList.add((Button) findViewById(R.id.num_8));
        buttonList.add((Button) findViewById(R.id.num_9));
        buttonList.add((Button) findViewById(R.id.num_zero));
        buttonList.add((Button) findViewById(R.id.num_ac));
        buttonList.add((Button) findViewById(R.id.num_add));
        buttonList.add((Button) findViewById(R.id.num_del));
        buttonList.add((Button) findViewById(R.id.num_ok));
        buttonList.add((Button) findViewById(R.id.num_point));
        buttonList.add(pay_button);
        buttonList.add(income_button);


        //设置按钮监听
        MyOnclickListener myOnclickListener=new MyOnclickListener();
        for (final Button button:buttonList) {
            button.setOnClickListener(myOnclickListener);
        }

        //显示下拉框（spinner)
        String[] spinerDatas={"现金","储蓄卡","信用卡","网络账户"};
        routeSp.setAdapter(new ArrayAdapter<>(MoneyRecordActivity.this,android.R.layout.simple_dropdown_item_1line,spinerDatas));

        //默认显示支付GridView；
        showPayGridView();

        //Gridview的点击事件
        incomeAndPay_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String reason;
                if(balance){
                     reason= (String) IconLists.getIncomeIconDatas().get(position).get("info");
                }
                else {
                    reason= (String) IconLists.getPayIconData().get(position).get("info");
                }
                int iconId=IconLists.getIconMap().get(reason);
                reason_img.setImageResource(iconId);
                reason_tv.setText(reason);

            }
        });

        //GridView  设置手势滑动事件
        incomeAndPay_gv.setOnTouchListener(new MyGestureListener());

    }

    //显示支出的GridView
    private void showPayGridView() {
        List<Map<String,Object>> payIconDatas= IconLists.getPayIconData();
        String[] from={"img","info"};
        int[] to={R.id.pay_img,R.id.pay_info};
        adapterForPay=new SimpleAdapter(MoneyRecordActivity.this,payIconDatas,R.layout.pay_gridview_item,from,to);
        incomeAndPay_gv.setAdapter(adapterForPay);
    }
    //显示收入的GridView
    private void showIncomeGridView(){
        List<Map<String,Object>> incomeIconDatas=IconLists.getIncomeIconDatas();
        String[] from={"img","info"};
        int[] to={R.id.pay_img,R.id.pay_info};
        adapterForIncome=new SimpleAdapter(MoneyRecordActivity.this,incomeIconDatas,R.layout.pay_gridview_item,from,to);
        incomeAndPay_gv.setAdapter(adapterForIncome);
    }

    //记录收支状况，存入数据list中；
    private void balanceRecorded() {
        double sum=Double.parseDouble(output_et.getText().toString());
        String reason=reason_tv.getText().toString();
        Bill bill=new Bill(sum,reason,balance);
        BillList.getInstance().getListDatas().add(bill);
        String moneyAccount= (String) routeSp.getSelectedItem();
        int way=balance?1:-1;
        switch (moneyAccount) {
            case "现金":
                Account.cash+=(way*sum);
                break;
            case "储蓄卡":
                Account.deposit+=(way*sum);
                break;
            case "信用卡":
                Account.creditCard+=(way*sum);
                break;
            case "网络账户":
                Account.alipay+=(way*sum);
                break;



        }


    }

    //切换到收入界面方法
    private void doRightSlide() {
        balance=true;
        reason_img.setImageResource(R.drawable.type_big_13);
        reason_tv.setText("工资");
        income_button.setBackgroundResource(R.color.button_pressed);
        pay_button.setBackgroundResource(R.color.button_not_pressed);
        showIncomeGridView();
    }
    //切换到支出界面方法
    private void doLeftSlide() {
        balance=false;
        reason_img.setImageResource(R.drawable.type_big_1);
        reason_tv.setText("一般");
        pay_button.setBackgroundResource(R.color.button_pressed);
        income_button.setBackgroundResource(R.color.button_not_pressed);
        showPayGridView();
    }


    //点击监听器类
    class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.pay_button:
                    doLeftSlide();

                    break;

                case R.id.income_button:
                    doRightSlide();
                    break;
                case R.id.num_zero:
                    String sOutput = output_et.getText().toString();
                    if (sOutput.equals("")){
                        output_et.append("0");
                    }else {
                        if (!sOutput.equals("0")) {
                            if (sOutput.contains("+")&&(sOutput.substring(sOutput.lastIndexOf("+")+1).equals("0"))){
                                break;
                            }
                            else{
                                output_et.append("0");
                             }
                        }


                    }
                    break;
                case R.id.num_point:
                    String pointString=output_et.getText().toString();
                    if (!pointString.contains(".")){
                        output_et.append(".");
                    }else{
                        if(!pointString.contains("+")){
                                break;
                        }
                        else{
                            if ((pointString.substring(pointString.lastIndexOf("+")).contains("."))){
                            break;
                            }
                            output_et.append(".");
                        }
                    }
                    break;

                case R.id.num_add:
                    String outputString=output_et.getText().toString();


                    if (outputString.equals("")){
                        break;
                    }else {
                        if ((outputString.charAt(outputString.length()-1)!='+')&&(outputString.charAt(outputString.length()-1)!='.')) {
                            output_et.append("+");
                        }
                    }

                    break;

                case R.id.num_ac:
                    output_et.setText("");

                    break;

                case R.id.num_del:
                    String  outString=output_et.getText().toString();
                    if(!outString.equals("")) {
                        output_et.setText(outString.substring(0, outString.length()-1));
                    }
                    break;

                case R.id.num_ok:

                    String output=output_et.getText().toString();
                    if (output.equals("")){
                        break;
                    }
                    String[] number=output.split("\\+");
                    float sum=0;

                    for (int i = 0; i < number.length; i++) {
                        sum+=Double.parseDouble(number[i]);
                    }
                    output_et.setText(sum+"");
                    balanceRecorded();
                    MainActivity.showAccountMoney();




                    break;

               default:
                   if (output_et.getText().toString().equals("0")){
                       output_et.setText(((Button)v).getText().toString());
                   }else{
                       output_et.append(((Button) v).getText().toString());
                   }
                   break;
            }

        }
    }


    //滑动监听器
    class MyGestureListener implements View.OnTouchListener{
        private GestureDetector mGestureDetector;

        public MyGestureListener() {
            mGestureDetector = new GestureDetector(new GestListener());

        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return mGestureDetector.onTouchEvent(event);
        }

        class GestListener implements GestureDetector.OnGestureListener{

            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                float x=e2.getX()-e1.getX();
                if(x<0){
                    if(!balance){
                         doRightSlide();
                    }

                }else{
                    if (balance) {
                        doLeftSlide();
                    }

                }
                return true;
            }
        }
    }









}
