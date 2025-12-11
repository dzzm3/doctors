package com.xrq.service;

import com.github.pagehelper.PageInfo;
import com.xrq.pojo.Departments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/8 15:50
 */
public interface DepartmentsService {
    /**
     *
     * @param pageNum 当前页码
     * @param pageSize 每页显示的数量
     * @return
     */
    PageInfo<Departments> getDepartments(Integer pageNum, Integer pageSize);


    /**
     * 添加新科室
     * 方法参数为科室对象类型，因此sql语句的参数占位符名必须与对象的属性名相同
     * @param departments
     */
    void addDepartment(Departments departments);

    /**
     * 查询所有二级科室的信息
     * @return
     */
    List<Departments> getDepartmentBySecond();

    /**
     * 查询所有一级科室，同时查询每个一级科室对应的二级科室
     * @return
     */
    List<Departments> getDepartmentAll();



}
