package sw.personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.personal.mapper.UserMapper;
import sw.personal.po.User;
import sw.personal.po.UserExample;
import sw.personal.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public List<User> queryByExample(String username){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = mapper.selectByExample(example);
        return users;
    }

    @Override
    public List<User> queryByUserName(String username){
        List<User> users = mapper.findByName(username);
        return users;
    }


}
