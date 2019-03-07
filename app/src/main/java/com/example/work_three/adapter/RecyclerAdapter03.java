package com.example.work_three.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.work_three.R;
import com.example.work_three.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

class RecyclerAdapter03 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ShowBean showBean;
    private ViewHolder holder;

    public RecyclerAdapter03(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.recyclerview_layout1, null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        holder.price_list.setText("¥"+showBean.getResult().getPzsh().get(0).getCommodityList().get(i).getPrice()+"");
        holder.title_list.setText(showBean.getResult().getPzsh().get(0).getCommodityList().get(i).getCommodityName());
        Uri uri = Uri.parse(showBean.getResult().getPzsh().get(0).getCommodityList().get(i).getMasterPic());
        holder.view_image_list.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return showBean.getResult().getPzsh().get(0).getCommodityList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView view_image_list;
        public final TextView price_list;
        public final TextView title_list;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view_image_list = itemView.findViewById(R.id.view_image);
            title_list = itemView.findViewById(R.id.title);
            price_list = itemView.findViewById(R.id.price);
        }
    }
}
