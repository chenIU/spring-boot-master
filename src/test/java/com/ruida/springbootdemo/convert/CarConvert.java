package com.ruida.springbootdemo.convert;

import com.ruida.springbootdemo.domain.dto.CarDTO;
import com.ruida.springbootdemo.domain.dto.DriverDTO;
import com.ruida.springbootdemo.domain.vo.CarVO;
import com.ruida.springbootdemo.domain.vo.DriverVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * @author chenjy
 * @since 2021/1/23 13:44
 */
@Mapper(componentModel = "spring")
public abstract class CarConvert {

    public static CarConvert INSTANCE = Mappers.getMapper(CarConvert.class);

    @Mappings(
            value = {
                    @Mapping(source = "brand",target = "brandName"),
                    @Mapping(source = "price",target = "price",numberFormat = "#.00"),
                    @Mapping(source = "publishedDate",target = "publishedDate",dateFormat = "yyyy-MM-dd HH:mm:ss"),
                    @Mapping(target = "color",ignore = true),
                    @Mapping(source = "driverDTO",target = "driverVO")
            }
    )
    public abstract CarVO carDTO2CarVO(CarDTO carDTO);

    public abstract DriverVO driverDTO2DriverVO(DriverDTO driverDTO);

    public abstract List<CarVO> carDTO2CarVOList(List<CarDTO> carDTOList);

    @AfterMapping
    public void dto2voAfter(@MappingTarget CarVO carVO){
        if(carVO.getDriverVO() != null){
            carVO.setHasDriver(true);
        }else {
            carVO.setHasDriver(false);
        }
    }
}
