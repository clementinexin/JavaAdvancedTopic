package org.rpc.service.server.util;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SerializationUtilTest {

    @Test
    public void testSerialize() throws Exception {
        User user = new User();
        user.setUsername("zhangsan");
//        user.setPassword("010");
        FileUtils.writeByteArrayToFile(new File("serialize"),SerializationUtil.serialize(user));
    }

    @Test
    public void testDeserialize() throws Exception {
        org.rpc.service.server.util.User user = SerializationUtil.deserialize(FileUtils.readFileToByteArray(new File("serialize")), org.rpc.service.server.util.User.class);
        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
    }
    /*class User {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }*/
    class User {
        private String username;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }
}