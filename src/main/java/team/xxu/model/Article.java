package team.xxu.model;

import java.util.Date;

/**
 * Created by 26096 on 2017/7/17.
 */
public class Article {
    private int id;
    private String title;
    private int author_id;
    private String author;
    private Date create_time;
    private String content;

    public Article() {
    }

    public Article(String title, int author_id, String author, Date create_time, String content) {
        this.title = title;
        this.author_id = author_id;
        this.author = author;
        this.create_time = create_time;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {

        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAuthor_id() {

        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author_id=" + author_id +
                ", author='" + author + '\'' +
                ", create_time=" + create_time +
                ", content='" + content + '\'' +
                '}';
    }
}
