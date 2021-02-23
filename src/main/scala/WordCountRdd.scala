import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.ui.SparkListenerSQLExecutionEnd
import org.apache.spark.{SparkConf, SparkContext}

object WordCountRdd {
  def main(args: Array[String]): Unit = {


    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("demo")


    val sc: SparkContext = SparkContext.getOrCreate(conf)

    sc.setLogLevel("WARN")

    val lineFile: RDD[String] = sc.textFile("/Users/liugaofei/Documents/test/a.text")



    val wordList: RDD[String] = lineFile.flatMap(line => line.split(" "))

    val wordMap: RDD[(String, Int)] = wordList.map(line => (line,1))

     wordMap.reduceByKey(_+_).foreach(value =>



       print(value+"\n")

     )


     val session: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    val context: SparkContext = session.sparkContext










    sc.stop();
  }

}
