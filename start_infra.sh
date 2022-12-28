#!/bin/sh

KAFKA_PATH="/Users/chang/Documents/Playground/kafka_2.13-3.3.1/"
FLINK_PATH="/Users/chang/Documents/Playground/flink-1.16.0"

echo "Start Kafka ZooKeeper"
${KAFKA_PATH}/bin/zookeeper-server-start.sh ${KAFKA_PATH}/config/zookeeper.properties > log/kafka_zookeeper.log 2>&1 &

sleep 10

echo "Start Kafka"
${KAFKA_PATH}/bin/kafka-server-start.sh ${KAFKA_PATH}/config/server.properties > log/kafka.log 2>&1 &
