package org.snowlive.crawler.controller;

import org.snowlive.crawler.service.SchoolMajorBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-1
 */
@RestController
@RequestMapping("/schoolmajor")
public class SchoolMajorController {
    @Autowired
    private SchoolMajorBiz schoolMajorBiz;

    @GetMapping("/get")
    public String getInfo(){
        schoolMajorBiz.getSchoolMajorList();
        return "data get is ok!";
    }

}
