/**
 * Created by frankstaszak on 1/16/17.
 */
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;

public class SparkJava {

    private static final String APP_NAME = "SparkJava";
    private static final String SPARK_MASTER = "local[*]";
    private static final String WORDS_FILE = "/usr/share/dict/words";

    public static void main(String[] args) {

        SparkConf sparkConf = new SparkConf()
                .setAppName(APP_NAME)
                .setMaster(SPARK_MASTER);

        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // Define RDD from os x words file and return words containing SearchString
        JavaRDD<String> wordList = sc.textFile(WORDS_FILE).filter(s -> s.contains("spark"));

        sc.stop();
    }
}
