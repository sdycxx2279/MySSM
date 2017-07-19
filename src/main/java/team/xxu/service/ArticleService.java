package team.xxu.service;

import team.xxu.model.Article;

import java.util.List;

/**
 * Created by 26096 on 2017/7/17.
 */
public interface ArticleService {
    boolean addArticle(Article article);
    List<Article> getAllArticle();
    List<Article> getMyArticle(int author_id);
    Article getOneArticle(int id,boolean update);
    boolean updateArticle(Article article);
    boolean deleteArticle(int id);
}
