package com.learn.bdc.nationalsday.datalists;

import android.content.Intent;
import android.media.JetPlayer;

import com.learn.bdc.nationalsday.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/01.
 */
public class IconLists {


    public static List<Map<String,Object>> getPayIconData() {
        List<Map<String,Object>> payIconDatas=new ArrayList<>();
        Map<String,Object> data=new HashMap();
        data.put("img", R.drawable.type_big_1);
        data.put("info","一般");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_2);
        data.put("info","用餐");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_3);
        data.put("info","零食");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_4);
        data.put("info","交通");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_5);
        data.put("info","充值");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_6);
        data.put("info","购物");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_7);
        data.put("info","娱乐");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_8);
        data.put("info","住房");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_9);
        data.put("info","约会");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_10);
        data.put("info","网购");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_11);
        data.put("info","日用品");
        payIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_12);
        data.put("info","香烟");
        payIconDatas.add(data);


        return  payIconDatas;
    }

    public static List<Map<String,Object>> getIncomeIconDatas(){
        List<Map<String,Object>> incomIconDatas=new ArrayList<>();
        Map<String,Object> data=new HashMap();
        data.put("img",R.drawable.type_big_13);
        data.put("info","工资");
        incomIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_14);
        data.put("info","外快兼职");
        incomIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_15);
        data.put("info","奖金");
        incomIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_16);
        data.put("info","借入");
        incomIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_17);
        data.put("info","零花钱");
        incomIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_18);
        data.put("info","投资收入");
        incomIconDatas.add(data);

        data=new HashMap();
        data.put("img",R.drawable.type_big_19);
        data.put("info","礼物红包");
        incomIconDatas.add(data);

        return  incomIconDatas;
    }

    public static Map<String,Integer> getIconMap(){
        Map<String,Integer> iconMap =new HashMap<>();
        iconMap.put("一般",R.drawable.type_big_1);
        iconMap.put("用餐",R.drawable.type_big_2);
        iconMap.put("零食",R.drawable.type_big_3);
        iconMap.put("交通",R.drawable.type_big_4);
        iconMap.put("充值",R.drawable.type_big_5);
        iconMap.put("购物",R.drawable.type_big_6);
        iconMap.put("娱乐",R.drawable.type_big_7);
        iconMap.put("住房",R.drawable.type_big_8);
        iconMap.put("约会",R.drawable.type_big_9);
        iconMap.put("网购",R.drawable.type_big_10);
        iconMap.put("日用品",R.drawable.type_big_11);
        iconMap.put("香烟",R.drawable.type_big_12);
        iconMap.put("工资",R.drawable.type_big_13);
        iconMap.put("外快兼职",R.drawable.type_big_14);
        iconMap.put("奖金",R.drawable.type_big_15);
        iconMap.put("借入",R.drawable.type_big_16);
        iconMap.put("零花钱",R.drawable.type_big_17);
        iconMap.put("投资收入",R.drawable.type_big_18);
        iconMap.put("礼物红包",R.drawable.type_big_19);


        return iconMap;

    }

}
