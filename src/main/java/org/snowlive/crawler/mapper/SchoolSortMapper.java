package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.entity.SchoolSort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-14
 */
@Mapper
@Repository
public interface SchoolSortMapper {
    int update(SchoolSort entity);

    List<SchoolSort> list();

    SchoolSort select(SchoolSort entity);
}
