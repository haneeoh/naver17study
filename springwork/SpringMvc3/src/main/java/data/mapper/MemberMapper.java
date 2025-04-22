package data.mapper;

import data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//dao 역할
@Mapper
public interface MemberMapper {
    public int checkMyid(String myid);

    public void insertMember(MemberDto dto);

    public int getTotalCount();

    public List<MemberDto> getAllMember();

    public void deleteMember(int num);

    public int loginCheck(String loginid, String loginpass);

    public MemberDto getSelectByNum(int num);

    public MemberDto getSelectByMyid(String myid);

    public void changePhoto(String mphoto, int num);

    public void updateMember(MemberDto dto);
}