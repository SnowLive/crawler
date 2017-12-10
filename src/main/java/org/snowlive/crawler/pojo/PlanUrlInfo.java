package org.snowlive.crawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class For:
 *  招生计划 url参数
 * @auther: 尹振坤
 * @date: 17-12-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanUrlInfo {

    private int id = 1;
    private int city_id = 5;
    private int type = 1;//文理
    private int year = 2017;
    private int p = 1;
    public PlanUrlInfo(int id){
        this.id = id;
    }
}
