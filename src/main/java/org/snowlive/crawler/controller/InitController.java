package org.snowlive.crawler.controller;

import org.snowlive.crawler.service.SchoolSortBiz;
import org.snowlive.crawler.utils.JsoupDoubleAntiCrawlerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-23
 */
@RestController
@RequestMapping("/init")
public class InitController {

    @Autowired
    private SchoolSortBiz schoolSortBiz;

    @GetMapping(value = "/init")
    public String init(){
        return "f_ck all need u";
    }

    @GetMapping(value = "/insertsort")
    public HashMap<String,Object> insertSortSchools(){
        return schoolSortBiz.addSchoolSortInfo(schoolSortBiz.getListSchoolSortInfo("http://www.gaokaoq.com/rank/moreList?data=1&type=1&p="));
    }
    @GetMapping(value="/college/plan/{id}")
    public String plan(@PathVariable("id")Integer id){
        String url = "http://www.gaokaoq.com/college/plan/id/"+id+".html";
        return JsoupDoubleAntiCrawlerUtil.gethtml(url).toString();
    }



}
