package com.xrq.service;

import com.github.pagehelper.PageInfo;
import com.xrq.pojo.Doctors;
import com.xrq.vo.DoctorSearchVo;

import javax.print.Doc;
import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/9 16:07
 */
public interface DoctorService {

    PageInfo<Doctors> getDoctorsByPageAndSearch(DoctorSearchVo doctorSearchVo, Integer pageNum, Integer pageSize);


    List<Doctors> getDoctorsBySearch(DoctorSearchVo doctorSearchVo);

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
