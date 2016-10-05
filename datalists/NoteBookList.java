package com.learn.bdc.nationalsday.datalists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/09/30.
 */
public class NoteBookList {
    private static NoteBookList noteBookList;
    private List<NotebookItem> list;

    private NoteBookList() {
        list=new ArrayList<>();

        NotebookItem nbl1=new NotebookItem("国庆节快乐","明天就是国庆节了，大家一定要开开心心...");
        list.add(nbl1);

        NotebookItem nbl2=new NotebookItem("国庆节任务","1.完成截图中的界面。\n2.完成加法器的逻辑。\n3 查资料(Android屏幕适配方案）");
        list.add(nbl2);

        nbl1=new NotebookItem("1国庆节快乐","明天就是国庆节了，大家一定要开开心...");
        list.add(nbl1);

        nbl2=new NotebookItem("2国庆节任务","完图中的界面...");
        list.add(nbl2);

        nbl1=new NotebookItem("3国庆节快乐","明天就是国庆节了，大家一定开心...");
        list.add(nbl1);

        nbl2=new NotebookItem("4国庆节任务","完成的界面...");
        list.add(nbl2);

        nbl1=new NotebookItem("国庆节快乐","明天就是国庆节了，要开开心...");
        list.add(nbl1);

        nbl2=new NotebookItem("国庆节务","完成截图中的界面...");
        list.add(nbl2);

        nbl1=new NotebookItem("国庆节快乐","明就是国庆节了，要开开心...");
        list.add(nbl1);

        nbl2=new NotebookItem("国庆节任务","成截图中的界面...");
        list.add(nbl2);

        nbl1=new NotebookItem("国庆节快乐","明是国庆节了，要开开心...");
        list.add(nbl1);

        nbl2=new NotebookItem("国庆任务","完成截图中的界面...");
        list.add(nbl2);

        nbl1=new NotebookItem("13国庆节快乐","明是国庆节了，要开开心...");
        list.add(nbl1);

        nbl2=new NotebookItem("14国庆任务","完成截图中的界面...");
        list.add(nbl2);


    }

    public static NoteBookList getInstance(){
        if (noteBookList ==null){
            noteBookList =new NoteBookList();
        }
        return noteBookList;

    }

    public List<NotebookItem> getlist() {
        return list;
    }
}
