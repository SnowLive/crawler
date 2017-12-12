package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Class For:
 * 自助招生
 *
 * @auther: 尹振坤
 * @date: 17-12-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolIndependent {
    private Integer id;
    private String schoolId;
    private String schoolIndependentId;
    private String independent;//text
    private String info = "{}";//json 附加信息
    private int state = 1;
    private Timestamp createTime;
    private Timestamp updateTime;

}
