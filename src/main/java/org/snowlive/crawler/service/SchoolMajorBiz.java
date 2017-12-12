package org.snowlive.crawler.service;

/**
 * Class For:
 *  大学专业设置
 *
 *   1.插入多条数据,list存入,
 *      获取结果集
 *      1.List<SchoolMajor> getSchoolMajorList<SchoolMajor>
 *      数据添加
 *      2.int insertSchoolMajorList(List<SchoolMajor> schoolMajorList)
 *
 *
 * @auther: 尹振坤
 * @date: 17-11-29
 */
public interface SchoolMajorBiz {

    // save school majorsetting
    int saveMajorSetting();

    //获取页面
    String getPage(String url);

    int updateSchoolId();



}
