package com.learn.bdc.nationalsday.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.learn.bdc.nationalsday.datalists.NotebookItem;
import com.learn.bdc.nationalsday.R;
import com.learn.bdc.nationalsday.datalists.NoteBookList;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/09/30.
 */
public class NotebookAdapter extends BaseAdapter {
    private List<NotebookItem> datas;
    private LayoutInflater inflater;

    public NotebookAdapter(Context context) {
        datas= NoteBookList.getInstance().getlist();
        inflater=LayoutInflater.from(context);

    }
    public NotebookAdapter(Context context,List<NotebookItem> datas) {
        this.datas=datas;
        inflater=LayoutInflater.from(context);

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
        ViewHolder holder;
        if (convertView==null){
            view=inflater.inflate(R.layout.bookadapter_item,null);
            holder=new ViewHolder();
            holder.notebookTitle= (TextView) view.findViewById(R.id.notebookTitle);
            holder.notebookContent= (TextView) view.findViewById(R.id.notebookContent);
            holder.noteDate= (TextView) view.findViewById(R.id.noteDate);
            view.setTag(holder);

        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }

        NotebookItem nbItem=datas.get(position);
        String dataString =new SimpleDateFormat("yyyy-MM-dd").format(nbItem.getmDate());
        holder.notebookTitle.setText(nbItem.getmTitle());
        holder.notebookContent.setText(nbItem.getmContent());
        holder.noteDate.setText(dataString);




        return view;
    }



    class ViewHolder{
        TextView notebookTitle;
        TextView notebookContent;
        TextView noteDate;
    }
}
