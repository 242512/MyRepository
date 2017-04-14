package com.example.asus1.chatdemo2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by asus1 on 2017/3/29.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> list;
    public MsgAdapter(List<Msg> list)
    {
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Msg msg=list.get(position);
        if(msg.getType()==Msg.TYPE_RECEIVED)
        {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftTextView.setText(msg.getContent());
        }
        else
        {

                holder.rightLayout.setVisibility(View.VISIBLE);
                holder.leftLayout.setVisibility(View.GONE);
                holder.rightTextView.setText(msg.getContent());

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftTextView;
        TextView rightTextView;

        public ViewHolder(View view)
        {
            super(view);
            leftLayout= (LinearLayout) view.findViewById(R.id.leftLayout);
            rightLayout= (LinearLayout) view.findViewById(R.id.rightLayout);
            leftTextView= (TextView) view.findViewById(R.id.leftTextView);
            rightTextView= (TextView) view.findViewById(R.id.rightTextView);
        }
    }


}
