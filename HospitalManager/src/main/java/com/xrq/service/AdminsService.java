package com.xrq.service;

import com.xrq.pojo.Admins;

/**
 * @author 许瑞琪
 * Date  2025/7/8 10:33
 */
public interface AdminsService {
    /**
     * 用户登录的验证
     * @param username 用户名
     * @param password 密码
     * @return 登录成功，返回管理员对象，失败返回null
     */

    Admins login(String username, String password);
}
