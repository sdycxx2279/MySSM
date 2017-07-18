package team.xxu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xxu.dao.ArticleDao;
import team.xxu.model.Article;
import team.xxu.service.ArticleService;

import java.util.Date;
import java.util.List;

/**
 * Created by 26096 on 2017/7/17.
 */
@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleDao articleMapper;

    //新建一篇文章
    public boolean addArticle(Article article){
        Date create_time = new Date();
        article.setCreate_time(create_time);
        int a = articleMapper.addArticle(article);

        if(a>0)
            return true;
        else
            return false;
    }

    //获取数据库内所有文章
    public List<Article> getAllArticle(){
        List<Article> articels = articleMapper.selectAllArticle();
        return articels;
    }

    //获取某人的所有文章
    public List<Article> getMyArticle(int author_id){
        List<Article> articels = articleMapper.selectByAuthor(author_id);
        return articels;
    }

    //获取某篇文章
    public Article getOneArticle(int id){
        Article article = articleMapper.selectById(id);
        return  article;
    }

    //修改某篇文章
    public boolean updateArticle(Article article){
        int a = articleMapper.updateById(article);
        if(a>0)
            return true;
        else
            return false;
    }

    //删除某篇文章
    public boolean deleteArticle(int id){
        int a = articleMapper.deleteById(id);
        if(a>0)
            return true;
        else
            return false;
    }
}
