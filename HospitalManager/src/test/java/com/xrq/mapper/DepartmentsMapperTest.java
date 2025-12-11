package com.xrq.mapper;

import com.xrq.pojo.Departments;
import com.xrq.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/8 15:12
 */
public class DepartmentsMapperTest {
    @Test
    public void getDepartments() {
        //获取mapper对象
        DepartmentsMapper mapper = SqlSessionUtil.getMapper(DepartmentsMapper.class);
        //调用查询方法
        List <Departments> departments=mapper.selectDepartmentsByLevel(1);
        //显示相应科室信息
        for(Departments department:departments){
            System.out.println(department);
        }
    }
    @Test
    //添加并修改路径
    public void addDepartment() {
        //获取mapper对象
        DepartmentsMapper mapper = SqlSessionUtil.getMapper(DepartmentsMapper.class);
        //调用修改方法
        Departments department=new Departments();
        department.setDepartmentName("测试7.9.2");
        department.setDepartmentPid(51);
        department.setDepartmentLevel(2);
        department.setDepartmentDescription("7.9测试科室");
        System.out.println("添加前的科室信息："+department);
        mapper.addDepartment(department);
        System.out.println("添加后的科室信息："+department);

        //判断pid值是否不为0
        Departments depart =null;
        if(department.getDepartmentPid()!=0){
            //查询PID对应的科室信息
            depart=mapper.selectById(department.getDepartmentPid());
        }
        //调用修改方法
        //设置相应科室的路径
        String departmentPath = (depart!=null?depart.getDepartmentPath():"")+
                "|"+department.getDepartmentId()+"|";
        mapper.changePath(departmentPath,department.getDepartmentId());
        //事务提交
        SqlSessionUtil.commit();
        //释放资源
        SqlSessionUtil.closeSession();
    }
}
