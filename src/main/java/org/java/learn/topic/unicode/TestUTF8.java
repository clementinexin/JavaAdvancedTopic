package org.java.learn.topic.unicode;

import java.io.UnsupportedEncodingException;

public class TestUTF8 {
    final static String UTF8 = "UTF-8";
    final static String GBK = "GBK";
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(new String("你好".getBytes(UTF8),UTF8));
        for (byte b : "你好".getBytes(UTF8)) {
            System.out.printf("0x%x ",b);

        }
        String s = "你好";
        for (int i =0;i<s.length();i++) {
            System.out.printf("\\u%x",(int)s.charAt(i));
        }
    }
}