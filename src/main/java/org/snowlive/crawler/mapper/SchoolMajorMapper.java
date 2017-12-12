package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.entity.SchoolMajor;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SchoolMajorMapper {

    int insert(SchoolMajor record);

    int deleteAll();

    int update(SchoolMajor record);
}