#!/bin/sh

KAFKA_PATH="/Users/chang/Documents/Playground/kafka_2.13-3.3.1/"

echo "Start Kafka ZooKeeper"
${KAFKA_PATH}/bin/zookeeper-server-start.sh ${KAFKA_PATH}/config/zookeeper.properties > log/kafka_zookeeper.log 2>&1 &
