package com.example.work_three.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.work_three.R;
import com.example.work_three.bean.ShowBean;

public class ShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ShowBean showBean;
    private final int ONE = 0;
    private final int TWO = 1;
    private final int THREE = 2;

    public ShowAdapter(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == ONE) {
            View view = LayoutInflater.from(context).inflate(R.layout.show_layout01, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        } else if (i == TWO) {
            View view = LayoutInflater.from(context).inflate(R.layout.show_layout02, viewGroup, false);
            return new ViewHolder1(view);
        }
        return new ViewHolder2(LayoutInflater.from(context).inflate(R.layout.show_layout03, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            LinearLayoutManager layoutManagers = new LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false);
            ((ViewHolder) viewHolder).recyclerView.setLayoutManager(layoutManagers);
            RecyclerAdapter01 myAdapter = new RecyclerAdapter01(context, showBean);
            ((ViewHolder) viewHolder).recyclerView.setAdapter(myAdapter);
            ((ViewHolder) viewHolder).text_rxxp.setText(showBean.getResult().getRxxp().get(0).getName());
        } else if (viewHolder instanceof ViewHolder1) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, OrientationHelper.VERTICAL, false);
            ((ViewHolder1) viewHolder).recyclerView1.setLayoutManager(layoutManager);
            RecyclerAdapter02 myAdapterTwo = new RecyclerAdapter02(context, showBean);
            ((ViewHolder1) viewHolder).recyclerView1.setAdapter(myAdapterTwo);
            ((ViewHolder1) viewHolder).text_mlss.setText(showBean.getResult().getPzsh().get(0).getName());
        } else if (viewHolder instanceof ViewHolder2) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            ((ViewHolder2) viewHolder).recyclerView2.setLayoutManager(gridLayoutManager);
            RecyclerAdapter03 myAdapterThree = new RecyclerAdapter03(context, showBean);
            ((ViewHolder2) viewHolder).recyclerView2.setAdapter(myAdapterThree);
            ((ViewHolder2) viewHolder).text_pzsh.setText(showBean.getResult().getMlss().get(0).getName());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == ONE) {
            return ONE;
        } else if (position == TWO) {
            return TWO;
        }
        return THREE;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text_rxxp;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler);
            text_rxxp = itemView.findViewById(R.id.text_rxxp);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView text_mlss;
        private RecyclerView recyclerView1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            recyclerView1 = itemView.findViewById(R.id.recycler1);
            text_mlss = itemView.findViewById(R.id.text_mlss);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private final TextView text_pzsh;
        private RecyclerView recyclerView2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            recyclerView2 = itemView.findViewById(R.id.recycler2);
            text_pzsh = itemView.findViewById(R.id.text_pzsh);
        }
    }

}
