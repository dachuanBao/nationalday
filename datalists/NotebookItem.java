package com.learn.bdc.nationalsday.datalists;

import java.util.Date;

/**
 * Created by Administrator on 2016/09/30.
 */
public class NotebookItem {
    private String mTitle;
    private Date mDate;
    private String mContent;


    public NotebookItem(String mTitle, String mContent) {
        this.mTitle = mTitle;

        this.mContent = mContent;
        mDate=new Date();
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}
