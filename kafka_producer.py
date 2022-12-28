from kafka import KafkaProducer
import time

producer = KafkaProducer(bootstrap_servers='localhost:9092')
status = producer.bootstrap_connected()
print("Bootstrap Server Connected:", status)
for _ in range(100):
    producer.send('my-topic', b'{"type":"imp","id":"1","timestamp":"1672190999", "gender":"MALE","age":"20"}')
producer.flush()
