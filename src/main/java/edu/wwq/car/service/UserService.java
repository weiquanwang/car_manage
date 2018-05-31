package edu.wwq.car.service;

import edu.wwq.car.model.User;

public interface UserService {

    boolean login(String userName, String password);

    boolean insert(User user);

    User getUserById(int id);

    boolean update(User user);

    boolean delete(int id);
}
