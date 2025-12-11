package com.xrq.service;

import com.github.pagehelper.PageInfo;
import com.xrq.pojo.Departments;
import com.xrq.pojo.ProfessionalTitles;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/9 14:25
 */
public interface ProfessionalTitlesService {
    /**
     * 查询所有职称的信息
     * @return
     */
    List<ProfessionalTitles> selectAll();

    /**
     *
     * @param pageNum 当前页码
     * @param pageSize 每页显示的数量
     * @return
     */
    PageInfo<ProfessionalTitles> getProfessionalTitles(Integer pageNum, Integer pageSize);

    /**
     * 添加新职称
     * @param professionalTitles
     */
    void addProfessionalTitles(ProfessionalTitles professionalTitles);

    /**
     * 更改职称
     * @param professionalTitles
     */
    void changeTitles(ProfessionalTitles professionalTitles);

    /**
     * 查询职称信息
     * @param id
     * @return
     */
    ProfessionalTitles selectById(Integer id);
    void delTitles(Integer id);

}
