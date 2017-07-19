package team.xxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team.xxu.model.Article;
import team.xxu.model.User;
import team.xxu.service.ArticleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 26096 on 2017/7/17.
 */
@Controller
@RequestMapping("/article")
@Scope("prototype")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    //新增一篇文章
    @RequestMapping("/add")
    public String addArticle(Article article,HttpServletRequest request){
        if(article.getTitle()=="")
            request.setAttribute("message","标题不可为空");
        else if(article.getContent()=="")
            request.setAttribute("message","内容不可为空");
        else{
            HttpSession session = request.getSession();
            User LoginUser = (User)session.getAttribute("LoginUser");
            article.setAuthor(LoginUser.getNickname());
            article.setAuthor_id(LoginUser.getId());
            if(articleService.addArticle(article))
                return "redirect:/article/allArticles.do";
            else
                request.setAttribute("message","系统错误");
        }
        return "article";
    }

    //浏览全部文章概要
    @RequestMapping("/allArticles")
    public String getAllArticles(HttpServletRequest request){
        List<Article> articles = articleService.getAllArticle();
        request.setAttribute("articles",articles);

        request.setAttribute("my",false);
        return "index";
    }

    //浏览我的文章概要
    @RequestMapping("/myArticles")
    public String getMyArticles(HttpServletRequest request){
        HttpSession session = request.getSession();
        User author = (User)session.getAttribute("LoginUser");

        List<Article> articles = articleService.getMyArticle(author.getId());
        request.setAttribute("articles",articles);

        request.setAttribute("my",true);
        return "index";
    }

    //查看某文章详情
    @RequestMapping("/article/{id}")
    public String getOneArticle(@PathVariable("id") int id,HttpServletRequest request){
        Article article = articleService.getOneArticle(id,false);
        request.setAttribute("article",article);

        return "articleShow";
    }

    //查看可修改的文章详情
    @RequestMapping("/articleInfo/{id}")
    public String getArticleInfo(@PathVariable("id") int id,HttpServletRequest request){
        Article article = articleService.getOneArticle(id,true);
        request.setAttribute("article",article);
        request.setAttribute("update",true);

        return "article";
    }

    //用户更新自己的某篇文章
    @RequestMapping("/update/{id}")
    public String updateOneArticle(@PathVariable("id") int id,Article article,HttpServletRequest request){
        if(article.getTitle()=="")
            request.setAttribute("message","标题不可为空");
        else if(article.getContent()=="")
            request.setAttribute("message","内容不可为空");
        else {
            HttpSession session = request.getSession();
            User author = (User)session.getAttribute("LoginUser");
            article.setId(id);
            article.setAuthor_id(author.getId());
            article.setAuthor(author.getNickname());
            boolean message = articleService.updateArticle(article);
            if(!message)
                request.setAttribute("message","系统错误");
            else
                return "redirect:/article/myArticles.do";
        }
        request.setAttribute("article",articleService.getOneArticle(id,true));
        request.setAttribute("update",true);
        return "article";
    }

    //用户删除自己的某篇文章
    @RequestMapping("/delete")
    public String deleteOneArticle(int id,HttpServletRequest request){
        boolean message = articleService.deleteArticle(id);
        if(!message)
            request.setAttribute("message","系统错误");
        return "redirect:/article/myArticles.do";
    }
}
