package com.textbook.browse.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.silang.superfileview.R;
import com.textbook.browse.face.OnItemClickListener;
import com.textbook.browse.model.Catalogue;
import com.textbook.browse.model.CatalogueFace;
import com.textbook.browse.model.CatalogueFactory;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by v_jishuaipeng on 2020-09-05.
 * 描述:
 */
public class CatalogueAdapter extends RecyclerView.Adapter<CatalogueAdapter.CatalogueHolder> {

    private int itemCount = 0;
    private RecyclerView mRecyclerView;
    private Context mContext;
    private OnItemClickListener onItemClickListener;
    private int mCurrentPage = 0;

    private List<Catalogue> list;
    private TreeMap<Integer, Catalogue> mapDatas = new TreeMap<>();
    private int headCount;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CatalogueAdapter(String filePath) {
        this.list = CatalogueFactory.getCatalogueList(filePath);
        this.headCount = CatalogueFactory.getHeads(filePath).length;
        this.mapDatas = CatalogueFactory.getCatalogueMap(filePath);
        this.itemCount = mapDatas.size();
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
    public void notifyCheckTextView(int oldPage, int newPage) {
        int flag = 0;
        for (Integer position : mapDatas.keySet()) {
            if (mapDatas.get(position).getPage() == newPage - headCount + 1) {
                flag = flag + 1;
                RecyclerView.ViewHolder newHolder = mRecyclerView.findViewHolderForLayoutPosition(position);
                if (newHolder != null) {
                    if (newHolder instanceof CatalogueHolder) {
                        ((CatalogueHolder) newHolder).mItemRoot.setSelected(true);
                    }
                }
            } else if (mapDatas.get(position).getPage() == oldPage - headCount + 1) {
                flag = flag + 1;
                RecyclerView.ViewHolder oldHolder = mRecyclerView.findViewHolderForLayoutPosition(position);
                if (oldHolder != null) {
                    if (oldHolder instanceof CatalogueHolder) {
                        ((CatalogueHolder) oldHolder).mItemRoot.setSelected(false);
                    }
                }
            }
            if (flag == 2) {
                return;
            }
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
    }

    @NonNull
    @Override
    public CatalogueAdapter.CatalogueHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = View.inflate(mContext, R.layout.item_node_01, null);
        return new CatalogueHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull CatalogueAdapter.CatalogueHolder holder, int i) {
        Catalogue catalogue = mapDatas.get(i);
        if (catalogue.getType() == CatalogueFace.TYPE_CATALOGUE) {
            holder.mTvName.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            holder.mTvName.setTextColor(Color.GREEN);
            holder.mTvDesc.setTextColor(Color.GREEN);
            holder.mTvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            holder.mTvDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        } else if (catalogue.getType() == CatalogueFace.TYPE_NODE) {
            holder.mTvName.setTextColor(Color.WHITE);
            holder.mTvDesc.setTextColor(Color.WHITE);
            holder.mTvName.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            holder.mTvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            holder.mTvDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        } else {
            holder.mTvName.setTextColor(Color.WHITE);
            holder.mTvDesc.setTextColor(Color.WHITE);
            holder.mTvName.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            holder.mTvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            holder.mTvDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        }
        holder.mTvName.setText(catalogue.chapterName);
        holder.mTvDesc.setText(catalogue.chapterDesc);
        holder.mTvPage.setText(String.valueOf(catalogue.getPage()));
        if (catalogue.getPage() == mCurrentPage - headCount + 1) {
            holder.mItemRoot.setSelected(true);
        } else {
            holder.mItemRoot.setSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    public Catalogue getItem(int position) {
        return mapDatas.get(position);
    }

    public class CatalogueHolder extends RecyclerView.ViewHolder {

        private final TextView mTvName;
        private final TextView mTvDesc;
        private final TextView mTvPage;
        private final View mItemRoot;

        public CatalogueHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvDesc = itemView.findViewById(R.id.tv_desc);
            mTvPage = itemView.findViewById(R.id.tv_page);
            mItemRoot = itemView.findViewById(R.id.item_root);
            mItemRoot.setOnClickListener(new View.OnClickListener() {
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
