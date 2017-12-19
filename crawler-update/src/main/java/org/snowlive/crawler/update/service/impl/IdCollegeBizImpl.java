package org.snowlive.crawler.update.service.impl;

import org.snowlive.crawler.update.entity.crawler.IdCollege;
import org.snowlive.crawler.update.mapper.crawler.IdCollegeCrawlerMapper;
import org.snowlive.crawler.update.service.IdCollegeBiz;
import org.snowlive.crawler.update.utils.JsoupDoubleAntiCrawlerUtil;
import org.snowlive.crawler.update.utils.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-16
 */
@Service
public class IdCollegeBizImpl implements IdCollegeBiz {

    @Autowired
    private IdCollegeCrawlerMapper mapper;
    private int count = 0;



    @Override
    public int addRecord() {
//        390
        handler(3400, 3410);
        return count;
    }

    @Override
    public String getSchoolName(Integer id) {
        return mapper.selectNameById(id);
    }

    /**
     * 循环取出gaokaoq的id,与college对.
     *
     * @param start
     * @param end
     */
    private void handler(int start, int end) {
        String url;
        int index;
        String schoolName;
        IdCollege college;
        for (int i = start; i < end; i++) {
            index = i + 1;
            url = UrlUtil.combinGaoKaoqURL(index);
            schoolName = JsoupDoubleAntiCrawlerUtil.getContent(".e_name", url).replace("关注", "");
            if(schoolName==null)continue;
            college = new IdCollege(index, schoolName);
            System.out.println("entity:"+college+"\n");
            count += mapper.insert(college);
        }
    }
}
