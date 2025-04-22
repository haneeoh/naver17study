package data.service;

import data.dto.ShopDto;
import data.mapper.ShopMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ShopService {
    ShopMapper shopMapper;

    public int getTotalCount() {
        return shopMapper.getTotalCount();
    }

    public void insertShop(ShopDto dto) {
        shopMapper.insertShop(dto);
    }

    public List<ShopDto> getAllSangpum() {
        return shopMapper.getAllSangpum();
    }

    public ShopDto getSangpum(int num)
    {
        return shopMapper.getSangpum(num);
    }

    public void deleteShop(int num){
        shopMapper.deleteShop(num);
    }

    public void updateShop(ShopDto dto) {
        shopMapper.updateShop(dto);
    }

    public void updatePhoto(int num,String photo) {
        Map<String,Object> map=new HashMap<>();
        map.put("photo",photo);
        map.put("num",num);
        shopMapper.updatePhoto(map);
    }

}
