package com.xupt.ttms.service.impl;/*
 * @author:ck
 * @param:
 * @date:2022/6/22
 * @description:
 */

import com.xupt.ttms.mapper.UserMapper;
import com.xupt.ttms.pojo.InsiderExample;
import com.xupt.ttms.pojo.User;
import com.xupt.ttms.pojo.UserExample;
import com.xupt.ttms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermapper;

    /*{
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        usermapper = sqlSession.getMapper(UserMapper.class);
    }*/

    /**
     * 根据用户名和密码登录
     */
    public User getUserByUsernameAndPwd(String userName, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(password);
        InsiderExample insiderExample = new InsiderExample();
        insiderExample.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(password);
        List<User> users = usermapper.selectByExample(userExample);
        if (users.size() == 0) {
            return null;
        } else {
            return users.get(0);
        }
    }

    /**
     * 判断用户名是否存在
     */
    public User getUserByUsername(String userName) {
        List<User> users = usermapper.select(userName);
        if (users.size() == 0)
            return null;
        else {
            return users.get(0);
        }
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public int register(User user) {
        return usermapper.insert(user);
    }

    /**
     * 根据用户名和手机号查找用户并修改密码
     */
    public int updateUserByUsernameAndPhone(String userName, String password, String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName).andPhoneEqualTo(phone);
        return usermapper.updateByExampleSelective(new User(password), userExample);
    }

    @Override
    public int recharge(BigDecimal balance,String username) {
        return usermapper.recharge(balance,username);
    }

}
