package com.example.vuejs_ex.service;

import com.example.vuejs_ex.dao.UserDAO;
import com.example.vuejs_ex.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final UserDAO userDAO;

    public List<UserVO> getAllUsers() throws Exception{
        return userDAO.getAllUsers();
    }

    public UserVO getUser(String id) throws Exception{
        return userDAO.getUser(id);
    }

    public int deleteUser(String id) throws Exception{
        return userDAO.deleteUser(id);
    }

    public int insertUser(UserVO userVO) throws Exception{
        return userDAO.insertUser(userVO);
    }

    public int updateUser(String id, UserVO userVO) throws Exception{
        userVO.setId(id);
        return userDAO.updateUser(userVO);
    }

}
