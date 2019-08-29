package com.cyt.todayinformation.main.shanghai.adapter;

import android.app.Activity;
import android.content.Context;
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
import com.cyt.todayinformation.main.shanghai.view.ShanghaiDetailActivity;

import java.util.ArrayList;

public class ShanghaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ShanghaiBean> mData;

    private Activity mContext;
    private Boolean mIsHor;
    private RecyclerView.RecycledViewPool mRecyclerViewPool;

    public ShanghaiAdapter(Activity context,ArrayList<ShanghaiBean> data,boolean isHor){
        this.mRecyclerViewPool = new RecyclerView.RecycledViewPool();
        this.mContext = context;
        this.mData = data;
        this.mIsHor = isHor;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL){
            if (mIsHor){
                Log.e("onCreateViewHolder","VERTICAL");
            }
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment,parent,false);
            ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(mView);
            return viewHolder;
        }else if (viewType == ShanghaiBean.IShanghaiItemType.HORIZANTAL){
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_rv,parent,false);
            ShanghaiViewHolderRv viewHolder = new ShanghaiViewHolderRv(mView);
            return viewHolder;
        }

        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShanghaiBean shanghaiBean = mData.get(position);
        if (holder instanceof ShanghaiViewHolder){
            ((ShanghaiViewHolder)holder).mTvShangHaiItem.setText(shanghaiBean.getmDec());
            ((ShanghaiViewHolder)holder).mIvShanghai.setVisibility(shanghaiBean.isShowImg()?View.VISIBLE:View.GONE);
        }else if (holder instanceof ShanghaiViewHolderRv){
            ((ShanghaiViewHolderRv)holder).mRecyclerView.setAdapter(new ShanghaiAdapter(mContext,shanghaiBean.getData(),true));

        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmItemType();
    }

    public class ShanghaiViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvShangHaiItem;
        private ImageView mIvShanghai;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvShangHaiItem = itemView.findViewById(R.id.item_shanghai_tv);
            mIvShanghai = itemView.findViewById(R.id.item_shanghai_iv);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShanghaiDetailActivity.start(mContext,mIvShanghai);
                }
            });
        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder{

        private RecyclerView mRecyclerView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_shanghai_rv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setRecycledViewPool(mRecyclerViewPool);
        }
    }
}
