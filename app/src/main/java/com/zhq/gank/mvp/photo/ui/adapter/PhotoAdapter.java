package com.zhq.gank.mvp.photo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhq.gank.R;
import com.zhq.gank.common.Api;
import com.zhq.gank.mvp.photo.model.PhotoModel;
import com.zhq.gank.utils.ImageUitls;
import com.zhq.gank.widget.libraries.RatioImageView;

import java.util.List;

/**
 * 作者：hequnsky on 2016/8/4 14:45
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private List<PhotoModel.TngouBean> mData;
    private boolean mShowFooter = true;
    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public PhotoAdapter(Context context) {
        this.mContext = context;
    }

    public void setmDate(List<PhotoModel> data) {
        this.mData = data.get(0).getTngou();
        this.notifyDataSetChanged();

    }

    public void addDate(PhotoModel data) {
        this.mData.addAll(data.getTngou());
        this.notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (!mShowFooter) {
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
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.photolist_item, parent, false);

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
        if (holder instanceof ItemViewHolder) {

            String picUrl = Api.IMAGER_URL + mData.get(position).getImg() + "_320x480";

            Log.i("picUrl", picUrl);
            ImageUitls.loadLocal(mContext, picUrl, ((ItemViewHolder) holder).mNewsImg);
        }
    }

    @Override
    public int getItemCount() {
        int begin = mShowFooter ? 1 : 0;
        if (mData == null) {
            return begin;
        }
        return mData.size();
    }

    public PhotoModel.TngouBean getItem(int position) {
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


        public RatioImageView mNewsImg;

        public ItemViewHolder(View v) {
            super(v);

            mNewsImg = (RatioImageView) v.findViewById(R.id.picture);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }
}
