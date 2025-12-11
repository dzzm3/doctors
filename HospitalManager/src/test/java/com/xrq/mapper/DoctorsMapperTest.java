package com.xrq.mapper;

import com.xrq.pojo.Doctors;
import com.xrq.util.SqlSessionUtil;
import com.xrq.vo.DoctorSearchVo;
import org.junit.Test;

import java.util.List;

/**
 * @author 许瑞琪
 * Date  2025/7/9 15:43
 */
public class DoctorsMapperTest {

    @Test
    public void selectDoctor() {
        //获取mapper对象
        DoctorsMapper mapper = SqlSessionUtil.getMapper(DoctorsMapper.class);
        //调用查询方法
        DoctorSearchVo searchVo = new DoctorSearchVo();
        searchVo.setDepartmentId(6);
        searchVo.setTitleId(2);
        List<Doctors> doctorsList=mapper.selectDoctorAll(searchVo);
        for(Doctors doctors:doctorsList){
            System.out.println(doctors);
        }
    }
}
