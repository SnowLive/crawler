package org.snowlive.crawler.service;

/**
 * Class For:
 *
 *  招生计划事务接口
 *
 * @auther: 尹振坤
 * @date: 17-12-10
 */
public interface SchoolPlanBiz {

    //数据保存
    int saveSchoolPlan();

    //删除所有数据
    int deleteAll();
}
