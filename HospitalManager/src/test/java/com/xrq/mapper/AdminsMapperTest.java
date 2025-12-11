package com.xrq.mapper;

import com.xrq.pojo.Admins;
import com.xrq.util.SqlSessionUtil;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

/**
 * @author 许瑞琪
 * Date  2025/7/8 10:20
 */
public class AdminsMapperTest {
    @Test
    public void selectAdminByName(){
        //获取mapper对象
        AdminsMapper mapper = SqlSessionUtil.getMapper(AdminsMapper.class);
        //调用查询方法
        Admins admins = mapper.selectAdminByName("admin");
        //显示管理员信息
        System.out.println(admins);
    }
}
