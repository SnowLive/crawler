package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.snowlive.crawler.entity.SchoolIndependent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class For:
 *
 *  自主招生mapper
 * @auther: 尹振坤
 * @date: 17-12-11
 */
@Mapper
@Repository
public interface SchoolIndependentMapper {

    int insert(SchoolIndependent schoolIndependent);

    int deleteAll();

    int deleteFrom(@Param("from")int from,@Param("to")int to);

    List<SchoolIndependent> findAll();

}
