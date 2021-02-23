/* SimpleApp.java */
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;

public class SimpleApp {
    public static void main(String[] args) {
        String logFile = "/Users/liugaofei/Documents/DevelopTool/spark-2.4.5-bin-hadoop2.7/README.md"; // Should be some file on your system
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile).cache();
//
//        logData.filter(s.);
//
//       long numAs = logData.filter(s -> s.contains("a")).count();
//       long numBs = logData.filter(s -> s.contains("b")).count();

//       System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        spark.stop();
    }
}
