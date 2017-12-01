package org.snowlive.crawler.controller;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-1
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ErrorController {

    @GetMapping(value = "/errorinfo" )
    public String errorPage(){
        return "It's is Error Page!";
    }


}
