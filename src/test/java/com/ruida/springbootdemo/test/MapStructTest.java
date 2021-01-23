package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.convert.CarConvert;
import com.ruida.springbootdemo.domain.dto.CarDTO;
import com.ruida.springbootdemo.domain.dto.DriverDTO;
import com.ruida.springbootdemo.domain.vo.CarVO;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author chenjy
 * @since 2021/1/23 13:48
 */
public class MapStructTest {

    @Test
    public void test1(){
        CarConvert cc = CarConvert.INSTANCE;
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1L);
        carDTO.setBrand("宝马");
        carDTO.setPrice(100000.123d);
        carDTO.setColor("白色");
        carDTO.setPublishedDate(new Date());

        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(100L);
        driverDTO.setDriverName("小明");

        carDTO.setDriverDTO(driverDTO);

        CarVO carVO = cc.carDTO2CarVO(carDTO);
        System.out.println(carVO);

        //批量映射
        List<CarVO> carVOList = cc.carDTO2CarVOList(Lists.newArrayList(carDTO));
        System.out.println(carVOList);
    }
}
