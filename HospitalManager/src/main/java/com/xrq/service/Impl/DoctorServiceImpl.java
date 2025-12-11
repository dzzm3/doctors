package com.xrq.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xrq.mapper.DoctorsMapper;
import com.xrq.pojo.Doctors;
import com.xrq.service.DoctorService;
import com.xrq.util.SqlSessionUtil;
import com.xrq.vo.DoctorSearchVo;

import java.util.Collections;
import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/9 16:08
 */
public class DoctorServiceImpl implements DoctorService {
    @Override
    public PageInfo<Doctors> getDoctorsByPageAndSearch(DoctorSearchVo doctorSearchVo,Integer pageNum,Integer pageSize) {

        try {
            //获取mapper对象
            DoctorsMapper mapper = SqlSessionUtil.getMapper(DoctorsMapper.class);
            //使用PageHelper设置页码
            PageHelper.startPage(pageNum,pageSize);
            //调用mapper中的查询方法
            List <Doctors> doctorsList=mapper.selectDoctorAll(doctorSearchVo);
            //创建PageInfo对象
            PageInfo<Doctors> pageInfo=new PageInfo<>(doctorsList);
            //返回pageInfo对象
            return pageInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            SqlSessionUtil.closeSession();
        }
    }

    @Override
    public List<Doctors> getDoctorsBySearch(DoctorSearchVo doctorSearchVo) {
        try {
            //获取mapper对象
            DoctorsMapper mapper = SqlSessionUtil.getMapper(DoctorsMapper.class);
            //调用mapper中的查询方法
            List <Doctors> doctorsList=mapper.selectDoctorAll(doctorSearchVo);

            return doctorsList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            SqlSessionUtil.closeSession();
        }
    }

    @Override
    public Doctors selectDoctorByJobNumber(Integer jobNumber) {
        try {
            //获取mapper对象
            DoctorsMapper mapper = SqlSessionUtil.getMapper(DoctorsMapper.class);
            //调用mapper中的查询方法
            Doctors doctors = mapper.selectDoctorByJobNumber(jobNumber);


            return doctors;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            SqlSessionUtil.closeSession();
        }

    }

    @Override
    public List<Doctors> selectDoctorByDepartmentId(Integer departmentId) {
        try {
            //获取mapper对象
            DoctorsMapper mapper = SqlSessionUtil.getMapper(DoctorsMapper.class);
            //调用查询方法
            List<Doctors> doctorsList = mapper.selectDoctorByDepartmentId(departmentId);
            //提交事务
            return doctorsList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            SqlSessionUtil.closeSession();
        }
    }
}
