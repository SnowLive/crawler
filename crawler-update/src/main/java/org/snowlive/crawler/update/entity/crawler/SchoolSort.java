package org.snowlive.crawler.update.entity.crawler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolSort {
    private Integer id;
    private Integer rank;
    private Integer collegeId;
    private String city;
    private Integer subjectA;
    private Integer workRank;
    private Integer sci;
    private String name;
}
