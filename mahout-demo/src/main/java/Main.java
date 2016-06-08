import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

/**
 * Created by daijiajia on 16/6/2.
 */
public class Main {

    public static void main(String[] args) {
        try {
            // 从文件加载数据
            DataModel model = new FileDataModel(new File("/Users/daijiajia/IdeaProjects/JavaAdvancedTopic/mahout-demo/src/main/resources/data.csv"));
            // 指定用户相似度计算方法，这里采用皮尔森相关度
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            // 指定用户邻居数量，这里为2
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,
                    similarity, model);
            // 构建基于用户的推荐系统
            Recommender recommender = new GenericUserBasedRecommender(model,
                    neighborhood, similarity);
            // 得到指定用户的推荐结果，这里是得到用户1的两个推荐
            List<RecommendedItem> recommendations = recommender.recommend(1, 2);
            // 打印推荐结果
            for (RecommendedItem recommendation : recommendations) {
                System.out.println(recommendation);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
