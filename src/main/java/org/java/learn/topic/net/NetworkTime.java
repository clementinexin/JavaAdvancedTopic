package org.java.learn.topic.net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by daijiajia on 16/6/19.
 */
public class NetworkTime {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        URLConnection connection = url.openConnection();
        connection.connect();
        System.out.println(new Date(connection.getDate()));

    }
}
