package team.xxu.dao;

import org.apache.ibatis.annotations.Param;
import team.xxu.model.Article;

import java.util.Date;
import java.util.List;

/**
 * Created by 26096 on 2017/7/17.
 */
public interface ArticleDao {
    public int addArticle(Article article);
    public List<Article> selectAllArticle();
    public Article selectById(int id);
    public List<Article> selectByAuthor(int author_id);
    public int updateById(Article article);
    public int deleteById(int id);
    public int updateAuthor(@Param("author_id") int author_id,@Param("author") String author);
    public int updateViewed(int id);
}
