import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]) {
     val spark = SparkSession.builder.appName("Simple Application").getOrCreate()

      // read vertex
      val jdbcDF1 = spark.read.format("jdbc").options(
        Map(
          "driver" -> "com.tigergraph.jdbc.Driver",
          "url" -> "jdbc:tg:http://localhost:14240",
          "username" -> "tigergraph",
          "password" -> "tigergraph",
          "graph" -> "socialNet", // graph name
          "dbtable" -> "vertex post", // vertex type
          "limit" -> "10", // number of vertices to retrieve
          "debug" -> "0")).load()
      jdbcDF1.show()

      // read edge
      val jdbcDF2 = spark.read.format("jdbc").options(
        Map(
          "driver" -> "com.tigergraph.jdbc.Driver",
          "url" -> "jdbc:tg:http://127.0.0.1:14240",
          "username" -> "tigergraph",
          "password" -> "tigergraph",
          "graph" -> "socialNet", // graph name
          "dbtable" -> "edge friend", // edge type
          "limit" -> "10", // number of edges to retrieve
          "source" -> "person2", // source vertex id
          "debug" -> "0")).load()
      jdbcDF2.show()
  }
}