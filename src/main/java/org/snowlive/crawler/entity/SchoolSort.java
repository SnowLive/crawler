package org.snowlive.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolSort {
    private Integer id;
    private String schoolId;
    private String schoolSortId;
    private String schoolName;
    private String type;
    private String year;
    private int rank;
    private int worldRank;
    private String city;
    private int topSubjectNum;
    private int sciNum;
    private String info;
    private int state;
    private Timestamp createTime;
    private Timestamp updateTime;


}
