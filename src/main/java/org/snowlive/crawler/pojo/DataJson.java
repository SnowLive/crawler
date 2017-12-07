package org.snowlive.crawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataJson<T> {
    private int state = 1;
    private List<T> data;
    private int count ;

    @Override
    public String toString() {
        return "{" +
                "\"state\":\"" + state +
                "\", \"count\":\"" + count +
                "\", \"data\":" + data +
                "}";
    }
}
