package org.snowlive.crawler.test.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.snowlive.crawler.test.json.DataJson;
import org.snowlive.crawler.test.json.GuideJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-14
 */
public class JsonUtils {

    public static GuideJson strToJson(String jsonStr) {
        GuideJson guide = new GuideJson();
        List<DataJson> data = new ArrayList<>(10);
        try {
            JSONObject jsonobj = new JSONObject(jsonStr);
            guide.setState(jsonobj.optString("state"));
            guide.setCount(jsonobj.optString("count"));
            JSONArray arr = jsonobj.getJSONArray("data");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        guide.getCount();
        guide.getDate().get(1).getTitle();

        return guide;
    }


}
