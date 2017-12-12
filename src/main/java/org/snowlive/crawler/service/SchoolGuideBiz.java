package org.snowlive.crawler.service;

/**
 * Class For:
 *
 * 学校招生章程事务接口
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
public interface SchoolGuideBiz {

    /**
     *  爬取数据,将数据封装并返回.
     * @return
     */
    int saveSchoolGuide();

    int deleteAll();

    int updateSchoolId();
}
