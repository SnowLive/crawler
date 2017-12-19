package org.snowlive.crawler.update.mapper.crawler;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.update.entity.crawler.SchoolSort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class For:
 * crawler schoolSort mapper
 * @auther: 尹振坤
 * @date: 17-12-15
 */
@Mapper
@Repository
public interface SchoolSortCrawlerMapper {

    int countAll();

    List<SchoolSort> listAll();

    SchoolSort select(SchoolSort entity);
}