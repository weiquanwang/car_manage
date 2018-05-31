package edu.wwq.car.mapper;

import edu.wwq.car.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insert(User user);

    User getUserById(@Param("id") Integer id);

    int update(User user);

    User getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    int delete(@Param("id") Integer id);

}