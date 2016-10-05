package com.learn.bdc.nationalsday.datalists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/01.
 */
public class BillList {
    private static BillList billList;
    private List<Bill> listDatas;

    private BillList(){
        listDatas=new ArrayList<>();
        listDatas.add(new Bill(12,"用餐",false));
        listDatas.add(new Bill(42,"礼物红包",true));



    }

    public static BillList getInstance(){
        if (billList==null){
            billList=new BillList();
        }
        return billList;
    }

    public List<Bill> getListDatas() {
        return listDatas;
    }

    public void setListDatas(List<Bill> listDatas) {
        this.listDatas = listDatas;
    }
}
