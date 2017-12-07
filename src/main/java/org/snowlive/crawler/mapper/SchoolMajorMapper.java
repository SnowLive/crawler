package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.entity.SchoolMajor;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("SchoolMajorMapper")
public interface SchoolMajorMapper {

    int insert(SchoolMajor record);
}