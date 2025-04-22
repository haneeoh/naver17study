package data.mapper;

import data.dto.ShopRepleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


//dao 역할
@Mapper
public interface ShopRepleMapper {
    public void insertShopReple(ShopRepleDto dto);
    public void deleteShopReple(int idx);
    public List<ShopRepleDto> getRepleByNum(int num);
    public String getPhoto(int idx);
    public void updateLikes(int idx);
    public int getLikes(int idx);
}