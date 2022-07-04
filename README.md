# TigerGraph Spark Sample

A sample project reading from TigerGraph with Spark

## Quickstart

1. Install scala, spark, and sbt (`brew install scala && brew install apache-spark && brew install sbt`)
1. Load an on-premise TigerGraph AMLSim graph
1. Download the lastest `.jar` file of the JDBC TigerGraph Driver
1. Package the project (`sbt package`)
1. Run the project (`spark-submit --class "Main" --jars tigergraph-jdbc-driver-1.3.0.jar target/scala-2.12/tigergraph-spark-sample-project_2.12-1.0.jar`)

## Overview

This repository will walk you through how to get TigerGraph data using Spark. It shows three possible methods to do so: retrieving vertices, retrieving edges, and running queries. 

Check out a blog walking through the set-up and code [here](https://medium.com/datadriveninvestor/an-introduction-to-spark-and-tigergraph-88b07bb9f66b).
