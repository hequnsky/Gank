package com.zhq.gank.mvp.video.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhq.gank.R;
import com.zhq.gank.mvp.video.model.VideoModel;
import com.zhq.gank.utils.ImageUitls;

import java.util.List;

/**
 * 作者：hequnsky on 2016/8/3 19:49
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class VideoAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private List<VideoModel.DataBean> mData;
    private boolean mShowFooter = true;
    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public VideoAdapter(Context context) {
        this.mContext = context;
    }

    public void setmDate(List<VideoModel> data) {
        this.mData = data.get(0).getData();
        this.notifyDataSetChanged();

    }

    public void addDate(VideoModel data){
        this.mData.addAll(data.getData());
        this.notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if(!mShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_news, parent, false);

            ItemViewHolder vh = new ItemViewHolder(v);
            return vh;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.footer, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).mTitle.setText(mData.get(position).getTitle());
            ((ItemViewHolder) holder).mDesc.setText(mData.get(position).getDesc());
            ImageUitls.loadLocal(mContext,mData.get(position).getPic_url(), ((ItemViewHolder) holder).mNewsImg);
        }
    }

    @Override
    public int getItemCount() {
        int begin = mShowFooter?1:0;
        if(mData == null) {
            return begin;
        }
        return  mData.size();
    }

    public VideoModel.DataBean getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public void isShowFooter(boolean showFooter) {
        this.mShowFooter = showFooter;
    }

    public boolean isShowFooter() {
        return this.mShowFooter;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View view) {
            super(view);
        }

    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public TextView mDesc;
        public ImageView mNewsImg;

        public ItemViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.tvTitle);
            mDesc = (TextView) v.findViewById(R.id.tvDesc);
            mNewsImg = (ImageView) v.findViewById(R.id.ivNews);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }
}
