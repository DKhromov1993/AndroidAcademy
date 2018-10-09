package com.example.den.androidacademyhomework;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.den.androidacademyhomework.Data.NewsItem;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<NewsItem> news;
    private Context context;
    OnItemClickListener mItemClickListener;



    public NewsAdapter(Context context, List<NewsItem> news){
        this.context = context;
        this.news = news;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.news_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        NewsItem currentNews = news.get(i);
        viewHolder.newsImage.setImageURI(Uri.parse(currentNews.getImageUrl()));
        Glide.with(context).load(currentNews.getImageUrl()).into(viewHolder.newsImage);
        viewHolder.newsText.setText(currentNews.getFullText());
        viewHolder.newsTitle.setText(currentNews.getPreviewText());
        viewHolder.newsCategory.setText(currentNews.getCategory().getName());
        viewHolder.newsDate.setText(currentNews.getPublishDate().toString());
        viewHolder.itemView.setTag(currentNews);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView newsCategory;
        TextView newsTitle;
        TextView newsText;
        ImageView newsImage;
        TextView newsDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsCategory = itemView.findViewById(R.id.card_category);
            newsTitle = itemView.findViewById(R.id.card_title);
            newsText = itemView.findViewById(R.id.card_news_text);
            newsImage = itemView.findViewById(R.id.card_image);
            newsDate = itemView.findViewById(R.id.card_date);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            NewsItem currentNewsItem = (NewsItem) view.getTag();
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(currentNewsItem);
            }
        }


    }

    public interface OnItemClickListener {
        void onItemClick(NewsItem newsItem);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
