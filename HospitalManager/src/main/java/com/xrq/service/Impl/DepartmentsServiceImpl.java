package com.xrq.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xrq.mapper.DepartmentsMapper;
import com.xrq.pojo.Departments;
import com.xrq.service.DepartmentsService;
import com.xrq.util.SqlSessionUtil;

import java.util.Collections;
import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/8 15:52
 */
public class DepartmentsServiceImpl implements DepartmentsService {
    @Override
    public PageInfo<Departments> getDepartments(Integer pageNum, Integer pageSize) {

        try {
            //创建DepartmentsMapper对象
            DepartmentsMapper mapper = SqlSessionUtil.getMapper(DepartmentsMapper.class);
            //调用PageHelper.startPage()设置页码
            PageHelper.startPage(pageNum, pageSize);
            //调用mapper中的查询方法
            List<Departments> departmentsList= mapper.selectDepartmentsByLevel(1);
            //创建PageInfo对象
            PageInfo<Departments> pageInfo = new PageInfo<>(departmentsList);
            //返回PageInfo层数对象
            return pageInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            SqlSessionUtil.closeSession();
        }


    }

    @Override
    public void addDepartment(Departments departments) {
        try {
            //获取mapper对象
            DepartmentsMapper mapper = SqlSessionUtil.getMapper(DepartmentsMapper.class);
            //调用添加方法
            mapper.addDepartment(departments);
            //判断是否有父科室，有则获取父科室信息
            Departments parentDepartment=null;
            if(departments.getDepartmentPid()!=0){
                parentDepartment = mapper.selectById(departments.getDepartmentPid());
            }
            //修改当前科室path
            String departmentPath = (parentDepartment!=null?parentDepartment.getDepartmentPath():"")+
                    "|"+departments.getDepartmentId()+"|";
            mapper.changePath(departmentPath,departments.getDepartmentId());
            //提交事务
            SqlSessionUtil.commit();
        } catch (Exception e) {
            //在catch事务回滚
            SqlSessionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            //在finally释放资源
            SqlSessionUtil.closeSession();
        }
    }

    @Override
    public List<Departments> getDepartmentBySecond() {
        try {
            //获取mapper对象
            DepartmentsMapper mapper = SqlSessionUtil.getMapper(DepartmentsMapper.class);
            //调用根据等级查询的方法
            List<Departments> departmentsList = mapper.selectDepartmentsByLevel(2);
            //返回查询的结果
            return departmentsList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            SqlSessionUtil.closeSession();
        }


        //return Collections.emptyList();
    }

    @Override
    public List<Departments> getDepartmentAll() {
        try {
            //获取mapper对象
            DepartmentsMapper mapper = SqlSessionUtil.getMapper(DepartmentsMapper.class);
            //调用根据等级查询的方法
            List<Departments> departmentsList = mapper.selectDepartmentsByLevel(1);
            //遍历所有一级科室信息，查询对应的二级科室的信息
            for (Departments departments : departmentsList) {
                //查询对应二级科室的信息
                List <Departments> childList=mapper.selectByPid(departments.getDepartmentId());
                //把二级科室的集合赋值给一级科室对象中的子科室集合
                departments.setChildList(childList);
            }
            //返回查询的结果
            return departmentsList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            SqlSessionUtil.closeSession();
        }

    }

}
