package com.example.asus1.chatdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> list;
    public RecyclerView recyclerView;
    public EditText editText;
    public Button sendBut;
    public Button receBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main_layout);

        recyclerView= (RecyclerView) findViewById(R.id.recycleView);
        editText= (EditText) findViewById(R.id.editText);
        sendBut= (Button) findViewById(R.id.sendBut);
        receBut= (Button) findViewById(R.id.receBut);

        list=new ArrayList<Msg>();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        final MsgAdapter adapter=new MsgAdapter(list);
        recyclerView.setAdapter(adapter);

        sendBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=editText.getText().toString();

                if(content!=null&&content!="")
                {
                    Msg msg=new Msg(Msg.TYPE_SENT,content);
                    list.add(msg);

                    adapter .notifyItemInserted(list.size()-1);//刷新显示
                    recyclerView.scrollToPosition(list.size()-1);
                    editText.setText("");
                }
            }
        });

        receBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=editText.getText().toString();
                if(content!=null && content!="")
                {
                    Msg msg=new Msg(Msg.TYPE_RECEIVED,content);
                    list.add(msg);


                    adapter .notifyItemInserted(list.size()-1);//刷新显示
                    recyclerView.scrollToPosition(list.size()-1);
                    editText.setText("");
                }
            }
        });
    }
}
