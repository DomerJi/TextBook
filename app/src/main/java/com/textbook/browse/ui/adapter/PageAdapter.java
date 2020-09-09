package com.textbook.browse.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silang.superfileview.R;
import com.textbook.browse.face.OnItemClickListener;
import com.textbook.browse.model.CatalogueFace;
import com.textbook.browse.util.PageUtil;

/**
 * Created by v_jishuaipeng on 2020-09-05.
 * 描述:
 */
public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private PageUtil catalogueUtil;
    private int itemCount = 0;
    private RecyclerView mRecyclerView;
    private Context mContext;
    private OnItemClickListener onItemClickListener;
    private int itemViewWidth = -1;
    private int mCurrentPage = 0;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setCurrentPage(int mCurrentPage) {
        this.mCurrentPage = mCurrentPage;
    }

    public void setCurrentPageNotify(int mCurrentPage) {
        if (this.mCurrentPage != mCurrentPage) {
            notifyCheckTextView(this.mCurrentPage, mCurrentPage);
            this.mCurrentPage = mCurrentPage;
        }
    }

    /**
     * 只刷新 选中按钮
     */
    public void notifyCheckTextView(int oldPosition, int newPosition) {
        RecyclerView.ViewHolder holder = mRecyclerView.findViewHolderForLayoutPosition(oldPosition);
        RecyclerView.ViewHolder newHolder = mRecyclerView.findViewHolderForLayoutPosition(newPosition);
        if (holder != null) {
            if (holder instanceof CatalogueHeadHolder) {
                ((CatalogueHeadHolder) holder).mTvItem.setSelected(false);
            } else if (holder instanceof CatalogueHolder) {
                ((CatalogueHolder) holder).mTvItem.setSelected(false);
            }
        }
        if (newHolder != null) {
            if (newHolder instanceof CatalogueHolder) {
                ((CatalogueHolder) newHolder).mTvItem.setSelected(true);
            } else if (newHolder instanceof CatalogueHeadHolder) {
                ((CatalogueHeadHolder) newHolder).mTvItem.setSelected(true);
            }
        }
    }


    public PageAdapter(@NonNull PageUtil catalogueUtil) {
        this.catalogueUtil = catalogueUtil;
        itemCount = this.catalogueUtil.getDatas().size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == CatalogueFace.TYPE_HEAD) {
            View itemView = View.inflate(mContext, R.layout.item_catalogue_head, null);
            if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                int pLfet = itemView.getPaddingLeft();
                int pRight = itemView.getPaddingRight();
                int rvLeft = mRecyclerView.getPaddingLeft();
                int rvRight = mRecyclerView.getPaddingRight();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) mRecyclerView.getLayoutManager();
                // 计算单个ImageView的宽度
                itemViewWidth = ((mRecyclerView.getWidth() - rvLeft - rvRight) / gridLayoutManager.getSpanCount())
                        - pLfet - pRight;
            }
            return new CatalogueHeadHolder(itemView);
        } else {
            View itemView = View.inflate(mContext, R.layout.item_catalogue, null);
            return new CatalogueHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if (holder instanceof CatalogueHeadHolder) {
            CatalogueHeadHolder headHolder = (CatalogueHeadHolder) holder;
            if (itemViewWidth != -1 && catalogueUtil.getHeadCount() == (i + 1)) {
                ViewGroup.LayoutParams layoutParams = headHolder.itemView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                }
                layoutParams.width = itemViewWidth;
                headHolder.itemView.setLayoutParams(layoutParams);
            }
            headHolder.mTvItem.setText(catalogueUtil.getDatas().get(i).name);
            headHolder.mTvItem.setSelected(mCurrentPage == i);
        } else {
            CatalogueHolder bodyHolder = (CatalogueHolder) holder;
            bodyHolder.mTvItem.setText(catalogueUtil.getDatas().get(i).name);
            bodyHolder.mTvItem.setSelected(mCurrentPage == i);
        }
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return catalogueUtil.getDatas().get(position).type;
    }

    public class CatalogueHolder extends RecyclerView.ViewHolder {

        private final TextView mTvItem;

        public CatalogueHolder(@NonNull View itemView) {
            super(itemView);
            mTvItem = itemView.findViewById(R.id.tv_item);
            mTvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    public class CatalogueHeadHolder extends RecyclerView.ViewHolder {

        private final TextView mTvItem;

        public CatalogueHeadHolder(@NonNull View itemView) {
            super(itemView);
            mTvItem = itemView.findViewById(R.id.tv_item);
            mTvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

}
