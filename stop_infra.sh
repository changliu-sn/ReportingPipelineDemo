#!/bin/sh

KAFKA_PATH="/Users/chang/Documents/Playground/kafka_2.13-3.3.1/"
FLINK_PATH="/Users/chang/Documents/Playground/flink-1.16.0"

echo "Stop Kafka ZooKeeper"
${KAFKA_PATH}/bin/zookeeper-server-stop.sh >> log/kafka_zookeeper.log 2>&1

echo "Stop Kafka"
${KAFKA_PATH}/bin/kafka-server-stop.sh >> log/kafka.log 2>&1
