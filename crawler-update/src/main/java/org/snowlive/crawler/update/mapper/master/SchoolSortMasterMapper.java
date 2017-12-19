package org.snowlive.crawler.update.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.snowlive.crawler.update.entity.master.SchoolSort;
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
public interface SchoolSortMasterMapper {
    int update(SchoolSort entity);

    List<SchoolSort> listAll();

    SchoolSort select(SchoolSort entity);

    int countAll();

    int insert(SchoolSort entity);

}
