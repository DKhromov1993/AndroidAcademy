package com.example.den.androidacademyhomework.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsItem implements Serializable {

    private final String title;
    private final String imageUrl;
    private final Category category;
    private final Date publishDate;
    private final String previewText;
    private final String fullText;

    public NewsItem(String title, String imageUrl, Category category, Date publishDate, String previewText, String fullText) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.publishDate = publishDate;
        this.previewText = previewText;
        this.fullText = fullText;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getPublishDate(String dateFormatString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatString);
        return simpleDateFormat.format(publishDate);
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getFullText() {
        return fullText;
    }
}

