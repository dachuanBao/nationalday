package com.learn.bdc.nationalsday.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.bdc.nationalsday.R;
import com.learn.bdc.nationalsday.datalists.Bill;
import com.learn.bdc.nationalsday.datalists.BillList;
import com.learn.bdc.nationalsday.datalists.IconLists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/01.
 */
public class MyBillAdapter extends BaseAdapter{
    private List<Bill> datas;
    private LayoutInflater inflater;
    private Map<String,Integer> iconMap;

    public MyBillAdapter(Context context) {
        datas= BillList.getInstance().getListDatas();
        inflater=LayoutInflater.from(context);
        iconMap=IconLists.getIconMap();



    }


    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas==null?null:datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        BillViewHolder holder;
        if (convertView==null){
            view=inflater.inflate(R.layout.bill_listview_item,null);
            holder=new BillViewHolder();
            holder.img= (ImageView) view.findViewById(R.id.bill_img);
            holder.left_tv= (TextView) view.findViewById(R.id.bill_left_tv);
            holder.right_tv= (TextView) view.findViewById(R.id.bill_right_tv);
            view.setTag(holder);


        }

        else{
            view=convertView;
            holder= (BillViewHolder) view.getTag();
        }
        Bill bill=datas.get(position);
        double num=bill.getNum();
        boolean balance=bill.isBalance();
        String reason=bill.getReason();
        if (balance){
            holder.left_tv.setText(reason+num);
            holder.right_tv.setText("");

        }
        else {
            holder.left_tv.setText("");
            holder.right_tv.setText(reason+num);
        }
        holder.img.setImageResource(iconMap.get(reason));
        return view;
    }


    class BillViewHolder {
        ImageView img;
        TextView right_tv;
        TextView left_tv;
    }
}
