package demo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * ClassName: AnalyzerMain <br/>
 * Description: TODO <br/>
 * Date: 2016-04-20 16:34 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-04-20 jdai@ created. <br/>
 */
public class AnalyzerMain {

    public static void main(String[] args) throws IOException {
        String zh = "我是一个中国人，我热爱我的国家";
        Analyzer standard = new StandardAnalyzer();
        analyze(zh,standard);


    }

    public static void analyze(String text,Analyzer analyzer) throws IOException {
        System.out.println(analyzer.getClass());
        TokenStream tokenStream = analyzer.tokenStream(text,new StringReader(text));
        Token token = tokenStream.next();
        while (token != null) {
            System.out.println(token);
            token = tokenStream.next();
        }
    }
}
