package org.snowlive.crawler.update.mapper.crawler;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.snowlive.crawler.update.entity.crawler.IdCollege;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class For:
 *  id college 原生映射dao
 * @auther: 尹振坤
 * @date: 17-12-16
 */
@Mapper
@Repository
public interface IdCollegeCrawlerMapper {

    int insert(IdCollege entity);
    String selectNameById(@Param("id")Integer id);
    List<IdCollege> select(IdCollege entity);
    List<IdCollege> listAll();
}
