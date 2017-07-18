package team.xxu.service;

import org.springframework.ui.Model;
import team.xxu.model.User;

/**
 * Created by 26096 on 2017/7/15.
 */

public interface UserService {
    public User login(String username, String password);
    public User register(User user);
    public boolean hasUsername(String username);
    public boolean updateOneUser(User user);
}