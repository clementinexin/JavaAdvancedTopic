import com.google.common.base.CharMatcher;

/**
 * Created by daijiajia on 16/7/1.
 */
public class CharMatcherTest {

    public static void main(String[] args) {
//        使用CharMatcher类

//        替换多个连续的空格为单个空格

        System.out.println(CharMatcher.WHITESPACE.collapseFrom(" a   b  c  ", ' '));
//        将头尾的空格去掉

        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("  a  b  c  ", ' '));
//        保留制定字符，如数字，字母等

        String retained = CharMatcher.JAVA_DIGIT.retainFrom(" a2bb4b5b "); //保留数字
        System.out.println(retained);
//        你也可以通过Or组合多个CharMatcher

        CharMatcher cm = CharMatcher.JAVA_DIGIT.or(CharMatcher.WHITESPACE);
        System.out.println(cm.retainFrom("foo9 89y xbar 234"));//保留数字和空格
    }
}
