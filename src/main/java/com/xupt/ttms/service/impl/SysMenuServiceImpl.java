package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.SysMenuMapper;
import com.xupt.ttms.mapper.SystemMenuMapper;
import com.xupt.ttms.pojo.MenuVo;
import com.xupt.ttms.pojo.SysMenu;
import com.xupt.ttms.service.SysMenuService;
import com.xupt.ttms.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SystemMenuMapper sysMenuRepository;
    @Override
    public Map<String, Object> menu() {
        Map<String, Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        List<SysMenu> menuList = sysMenuRepository.selectList(null);
        List<MenuVo> menuInfo = new ArrayList<>();
        System.out.println(menuInfo);
        for (SysMenu e : menuList) {
            MenuVo menuVO = new MenuVo();
            menuVO.setId(e.getId());
            menuVO.setPid(e.getPid());
            menuVO.setHref(e.getHref());
            menuVO.setTitle(e.getTitle());
            menuVO.setIcon(e.getIcon());
            menuVO.setTarget(e.getTarget());
            menuInfo.add(menuVO);
        }
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0L));
        home.put("title","首页");
        home.put("href","/page/welcome-1");//控制器路由,自行定义
        logo.put("title","后台管理系统");
        logo.put("image","/main/images/logo.png");//静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", home);
        map.put("logoInfo", logo);
        return map;
    }
}
