package org.snowlive.crawler.test.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuideJson {
    private String state;
    private String count;
    private List<DataJson> date;


}
