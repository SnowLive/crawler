package org.snowlive.crawler.utils;

import java.util.UUID;

/**
 * org.hebeigaokao.common.utils
 *
 * @author 白雨浓
 * date: 17-9-5 上午10:10
 * content:uuid生成器
 */
public class UUIDFactory {
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}
