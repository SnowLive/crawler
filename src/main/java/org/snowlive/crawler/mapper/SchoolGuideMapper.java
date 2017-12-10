package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.entity.SchoolGuide;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SchoolGuideMapper {

    int insert(SchoolGuide record);
    int deleteAll();
}