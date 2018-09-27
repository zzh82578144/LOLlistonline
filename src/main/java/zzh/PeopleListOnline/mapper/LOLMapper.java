package zzh.PeopleListOnline.mapper;

import java.util.List;

import zzh.PeopleListOnline.model.LOL;

public interface LOLMapper {
    int deleteByPrimaryKey(String lolId);

    int insert(LOL record);

    int insertSelective(LOL record);

    LOL selectByPrimaryKey(String lolId);

    int updateByPrimaryKeySelective(LOL record);

    int updateByPrimaryKey(LOL record);
    
    List<LOL> selectAll();
}