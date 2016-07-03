package guava.collections;

import com.google.common.base.Strings;

/**
 * Created by daijiajia on 16/7/1.
 */
public class StringsTest {
    public static void main(String[] args) {
        //用padChar填充string后面, 使string最小长度为minLength
        String origin = "abc";
        System.out.println(Strings.padEnd(origin, 5, '-'));
        //padEnd(String string, int minLength, char padChar)
        //用padChar填充string前面, 使string最小长度为minLength
        //padStart(String string, int minLength, char padChar)
        System.out.println(Strings.padStart(origin, 5, '+'));
        //null转换为""
        //nullToEmpty(String string)
        System.out.println(Strings.nullToEmpty(null));
        //""转换为null
        //emptyToNull(String string)
        System.out.println(Strings.emptyToNull(""));
        //true, 如果字符串为null或者""
        //isNullOrEmpty(Strng string)
        System.out.println(Strings.isNullOrEmpty("   "));
        System.out.println(Strings.isNullOrEmpty(""));

    }
}
