package org.snowlive.crawler.service;

import org.snowlive.crawler.entity.Result;

import java.util.HashMap;
import java.util.List;

/**
 * Class For:学校排序
 *
 * @auther: 尹振坤
 * @date: 17-11-23
 */
public interface SchoolSortBiz {

    HashMap<String, Object> addSchoolSortInfo(List<Result> sortSchools);

    List<Result> getListSchoolSortInfo(String url);

}
