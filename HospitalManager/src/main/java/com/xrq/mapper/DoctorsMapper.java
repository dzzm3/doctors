package com.xrq.mapper;

import com.xrq.pojo.Doctors;
import com.xrq.vo.DoctorSearchVo;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/9 15:24
 */
public interface DoctorsMapper {

    List<Doctors> selectDoctorAll(DoctorSearchVo doctorSearchVo);

    /**
     * 按照JobNumber查找医生
     * @param jobNumber
     * @return
     */
    Doctors selectDoctorByJobNumber(Integer jobNumber);

    /**
     * 根据科室Id查询医生信息
     * @param departmentId
     * @return
     */
    List<Doctors> selectDoctorByDepartmentId(Integer departmentId);

}
