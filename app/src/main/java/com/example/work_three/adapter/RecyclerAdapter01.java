package com.example.work_three.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.work_three.R;
import com.example.work_three.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

class RecyclerAdapter01 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ViewHolder holder;

    public RecyclerAdapter01(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }

    private ShowBean showBean;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout1, viewGroup,false);
        //View view = View.inflate(context, R.layout.rb1_layout01, null);
        holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        holder.price.setText("¥"+showBean.getResult().getRxxp().get(0).getCommodityList().get(i).getPrice()+"");
        holder.title.setText(showBean.getResult().getRxxp().get(0).getCommodityList().get(i).getCommodityName());
        //Glide.with(context).load(rb1Bean.getResult().getPzsh().get(0).getCommodityList().get(i).getMasterPic()).into(holder.view_image);
        Uri uri = Uri.parse(showBean.getResult().getRxxp().get(0).getCommodityList().get(i).getMasterPic());
        holder.view_image.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return showBean.getResult().getRxxp().get(0).getCommodityList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView view_image;
        public final TextView price;
        public final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view_image = itemView.findViewById(R.id.view_image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
