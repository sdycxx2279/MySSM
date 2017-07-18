package team.xxu.dao;
import org.apache.ibatis.annotations.Param;
import team.xxu.model.User;

/**
 * Created by 26096 on 2017/7/15.
 */
public interface UserDao {
    //这里以接口形式定义了数据库操作方法,我们只需
    // 在Mybatis映射文件中对其进行映射就可以直接使用
    public User selectById(int id);
    public User selectByName(String username);
    public int addUser(User user);
    public int updateById(User user);
}
