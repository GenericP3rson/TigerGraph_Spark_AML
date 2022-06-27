# TigerGraph Spark Sample

A sample project reading from TigerGraph with Spark

## Quickstart

1. Install scala, spark, and sbt (`brew install scala && brew install apache-spark && brew install sbt`)
1. Load an on-prem socialNet graph
1. Download the lastest `.jar` file of the JDBC TigerGraph Driver
1. Package the project (`sbt package`)
1. Run the project 
```
/usr/local/Cellar/apache-spark/3.2.1/bin/spark-submit \                   
  --class "Main" \
--jars tigergraph-jdbc-driver-1.3.0.jar \
target/scala-2.12/tigergraph-spark-sample-project_2.12-1.0.jar
```
