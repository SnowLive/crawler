package org.snowlive.crawler.update.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.snowlive.crawler.update.entity.master.SchoolInfo;
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

    String findSchoolIdById(@Param("id") Integer id);

    String findSchoolIdByName(@Param("name") String name);

    List<SchoolInfo> select(SchoolInfo entity);

    int deleteAll();




}
