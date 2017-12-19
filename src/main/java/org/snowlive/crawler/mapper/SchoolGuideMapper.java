package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.entity.SchoolGuide;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolGuideMapper {

    List<SchoolGuide> listGuide();
    int insert(SchoolGuide record);
    int update(SchoolGuide record);
    int updateById(SchoolGuide record);
    int deleteAll();
}