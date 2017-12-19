package org.snowlive.crawler.update.service.impl;

import org.snowlive.crawler.update.entity.master.SchoolSort;
import org.snowlive.crawler.update.mapper.crawler.SchoolSortCrawlerMapper;
import org.snowlive.crawler.update.mapper.master.SchoolInfoMapper;
import org.snowlive.crawler.update.mapper.master.SchoolSortMasterMapper;
import org.snowlive.crawler.update.service.SchoolSortBiz;
import org.snowlive.crawler.update.utils.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-15
 */
@Service
public class SchoolSortBizImpl implements SchoolSortBiz {

    private Integer count = 0;

    @Autowired
    private SchoolSortMasterMapper masterMapper;

    @Autowired
    private SchoolSortCrawlerMapper crawlerMapper;

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public List<SchoolSort> listAllGaokaoSort() {
        return masterMapper.listAll();
    }

    @Override
    public List<org.snowlive.crawler.update.entity.crawler.SchoolSort> listAllCrawlerSort() {
        return crawlerMapper.listAll();
    }

    //更新高考数据
    @Override
    public int updateGaoKaoSort() {
        List<SchoolSort> schoolSortList = masterMapper.listAll();
        for (SchoolSort schoolSort : schoolSortList) {
            schoolSort.setSchoolId(schoolInfoMapper.findSchoolIdByName(schoolSort.getSchoolName()));
            count += masterMapper.update(schoolSort);
            System.out.println(schoolSort);
        }
        return count;
    }

    /**
     * 爬虫数据插入
     * @return
     */
    @Override
    public int insertGaoKaoSortInfo() {
        System.out.println("total delete count:"+schoolInfoMapper.deleteAll());
        SchoolSort schoolSort = null;
        List<org.snowlive.crawler.update.entity.crawler.SchoolSort> sortList = crawlerMapper.listAll();
        System.out.println("start");
        for (org.snowlive.crawler.update.entity.crawler.SchoolSort entity : sortList) {
            schoolSort = new SchoolSort();
            schoolSort.setId(entity.getId());
            schoolSort.setSchoolId(schoolInfoMapper.findSchoolIdByName(entity.getName()));
            schoolSort.setSchoolSortId(UUIDFactory.getUUID());
            schoolSort.setSchoolName(entity.getName());
            schoolSort.setRank(entity.getRank());
            schoolSort.setWorldRank(entity.getWorkRank());
            schoolSort.setCity(entity.getCity());
            schoolSort.setTopSubjectNum(entity.getSubjectA());
            schoolSort.setSciNum(entity.getSci());
            schoolSort.setState(1);
            System.out.println("add:"+schoolSort);
            count += masterMapper.insert(schoolSort);
            System.out.println("count:"+count);
        }
        return count;
    }
}
