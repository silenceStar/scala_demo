import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object WordCountDataframe {
  def main(args: Array[String]): Unit = {


    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("demo")

    val ss: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    val sc: SparkContext = ss.sparkContext

    sc.setLogLevel("WARN")

    val lineFile: RDD[String] = sc.textFile("/Users/liugaofei/Documents/test/person.text")

    val lineWord: RDD[Array[String]] = lineFile.map(_.split(" "))

    val student: RDD[Row] = lineWord.map(word => Row(word(0).toInt,word(1).toString,word(2).toInt))

    //指定structType
    val structType = StructType(
      StructField("id", IntegerType, true) ::
        StructField("name", StringType, false) ::
        StructField("age", IntegerType, false) :: Nil)

//    import ss.implicits._
//
//    val stuData: DataFrame = student.toDF()

  val stuData : DataFrame = ss.createDataFrame(student,structType)


    stuData.persist()

    stuData.show()

    stuData.printSchema()


    ss.stop()
    sc.stop()







  }

}
