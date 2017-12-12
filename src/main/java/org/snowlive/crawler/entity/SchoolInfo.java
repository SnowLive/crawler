package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Class For:
 * 学校信息
 * @auther: 尹振坤
 * @date: 17-12-11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInfo {

    private Integer id;
    private String schoolId;
    private String schoolName;
    private String province;
    private String info;
    private String synopsis;
    private String map_url;
    private int state = 1;
    private Timestamp createTime;
    private Timestamp update;

}
