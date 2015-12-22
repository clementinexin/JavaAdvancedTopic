package org.java.learn.topic.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ClassName: PathTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 12:55 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\exercise");
        System.out.println(path.getFileName());

        Path relativePath = Paths.get("D:\\exercise","test");
        System.out.println(relativePath.toAbsolutePath());

        Path currentDirectory = Paths.get(".");
        System.out.println(currentDirectory.toAbsolutePath());
        System.out.println(currentDirectory.toAbsolutePath().normalize());

        Path normalizePath = Paths.get("..");
        System.out.println(normalizePath.toAbsolutePath().normalize());
    }
}
