package data.service;

import data.dto.ShopRepleDto;
import data.mapper.ShopRepleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShopRepleService {

    ShopRepleMapper repleMapper;

    public void  insertShopReple(ShopRepleDto dto){
        repleMapper.insertShopReple(dto);
    }

    public List<ShopRepleDto> getRepleByNum(int num){
        return repleMapper.getRepleByNum(num);
    }

    public void deleteShopReple(int idx){
        repleMapper.deleteShopReple(idx);
    }

    public String getPhoto(int idx)
    {
        return repleMapper.getPhoto(idx);
    }

    public void updateLikes(int idx){
        repleMapper.updateLikes(idx);
    }

    public int getLikes(int idx){
        return repleMapper.getLikes(idx);
    }

}
