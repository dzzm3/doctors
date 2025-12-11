package com.xrq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 许瑞琪
 * Date  2025/7/9 15:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Doctors {
//    doctor_id
    private Integer doctorId;
//            job_number
    private String jobNumber;
//    password
    private String password;
//            name
    private String name;
//    avatar
    private String avatar;
//            phone
    private String phone;
//    email
    private String email;
//            introduction
    private String introduction;
//    registration_fee
    private Double registrationFee;
//            entry_date
    private Date entryDate;
//    department_id
    private Integer departmentId;
//            professional_title_id
    private Integer professionalTitleId;
//    state
    private String state;
//创建关系表的属性
    private Departments departments;  //科室
    private ProfessionalTitles titles;  //职称

}
