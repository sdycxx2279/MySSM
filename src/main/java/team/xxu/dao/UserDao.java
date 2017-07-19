package team.xxu.dao;
import org.apache.ibatis.annotations.Param;
import team.xxu.model.User;

/**
 * Created by 26096 on 2017/7/15.
 */
public interface UserDao {
    //这里以接口形式定义了数据库操作方法,我们只需
    // 在Mybatis映射文件中对其进行映射就可以直接使用
    User selectById(int id);
    User selectByName(String username);
    int addUser(User user);
    int updateById(User user);
}
