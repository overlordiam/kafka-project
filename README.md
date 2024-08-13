# Kafka-project

## Overview
This project demonstrates an end-to-end data pipeline using Apache Kafka, Java, and OpenSearch. The application reads a continuous stream of data from Wikimedia, processes it in real-time, and stores it in Kafka. The data is then sent to OpenSearch for storage and further analysis.

## A Preview
<div>
    <a href="https://www.loom.com/share/f5b2c46a716e4b49bd407922610f3932">
      <p>Kafka-project - Watch Video</p>
    </a>
    <a href="https://www.loom.com/share/f5b2c46a716e4b49bd407922610f3932">
      <img style="max-width:300px;" src="https://cdn.loom.com/sessions/thumbnails/f5b2c46a716e4b49bd407922610f3932-4da4ceb7a26bd501-full-play.gif">
    </a>
  </div>

## Components

#### Data Source: Wikimedia
- The application reads event changes (new posts or updates to existing ones) from Wikimedia in real-time.

#### Kafka Producer:
- The producer reads the event changes from Wikimedia and publishes them to a Kafka topic named `wikimedia.newChanges`.
- The topic is configured with 3 partitions to reduce latency by approximately 30%.

#### Kafka Topic Configuration:
- **Topic Name**: `wikimedia.newChanges`
- **Partitions**: 3
- This configuration allows for parallel processing and reduces latency.

#### Kafka Consumers:
- The application consists of 2 consumers reading from 3 partitions for increased throughput. Two consumers were enough to keep the lag to a trivial number.

#### OpenSearch:
- OpenSearch is used as the database to store every record from the Kafka topic.
- Data is sent to OpenSearch in batches, which increases throughput by approximately 15%.

## Technologies used
- Java
- Kafka
- Zookeeper
- ElasticSearch
- Event Handling

## How to run
1) Download Kafka and Zookeeper: https://www.conduktor.io/kafka/how-to-install-apache-kafka-on-windows/
2) Create an account on Bonsai to access Opensearch
3) Run the following command in a terminal to start Zookeeper
   ```bash
   zookeeper-server-start.sh ~/kafka_2.13-3.8.0/config/zookeeper.properties
4) Run the following command in a terminal to start Kafka
    ```bash
    kafka-server-start.sh ~/kafka_2.13-3.8.0/config/server.properties
5) Clone and download the code in from repository and run it in a Java IDE (preferably IntelliJ)
6) Run the Consumer classes followed by the Producer class
