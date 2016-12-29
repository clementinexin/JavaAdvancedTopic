package json.parse;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


/**
 * Created by daijiajia on 2016/11/23.
 */
public class GsonParser {

    public static void main(String[] args) throws IOException {

        String s = FileUtils.readFileToString(new File("src/test/resources/flagship.json"));


    }
}
