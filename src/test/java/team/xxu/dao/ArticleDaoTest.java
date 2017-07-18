package team.xxu.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

import team.xxu.BaseTest;
import team.xxu.model.Article;

import javax.swing.plaf.basic.BasicViewportUI;

/**
 * Created by 26096 on 2017/7/17.
 */
public class ArticleDaoTest extends BaseTest{
    @Autowired
    private ArticleDao articleDao;

    @Test
    public void testUpdate() throws Exception {
       int a = articleDao.updateAuthor(1,"测试");

       System.out.println(a);
    }

}
