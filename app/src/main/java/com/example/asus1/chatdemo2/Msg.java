package com.example.asus1.chatdemo2;

/**
 * Created by asus1 on 2017/3/29.
 */

public class Msg {

    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;

    public String getContent() {
        return content;
    }

    private String content;

    public int getType() {
        return type;
    }

    private int type;

    public Msg(int type,String content)
    {
        this.type=type;
        this.content=content;
    }

}
