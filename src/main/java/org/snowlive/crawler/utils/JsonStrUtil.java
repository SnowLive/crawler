package org.snowlive.crawler.utils;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-12-6
 */
public class JsonStrUtil {
    private static final String UNICODE_REG = "\\\\u[\\w]{3,5}";

    /**
     * replace antiline,doublequotaion,brace
     *
     * @param data
     * @return
     */
    public static String replaceSpcialChar(String data) {
        return replaceUnEncoding(relaceDoubleQuotation(replaceAntiLine(data)),"(",")");
    }

    /**
     * replace \
     * @param data
     * @return \\
     */
    public static String replaceAntiLine(String data) {
        return data.replace("\\", "\\\\");
    }
    /**
     * replace "
     * @param data
     * @return \"
     */
    public static String relaceDoubleQuotation(String data) {
        return data.replace("\"", "\\\"");
    }
    /**
     * replace '
     * @param data
     * @return \'
     */
    public static String relaceSingleQuotation(String data) {
        return data.replace("\'", "\\\'");
    }
    /**
     * replace { }
     * @param data
     * @return \{ \}
     */
    public static String replaceBrace(String data) {
        return data.replace("{", "\\{").replace("}", "\\}");
    }
    public static String replaceBrace(String data,String repStrL,String repStrR) {
        return data.replace("{", repStrL).replace("}", repStrR);
    }

    public static String replaceUnEncoding(String data,String encodChar,String str){

        return data.replace(UNICODE_REG,"-").replace("\u001F","-");
    }

}
