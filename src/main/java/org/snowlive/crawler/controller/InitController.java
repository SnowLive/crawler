package org.snowlive.crawler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-23
 */
@RestController
@RequestMapping("/init")
public class InitController {

    @GetMapping(value = "init")
    public String init(){
        return "init controller";
    }


}
