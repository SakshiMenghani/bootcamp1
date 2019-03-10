package com.example.sakshi.bootcamp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<RecyclerViewData> recyclerViewDataList = new ArrayList<>();



    public RecyclerViewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setRecyclerViewDataList(List<RecyclerViewData> recyclerViewDataList) {
        this.recyclerViewDataList = recyclerViewDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_view_icon, parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        final RecyclerViewData data = recyclerViewDataList.get(i);
        holder.txtName.setText(data.getName());
        holder.txtPhone.setText(data.getNumber());

        Glide.with(context).load(data.getImage()).apply(RequestOptions.circleCropTransform()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return  recyclerViewDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtName , txtPhone ;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtPhone = itemView.findViewById(R.id.txt_number);
            img = itemView.findViewById(R.id.img);
        }
    }
}
