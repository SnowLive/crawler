package org.snowlive.crawler.controller;

import org.snowlive.crawler.service.SchoolSortBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Qualifier("SchoolSortBiz")
    private SchoolSortBiz schoolSortBiz;

    @GetMapping(value = "/init")
    public String init(){
        return "init controller";
    }

    @GetMapping(value = "/insertsort")
    public HashMap<String,Object> insertSortSchools(){
        return schoolSortBiz.addSchoolSortInfo(schoolSortBiz.getListSchoolSortInfo("http://www.gaokaoq.com/rank/moreList?data=1&type=1&p="));
    }



}
