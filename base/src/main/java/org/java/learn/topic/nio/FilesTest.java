package org.java.learn.topic.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;

/**
 * ClassName: FilesTest <br/>
 * Description: TODO <br/>
 * Date: 2015-12-22 13:43 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2015-12-22 jdai@ created. <br/>
 */
public class FilesTest {
    public static void main(String[] args) {

        Path path = Paths.get("D:\\exercise\\test");
        boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        System.out.println(exists);
        Path newPath = null;
        if (!exists) {
            try {
                newPath = Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Files.exists(newPath, LinkOption.NOFOLLOW_LINKS));


        Path root = Paths.get("D:\\exercise");
        try {
            Files.createFile(Paths.get("D:\\exercise\\test", "README.txt"), new FileAttribute[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        final String fileToFind = File.separator + "README.txt";
        try {
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    //System.out.println("pathString = " + fileString);

                    if (fileString.endsWith(fileToFind)) {
                        System.out.println("file found at path: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
