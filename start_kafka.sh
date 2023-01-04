#!/bin/sh

KAFKA_PATH="/Users/chang/Documents/Playground/kafka_2.13-3.3.1/"

echo "Start Kafka"
${KAFKA_PATH}/bin/kafka-server-start.sh ${KAFKA_PATH}/config/server.properties > log/kafka.log 2>&1 &
