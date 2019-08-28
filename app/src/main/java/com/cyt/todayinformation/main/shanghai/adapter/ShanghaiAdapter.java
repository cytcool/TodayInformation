package com.cyt.todayinformation.main.shanghai.adapter;

import android.content.Context;
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

import java.util.ArrayList;

public class ShanghaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ShanghaiBean> mData;

    private Context mContext;

    public ShanghaiAdapter(Context context,ArrayList<ShanghaiBean> data){
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL){
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
            ((ShanghaiViewHolderRv)holder).mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            ((ShanghaiViewHolderRv)holder).mRecyclerView.setAdapter(new ShanghaiAdapter(mContext,shanghaiBean.getData()));

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
        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder{

        private RecyclerView mRecyclerView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);

            mRecyclerView = itemView.findViewById(R.id.item_shanghai_rv);
        }
    }
}
