package org.snowlive.crawler.update.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.update.entity.master.SchoolMajor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolMajorMapper {

    List<SchoolMajor> listAll();

    int insert(SchoolMajor record);

    int deleteAll();

    int updateSchoolId(SchoolMajor record);
}