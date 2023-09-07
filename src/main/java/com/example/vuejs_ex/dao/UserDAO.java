package com.example.vuejs_ex.dao;


import com.example.vuejs_ex.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    List<UserVO> getAllUsers();

    UserVO getUser(String id);

    int deleteUser(String id);

    int insertUser(UserVO userVO);

    int updateUser(UserVO userVO);

}
