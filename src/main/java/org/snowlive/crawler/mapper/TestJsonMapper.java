package org.snowlive.crawler.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-7
 */
@Mapper
@Repository()
public interface TestJsonMapper {
    @Insert("insert into testjson values(#{json})")
    int insert(String json);
}
