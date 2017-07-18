package team.xxu.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import team.xxu.BaseTest;
import team.xxu.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 26096 on 2017/7/15.
 */
public class UserDaoTest extends BaseTest{
    @Autowired
    private UserDao userDao;

    @Test
    public void testupdate() throws Exception {
    }
}
