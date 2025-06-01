package com.tugas.platform.wordpress;

public class PostModel {
    private String title;
    private String content;
    private String excerpt;
    private String imageUrl;
    private String author;
    private String date;
    private String slug;

    public PostModel(String title, String content, String excerpt,
                     String imageUrl, String author, String date, String slug) {
        this.title = title;
        this.content = content;
        this.excerpt = excerpt;
        this.imageUrl = imageUrl;
        this.author = author;
        this.date = date;
        this.slug = slug;
    }

    // Getters
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getExcerpt() { return excerpt; }
    public String getImageUrl() { return imageUrl; }
    public String getAuthor() { return author; }
    public String getDate() { return date; }
    public String getSlug() { return slug; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setExcerpt(String excerpt) { this.excerpt = excerpt; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setAuthor(String author) { this.author = author; }
    public void setDate(String date) { this.date = date; }
    public void setSlug(String slug) { this.slug = slug; }
}
