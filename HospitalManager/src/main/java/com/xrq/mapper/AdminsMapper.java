package com.xrq.mapper;

import com.xrq.pojo.Admins;

/**
 * @author 许瑞琪
 * Date  2025/7/8 10:16
 */
public interface AdminsMapper {

    Admins selectAdminByName(String username);
}
