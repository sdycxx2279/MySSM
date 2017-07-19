package team.xxu.service;

import org.springframework.ui.Model;
import team.xxu.model.User;

/**
 * Created by 26096 on 2017/7/15.
 */

public interface UserService {
    User login(String username, String password);
    User register(User user);
    boolean hasUsername(String username);
    boolean updateOneUser(User user);
}