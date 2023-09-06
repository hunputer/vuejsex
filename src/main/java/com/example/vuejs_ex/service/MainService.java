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

    public List<UserVO> getUser() throws Exception{
        return userDAO.getUser();
    }

    public int deleteUser(String id) throws Exception{
        return userDAO.deleteUser(id);
    }

    public int insertUser(UserVO userVO) throws Exception{
        return userDAO.insertUser(userVO);
    }

}
