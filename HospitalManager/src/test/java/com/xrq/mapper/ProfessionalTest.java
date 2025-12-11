package com.xrq.mapper;

import com.xrq.pojo.Departments;
import com.xrq.pojo.Doctors;
import com.xrq.pojo.ProfessionalTitles;
import com.xrq.util.SqlSessionUtil;
import com.xrq.vo.DoctorSearchVo;
import org.junit.Test;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/10 9:38
 */
public class ProfessionalTest {

    @Test
    //添加新职称
    public void addProfessionalTitles() {
        //获取mapper对象
        ProfessionalTitlesMapper mapper = SqlSessionUtil.getMapper(ProfessionalTitlesMapper.class);
        //调用修改方法
        ProfessionalTitles professionalTitles = new ProfessionalTitles();
        professionalTitles.setTitleName("院长test7.10");
        professionalTitles.setId(null);
        professionalTitles.setDescription("第一次测试，医院院长");

        System.out.println("添加前的科室信息："+professionalTitles);
        mapper.addProfessionalTitles(professionalTitles);
        System.out.println("添加后的科室信息："+professionalTitles);

        //事务提交
        SqlSessionUtil.commit();
        //释放资源
        SqlSessionUtil.closeSession();

    }
}
