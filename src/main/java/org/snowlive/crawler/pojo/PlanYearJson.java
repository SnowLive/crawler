package org.snowlive.crawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class For:
 *  大学招聘信息 2层
 *
 * @auther: 尹振坤
 * @date: 17-12-9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanYearJson {
    private String year;
    private PlanMajorJson major;

    @Override
    public String toString() {
        return "{" +
                "\"year\":\"" + year + '\"' +
                ",\" major\":" + major +
                "}";
    }
}
