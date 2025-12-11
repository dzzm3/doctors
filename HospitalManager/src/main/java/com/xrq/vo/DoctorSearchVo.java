package com.xrq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 许瑞琪
 * Date  2025/7/9 15:35
 * 医生的多条件查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSearchVo {
    //科室ID，职称ID，医生姓名，工号
    private Integer departmentId;
    private Integer titleId;
    private String doctorName;
    private String jobNumber;

}
