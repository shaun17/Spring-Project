package sw.personal.service;

import sw.personal.po.User;

import java.util.List;

public interface UserService {
    public List<User> queryByExample(String username);
}
