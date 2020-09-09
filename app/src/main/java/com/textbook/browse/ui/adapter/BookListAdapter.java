package com.textbook.browse.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.silang.superfileview.R;
import com.textbook.browse.face.OnItemClickListener;
import com.textbook.browse.model.Album;
import com.textbook.browse.model.VType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by v_jishuaipeng on 2020-09-03.
 * 描述: 教科书列表
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListHolder> {

    private ArrayList<Album> albums = new ArrayList<>();
    private Random random = new Random();
    private OnItemClickListener onItemClickListener;
    private Context mContext;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setAlbums(List<Album> albums) {
        this.albums.clear();
        this.albums.addAll(albums);
        notifyDataSetChanged();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mContext = recyclerView.getContext();
    }

    @Override
    public BookListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookListHolder(View.inflate(mContext, R.layout.item_booklist, null));
    }

    @Override
    public void onBindViewHolder(final BookListHolder holder, int position) {
        Album album = albums.get(position);
        holder.mTvDesc.setText(album.getDesc());
        holder.mTvTitle.setText(album.getName());
        holder.mTvThumb.setText(VType.getNumber(album.getGrade()));
        holder.mIvThumb.setBackgroundColor(Color.rgb(random.nextInt(255),
                random.nextInt(255), random.nextInt(255)));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class BookListHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvThumb;
        private final TextView mTvThumb;
        private final TextView mTvDesc;
        private final TextView mTvTitle;

        public BookListHolder(View itemView) {
            super(itemView);
            mIvThumb = (ImageView) itemView.findViewById(R.id.iv_thumb);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mTvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            mTvThumb = (TextView) itemView.findViewById(R.id.tv_thumb);
            itemView.setOnClickListener(new View.OnClickListener() {
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
