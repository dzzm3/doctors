package com.xrq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 许瑞琪
 * Date  2025/7/8 10:12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Admins {
    private Integer adminId;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private String phone;
    private String email;
}
