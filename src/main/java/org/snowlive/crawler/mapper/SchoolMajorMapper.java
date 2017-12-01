package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.entity.SchoolMajor;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("SchoolMajorMapper")
public interface SchoolMajorMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(SchoolMajor record);
    int insertSelective(SchoolMajor record);
    SchoolMajor selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(SchoolMajor record);
    int updateByPrimaryKeyWithBLOBs(SchoolMajor record);
    int updateByPrimaryKey(SchoolMajor record);
}