package com.xrq.mapper;

import com.xrq.pojo.ProfessionalTitles;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/9 14:23
 */
public interface ProfessionalTitlesMapper {
    List<ProfessionalTitles> selectAll();
    //添加新职称
    void addProfessionalTitles(ProfessionalTitles professionalTitles);
    //根据编号查询职称信息

    //更改职称
    void changeTitles(ProfessionalTitles professionalTitles);

    ProfessionalTitles selectById(Integer id);

    void delTitles(Integer id);
}
