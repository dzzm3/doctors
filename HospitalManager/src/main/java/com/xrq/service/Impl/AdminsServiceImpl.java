package com.xrq.service.Impl;

import com.xrq.mapper.AdminsMapper;
import com.xrq.pojo.Admins;
import com.xrq.service.AdminsService;
import com.xrq.util.SqlSessionUtil;

/**
 * @author 许瑞琪
 * Date  2025/7/8 10:34
 */
public class AdminsServiceImpl implements AdminsService {
    @Override
    public Admins login(String username, String password) {
        try {
            //创建AdminsMapper对象
            AdminsMapper mapper = SqlSessionUtil.getMapper(AdminsMapper.class);
            //调用查询方法
            Admins admin =mapper.selectAdminByName(username);
            //如果查询的Admins对象不为null，则判断密码是否相等：相等则返回Admins对象
            if(admin!=null && admin.getPassword().equals(password)){
                return admin;
            }
            //否则返回null
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            SqlSessionUtil.closeSession();
        }
    }
}
