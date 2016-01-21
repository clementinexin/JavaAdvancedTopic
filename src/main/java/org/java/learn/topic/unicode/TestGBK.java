package org.java.learn.topic.unicode;

import java.io.UnsupportedEncodingException;

/**
 * different on Eclipse and IDEA,correct in Eclipse and not in IDEA,who know why
 */
public class TestGBK {
    final static String UTF8 = "UTF-8";
    final static String GBK = "GBK";
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(new String("你好".getBytes(GBK),GBK));
        for (byte b : "你好".getBytes(GBK)) {
            System.out.printf("0x%x ",b);

        }
        System.out.println("\n");
        String s = "你好";
        for (int i =0;i<s.length();i++) {
            System.out.printf("\\u%x",(int)s.charAt(i));
        }
        System.out.println("\n");

        System.out.println("\u4f60\u597d");

        String u = "\u4f60\u597d";
        for (byte b : u.getBytes(GBK)) {
            System.out.printf("0x%x ",b);

        }
        System.out.println("\n");
        for (byte b : u.getBytes(UTF8)) {
            System.out.printf("0x%x ",b);

        }


    }
}