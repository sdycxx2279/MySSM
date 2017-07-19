package team.xxu.dao;

import org.apache.ibatis.annotations.Param;
import team.xxu.model.Article;

import java.util.Date;
import java.util.List;

/**
 * Created by 26096 on 2017/7/17.
 */
public interface ArticleDao {
    int addArticle(Article article);
    List<Article> selectAllArticle();
    Article selectById(int id);
    List<Article> selectByAuthor(int author_id);
    int updateById(Article article);
    int deleteById(int id);
    int updateAuthor(@Param("author_id") int author_id,@Param("author") String author);
    int updateViewed(int id);
}
