package com.cyt.todayinformation.main.hangzhou.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cyt.todayinformation.R;
import com.cyt.todayinformation.main.shanghai.dto.ShanghaiBean;
import com.cyt.todayinformation.main.shanghai.dto.ShanghaiDetailBean;
import com.cyt.todayinformation.main.shanghai.view.ShanghaiDetailActivity;

import java.util.ArrayList;

public class ZhiHuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private ArrayList<ShanghaiDetailBean.XiaoHuaBean> mData;

    public ZhiHuAdapter(ArrayList<ShanghaiDetailBean.XiaoHuaBean> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, parent, false);
        ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(mView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShanghaiDetailBean.XiaoHuaBean xiaoHuaBean = mData.get(position);
        ((ShanghaiViewHolder) holder).mTvShangHaiItem.setText(xiaoHuaBean.content);
        ((ShanghaiViewHolder) holder).mIvShanghai.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvShangHaiItem;
        private ImageView mIvShanghai;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvShangHaiItem = itemView.findViewById(R.id.item_shanghai_tv);
            mIvShanghai = itemView.findViewById(R.id.item_shanghai_iv);
        }
    }

}
