package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.UserMapper;
import edu.wwq.car.model.User;
import edu.wwq.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String userName, String password) {
        boolean result = false;
        User user = userMapper.getUserByUserNameAndPassword(userName, password);
        if (user != null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean insert(User user) {
        boolean result = false;
        int index = userMapper.insert(user);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        int index = userMapper.update(user);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        int index = userMapper.delete(id);
        if (index > 0) {
            result = true;
        }
        return result;
    }


}
