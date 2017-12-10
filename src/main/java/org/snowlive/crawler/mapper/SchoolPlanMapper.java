package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.snowlive.crawler.entity.SchoolPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class For:
 * dao 招生计划
 *
 * @auther: 尹振坤
 * @date: 17-12-9
 */
@Mapper
@Repository
public interface SchoolPlanMapper {

    int insert(SchoolPlan schoolPlan);

    int deleteAll();

    int deleteFrom(@Param("from") int from, @Param("to") int to);

    List<SchoolPlan> findAll();

}
