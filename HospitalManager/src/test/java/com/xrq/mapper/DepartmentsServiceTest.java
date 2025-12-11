package com.xrq.mapper;

import com.xrq.pojo.Departments;
import com.xrq.service.DepartmentsService;
import com.xrq.service.Impl.DepartmentsServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/15 17:34
 */
public class DepartmentsServiceTest {
    @Test
    public  void getDepartmentAll(){
        //创建service对象
        DepartmentsService departmentsService = new DepartmentsServiceImpl();
        //调用相应的方法
        List<Departments> departmentAll = departmentsService.getDepartmentAll();
        //输出一级科室及对应的二级科室的信息
        //1 先遍历所有一级科室
        for (Departments departments : departmentAll) {
            System.out.println("一级 科室的名称:"+departments.getDepartmentName());
            //遍历当前一级科室对应的二级科室的集合
            System.out.println("\t二级科室:");
            for (Departments child : departments.getChildList()) {
                System.out.println("\t二级科室的名称:"+child.getDepartmentName());
            }
            System.out.println("------------------------------");
        }
    }
}

