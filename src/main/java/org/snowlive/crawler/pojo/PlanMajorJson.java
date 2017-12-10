package org.snowlive.crawler.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class For:
 * major(liberal<datajson>{},science{})
 *
 * @auther: 尹振坤
 * @date: 17-12-9
 * datajson->yearjson->major->datajson->planjson
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanMajorJson {
    private DataJson<PlanJson> liberal;//文科专业
    private DataJson<PlanJson> science;//理科专业

    @Override
    public String toString() {
        return "{" +
                "\"liberal\":" + liberal +
                ", \"science\":" + science +
                " }";
    }
}
