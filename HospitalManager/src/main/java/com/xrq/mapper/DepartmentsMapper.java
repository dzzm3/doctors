package com.xrq.mapper;

import com.xrq.pojo.Departments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/8 15:09
 */
public interface DepartmentsMapper {
    /**
     * 查询指定等级科室信息
     * @param departmentLevel
     * @return
     */
    List<Departments> selectDepartmentsByLevel(Integer departmentLevel);

    /**
     * 根据父科室的id查询对应子科室集合
     * @param pid
     * @return
     */
    List<Departments> selectByPid(Integer pid);
    /**
     * 添加新科室
     * 方法参数为科室对象类型，因此sql语句的参数占位符名必须与对象的属性名相同
     * @param departments
     */
    void addDepartment(Departments departments);

    /**
     * 修改指定科室的路径
     * 参数多于1时，要用@Param("名")
     * @param departmentPath
     * @param departmentId
     */
    void changePath(@Param("departmentPath")String departmentPath,@Param("departmentId")Integer departmentId);

    /**
     * 根据id查找科室
     * @param departmentId
     * @return
     */

    Departments selectById(Integer departmentId);

}
