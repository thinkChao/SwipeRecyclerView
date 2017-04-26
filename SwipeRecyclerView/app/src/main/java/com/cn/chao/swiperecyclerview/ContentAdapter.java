package com.cn.chao.swiperecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by aChao on 2017/4/23.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private List<String> mItemContents;
    public static Context mContext;

    private static OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(View itemView);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layout;
        public TextView contentTextView;
        public TextView deleteTextView;
        public ViewHolder(final View itemView) {
            super(itemView);
            contentTextView = (TextView)itemView.findViewById(R.id.content_name);
            deleteTextView = (TextView)itemView.findViewById(R.id.content_delete);
            layout = (LinearLayout)itemView.findViewById(R.id.item_layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                        listener.onItemClick(itemView);
                }
            });
        }
    }


    public ContentAdapter(Context context,List<String> contents){
        mContext = context;
        mItemContents = contents;
    }

    private Context getContext(){
        return mContext;
    }

    @Override
    public ContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contentView = inflater.inflate(R.layout.item_content,parent,false);

        ViewHolder viewHolder = new ViewHolder(contentView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {
        String content = mItemContents.get(position);

        TextView textView = holder.contentTextView;
        textView.setText(content);
    }

    @Override
    public int getItemCount() {
        return mItemContents.size();
    }
}
