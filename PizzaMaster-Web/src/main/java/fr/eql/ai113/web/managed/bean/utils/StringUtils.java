package fr.eql.ai113.web.managed.bean.utils;


public class StringUtils {

    public static String firstLetterCapitalized(String expression) {
        return expression.substring(0, 1).toUpperCase()
                + expression.substring(1).toLowerCase();
    }
}
