package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.snowlive.crawler.entity.SchoolInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class For:
 * school表的maper
 *
 * @auther: 尹振坤
 * @date: 17-12-11
 */
@Mapper
@Repository
public interface SchoolInfoMapper {

    List<SchoolInfo> findAll();

    String findSchoolIdById(@Param("id")Integer id);

}
