package com.xrq.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xrq.mapper.DepartmentsMapper;
import com.xrq.mapper.ProfessionalTitlesMapper;
import com.xrq.pojo.Departments;
import com.xrq.pojo.ProfessionalTitles;
import com.xrq.service.ProfessionalTitlesService;
import com.xrq.util.SqlSessionUtil;

import java.util.List;


/**
 * @author 许瑞琪
 * Date  2025/7/9 14:26
 */
public class ProfessionalTitlesServiceImpl implements ProfessionalTitlesService {

    public List<ProfessionalTitles> selectAll() {
        try {
            //创建mapper对象
            ProfessionalTitlesMapper mapper = SqlSessionUtil.getMapper(ProfessionalTitlesMapper.class);
            //调用查询方法
            List<ProfessionalTitles> titlesList = mapper.selectAll();
            //返回查询结果
            return titlesList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            SqlSessionUtil.closeSession();
        }


    }

    @Override
    public PageInfo<ProfessionalTitles> getProfessionalTitles(Integer pageNum, Integer pageSize) {

        try {
            //创建ProfessionalTitlesMapper对象
            ProfessionalTitlesMapper mapper = SqlSessionUtil.getMapper(ProfessionalTitlesMapper.class);
            //调用PageHelper.startPage()设置页码
            PageHelper.startPage(pageNum, pageSize);
            //调用mapper中的查询方法
            List<ProfessionalTitles> professionalTitlesList = mapper.selectAll();
            //创建PageInfo对象
            PageInfo<ProfessionalTitles> pageInfo = new PageInfo<>(professionalTitlesList);
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
    public void addProfessionalTitles(ProfessionalTitles professionalTitles) {
        try {
            //获取mapper对象
            ProfessionalTitlesMapper mapper = SqlSessionUtil.getMapper(ProfessionalTitlesMapper.class);
            //调用添加方法
            mapper.addProfessionalTitles(professionalTitles);
            //提交事务
            SqlSessionUtil.commit();
        } catch (Exception e) {
            //在catch中事务回滚
            SqlSessionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            //在finally中释放资源
            SqlSessionUtil.closeSession();
        }
    }

    @Override
    public void changeTitles(ProfessionalTitles professionalTitles) {
        try {
            //获取mapper对象
            ProfessionalTitlesMapper mapper = SqlSessionUtil.getMapper(ProfessionalTitlesMapper.class);
            //调用更改方法
            mapper.changeTitles(professionalTitles);
            //提交事务
            SqlSessionUtil.commit();
        } catch (Exception e) {
            //在catch中事务回滚
            SqlSessionUtil.rollback();
            throw new RuntimeException(e);
        } finally {
            //在finally中释放资源
            SqlSessionUtil.closeSession();
        }
    }

    @Override
    public ProfessionalTitles selectById(Integer id) {
        try {
            //获取mapper对象
            ProfessionalTitlesMapper mapper = SqlSessionUtil.getMapper(ProfessionalTitlesMapper.class);
            //调用更改方法
            ProfessionalTitles professionalTitles = mapper.selectById(id);
            return professionalTitles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            SqlSessionUtil.closeSession();
        }
    }

    @Override
    public void delTitles(Integer id) {
        try {
            //获取mapper对象
            ProfessionalTitlesMapper mapper = SqlSessionUtil.getMapper(ProfessionalTitlesMapper.class);
            //调用删除方法
            mapper.delTitles(id);
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
}