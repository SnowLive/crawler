package org.snowlive.crawler.service.impl;

import org.snowlive.crawler.entity.Result;
import org.snowlive.crawler.entity.SchoolResult;
import org.snowlive.crawler.mapper.SchoolResultMapper;
import org.snowlive.crawler.service.SchoolSortBiz;
import org.snowlive.crawler.utils.MyJsonTools;
import org.snowlive.crawler.utils.SchoolInfoDownloadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-23
 */
@Service
public class SchoolSortBizImpl implements SchoolSortBiz {

    @Autowired
    private SchoolResultMapper schoolResultMapper;

    @Override
    public HashMap<String, Object> addSchoolSortInfo(List<Result> sortSchools) {

        HashMap<String,Object> results = new HashMap<String,Object>();
        //3.数据存入DB
        int result_num = 0;
        for (Result res : sortSchools) {
            for (SchoolResult school : res.getData()) {
                result_num+=schoolResultMapper.insert(school);
                System.out.print("插入数据数："+result_num+"   ");
                System.out.print("学校名称:"+school.getName());
                System.out.println("\t学校排名："+school.getRank());
            }
        }
        //4.封装返回结果。
        results.put("count",result_num);
        results.put("obj",sortSchools);

        return results;
    }

    @Override
    public List<Result> getListSchoolSortInfo(String url) {
        List<Result> sortSchools = new ArrayList<>(10);
        String Url = (!url.equals(""))?url:"http://www.gaokaoq.com/rank/moreList?data=1&type=1&p=";
        String info ;
        //1.开始解析
        for (int i = 1; i < 11; i++) {
            info = SchoolInfoDownloadUtils.download(Url+i);
            if(!info.equals("")){
                Result result = MyJsonTools.string2JSON(info);
                sortSchools.add(result);
            }
        }
        //2.解析完成，打印结果
        for (Result res : sortSchools) {
            for (SchoolResult school : res.getData()) {
                System.out.println(school.toString());
            }
        }
        return sortSchools;
    }
}
