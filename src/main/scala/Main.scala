import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]) {
     val spark = SparkSession.builder.appName("TigerGraph Application").getOrCreate()

      // Read Transaction Vertices -> Read 1000 of the transactions from the TG DB in Spark
      val jdbcDF1 = spark.read.format("jdbc").options(
        Map(
          "driver" -> "com.tigergraph.jdbc.Driver",
          "url" -> "jdbc:tg:http://127.0.0.1:14240",
          "username" -> "tigergraph",
          "password" -> "tigergraph",
          "graph" -> "AMLSim", // graph name
          "dbtable" -> "vertex Transaction", // vertex type
          "limit" -> "1000", // number of vertices to retrieve
          "debug" -> "0")).load()
      jdbcDF1.show()

      // Read Edges -> Get all the transaction vertices connected to an account (9934) via the RECEIVE_TRANSACTION edge
      val jdbcDF2 = spark.read.format("jdbc").options(
        Map(
          "driver" -> "com.tigergraph.jdbc.Driver",
          "url" -> "jdbc:tg:http://127.0.0.1:14240",
          "username" -> "tigergraph",
          "password" -> "tigergraph",
          "graph" -> "AMLSim", // graph name
          "dbtable" -> "edge RECEIVE_TRANSACTION", // edge type
          "limit" -> "10", // number of edges to retrieve
          "source" -> "9934", // source vertex id
          "debug" -> "0")).load()
      jdbcDF2.show()

      // Run Query -> Run a query to select an account and view account's transactions
      val jdbcDF3 = spark.read.format("jdbc").options(
        Map(
          "driver" -> "com.tigergraph.jdbc.Driver",
          "url" -> "jdbc:tg:http://127.0.0.1:14240",
          "username" -> "tigergraph",
          "password" -> "tigergraph",
          "graph" -> "AMLSim", // graph name
          "dbtable" -> "query selectAccountTx(acct=9934)", // query name & parameters
          "debug" -> "0")).load()
      jdbcDF3.show()
  }
}