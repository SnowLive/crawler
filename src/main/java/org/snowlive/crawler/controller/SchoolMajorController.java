package org.snowlive.crawler.controller;

import org.snowlive.crawler.service.SchoolMajorBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class For:
 * schoolMajor
 *
 * @auther: 尹振坤
 * @date: 17-12-1
 */
@RestController
@RequestMapping("/schoolmajor")
public class SchoolMajorController {
    @Autowired
    private SchoolMajorBiz schoolMajorBiz;

    /**
     * 获取高考圈具体显示页的信息
     *
     * @param url
     * @return
     */
    @GetMapping("/get/{url}")
    public String getInfo(@PathVariable("url") String url) {
        System.out.println(url);
        url = url.equals("") ? "index.html" : url;
        String html = schoolMajorBiz.getPage("http://www.gaokaoq.com/" + url);
        return html;
    }

    @GetMapping("/major/one/{type}/{id}")
    public String getMajorPage(@PathVariable(value = "type",required = false) String type,
                               @PathVariable(value = "id", required = false) Integer id) {

        type = type.isEmpty() ? "focusmajor" : type;
        id = id==null?1:id;
        String html = schoolMajorBiz.getPage("http://www.gaokaoq.com/college/" + type + "/id/"+id);
        return html;
    }

    /**
     * @param type
     * @return
     */
    @GetMapping("/major/two/{type}")
    public String getMajorPagesh(@PathVariable("type") String type) {
        type = type.isEmpty() ? "focusmajor" : type;
        String html = schoolMajorBiz.getPage("http://www.gaokaoq.com/college/" + type + "/id/3");
        return html;
    }


}
