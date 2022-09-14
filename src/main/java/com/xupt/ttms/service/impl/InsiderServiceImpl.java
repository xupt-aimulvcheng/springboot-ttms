package com.xupt.ttms.service.impl;/*
 * @author:ck
 * @param:
 * @date:2022/7/7
 * @description:
 */

import com.xupt.ttms.mapper.InsiderMapper;
import com.xupt.ttms.pojo.Insider;
import com.xupt.ttms.pojo.InsiderExample;
import com.xupt.ttms.service.InsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class InsiderServiceImpl implements InsiderService {
    @Autowired
    private InsiderMapper insidermapper;

    /**
     * 根据用户名和密码登录
     */
    public Insider getUserByUsernameAndPwd(String userName, String password, String job) {
        InsiderExample insiderExample = new InsiderExample();
        insiderExample.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(password);
        List<Insider> insiders = insidermapper.selectByExample(insiderExample);
        if (insiders.size() == 0) {
            return null;
        } else {
            return insiders.get(0);
        }

    }

    /**
     * 根据用户名登录
     */
    public Insider getUserByUsername(String userName) {
        InsiderExample userExample = new InsiderExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        List<Insider> users = insidermapper.selectByExample(userExample);
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
    public int register(Insider user) {
        return insidermapper.insert(user);
    }

    /**
     * 根据用户名和手机号查找用户并修改密码
     */
    public int updateUserByUsernameAndPhone(String userName, String password, String phone,String job) {
        InsiderExample userExample = new InsiderExample();
        userExample.createCriteria().andUsernameEqualTo(userName).andPhoneEqualTo(phone).andJobEqualTo(job);
        return insidermapper.updateByExampleSelective(new Insider(password), userExample);
    }

}
