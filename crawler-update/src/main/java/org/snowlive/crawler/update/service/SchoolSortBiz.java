package org.snowlive.crawler.update.service;

import org.snowlive.crawler.update.entity.master.SchoolSort;

import java.util.List;

/**
 * Class For:
 * 学校排名信息处理
 *
 * @auther: 尹振坤
 * @date: 17-12-15
 */
public interface SchoolSortBiz {

    List<SchoolSort> listAllGaokaoSort();

    List<org.snowlive.crawler.update.entity.crawler.SchoolSort> listAllCrawlerSort();

    int updateGaoKaoSort();

    int insertGaoKaoSortInfo();
}
