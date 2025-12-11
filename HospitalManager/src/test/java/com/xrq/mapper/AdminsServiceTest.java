package com.xrq.mapper;

import com.xrq.pojo.Admins;
import com.xrq.service.AdminsService;
import com.xrq.service.Impl.AdminsServiceImpl;
import org.junit.Test;

/**
 * @author 许瑞琪
 * Date  2025/7/8 10:38
 */
public class AdminsServiceTest {

    @Test
    public void login() {
        //创建AdminsService对象
        AdminsService adminsService = new AdminsServiceImpl();
        //调用登录验证的方法
        Admins admins = adminsService.login("admin", "12345");

        System.out.println((admins!=null)?"登录成功":"登录失败");
    }
}
