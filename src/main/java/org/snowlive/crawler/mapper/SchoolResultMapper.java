package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.*;
import org.snowlive.crawler.entity.SchoolResult;
import org.springframework.stereotype.Repository;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-22
 */
@Mapper
@Repository
public interface SchoolResultMapper {

    @ResultMap("schoolResult")
    @Select("select * from  schoolsort where id = #{id}")
    public SchoolResult findById(@Param("id") Integer id);

    @Insert("insert into schoolsort(id,rank,college_id,city,subject_a,work_rank,sci,name) values(#{school.id},#{school.rank}," +
            "#{school.college_id},#{school.city},#{school.subject_a}," +
            "#{school.work_rank},#{school.sci},#{school.name})")
    public int insert(@Param("school") SchoolResult school);
}
