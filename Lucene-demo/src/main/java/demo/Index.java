package demo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * ClassName: Index <br/>
 * Description: TODO <br/>
 * Date: 2016-04-20 15:01 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-04-20 jdai@ created. <br/>
 */
public class Index {

    public static final String indexPath = "src/main/resources";

    public static void main(String[] args) throws IOException, ParseException {
        create();
        query();

    }

    public static void create() throws IOException {
        Directory dir = FSDirectory.getDirectory(new File(indexPath));
        Analyzer analyzer = new StandardAnalyzer();
        Document doc = new Document();
        doc.add(new Field("name","zhangsan", Field.Store.YES, Field.Index.TOKENIZED));
        doc.add(new Field("address","pek", Field.Store.YES, Field.Index.TOKENIZED));
        doc.add(new Field("sex","m", Field.Store.YES, Field.Index.TOKENIZED));
        doc.add(new Field("introduce","just a coder", Field.Store.YES, Field.Index.NO));
        IndexWriter indexWriter = new IndexWriter(dir,analyzer, true);
        indexWriter.addDocument(doc);
        indexWriter.close();
    }

    public static void query() throws ParseException, IOException {
        String queryStr = "zhangsan";
        String[] fields = {"introduce"};

        Analyzer analyzer = new StandardAnalyzer();
        QueryParser queryParser = new MultiFieldQueryParser(fields,analyzer);
        Query query = queryParser.parse(queryStr);

        IndexSearcher indexSearcher = new IndexSearcher(FSDirectory.getDirectory(new File(indexPath)));
        Filter filter = null;
        TopDocs docs = indexSearcher.search(query,filter,1000);
        System.out.println("hits: " + docs.totalHits);
        for (ScoreDoc doc : docs.scoreDocs) {
            Document document = indexSearcher.doc(doc.doc);
            List<Fieldable> fieldList = document.getFields();
            for (Fieldable fieldable : fieldList) {
                System.out.println(fieldable.name());
                System.out.println(fieldable.stringValue());
            }
        }
    }
}
