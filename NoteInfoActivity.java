package com.learn.bdc.nationalsday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.learn.bdc.nationalsday.datalists.NoteBookList;
import com.learn.bdc.nationalsday.datalists.NotebookItem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteInfoActivity extends Activity {
    private Button trashBin,pen;
    private EditText note_title,note_content;
    int postitionData=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_info);
        init();
        Intent intent=getIntent();
        postitionData=intent.getIntExtra("item_position",-1);
        if (postitionData!=-1) {
            String itemTitle = NoteBookList.getInstance().getlist().get(postitionData).getmTitle();
            String itemContent = NoteBookList.getInstance().getlist().get(postitionData).getmContent();
            note_title.setText(itemTitle);
            note_content.setText(itemContent);
        }
    }

    private void init() {
        trashBin= (Button) findViewById(R.id.trashBin);
        pen= (Button) findViewById(R.id.pen);
        note_title= (EditText) findViewById(R.id.note_title);
        note_content= (EditText) findViewById(R.id.note_content);

        trashBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note_title.setText("");
                note_content.setText("");

            }
        });

        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String title=note_title.getText().toString();
                String content=note_content.getText().toString();
                if(postitionData!=-1){
                    if(title.equals("")&&content.equals("")){
                        NoteBookList.getInstance().getlist().remove(postitionData);


                    }
                    else{
                        NoteBookList.getInstance().getlist().get(postitionData).setmTitle(title.equals("") ? "无标题" : title);
                        Date date=NoteBookList.getInstance().getlist().get(postitionData).getmDate();
                        String dateString=new SimpleDateFormat("yyyy-MM-dd").format(date);
                        NoteBookList.getInstance().getlist().get(postitionData).setmContent(content);
                    }
                }
                else {
                    addToList(title, content);
                }
                Intent intent=new Intent(NoteInfoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void addToList(String title, String content) {
        if (!title.equals("")){
            NotebookItem item=new NotebookItem(title,content);
            NoteBookList.getInstance().getlist().add(item);


        }else{
            if(!content.equals("")){
                title="无标题";
                NotebookItem item=new NotebookItem(title,content);
                NoteBookList.getInstance().getlist().add(item);
            }

        }
    }
}
