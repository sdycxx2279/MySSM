package team.xxu.service;

import team.xxu.model.Article;

import java.util.List;

/**
 * Created by 26096 on 2017/7/17.
 */
public interface ArticleService {
    public boolean addArticle(Article article);
    public List<Article> getAllArticle();
    public List<Article> getMyArticle(int author_id);
    public Article getOneArticle(int id);
    public boolean updateArticle(Article article);
    public boolean deleteArticle(int id);
}
