package data.mapper;

import data.dto.ShopDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//dao 역할
@Mapper
public interface ShopMapper {
    public int getTotalCount();
    public void insertShop(ShopDto dto);
    public List<ShopDto> getAllSangpum();
    public ShopDto getSangpum(int num);
    public void deleteShop(int num);
    public void updateShop(ShopDto dto);
    public  void updatePhoto (Map<String,Object> map);
}