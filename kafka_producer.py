from kafka import KafkaProducer
import time
import json

producer = KafkaProducer(bootstrap_servers='localhost:9092')
status = producer.bootstrap_connected()
print("Bootstrap Server Connected:", status)
for _ in range(100):
    msg = json.dumps({"type": "imp", "id": 2, "timestamp": int(time.time()), "gender": "MALE", "age": 20}, sort_keys=True)
    #producer.send('my-topic', b'{"type":"imp","id":"1","timestamp":"1672190999", "gender":"MALE","age":"20"}')
    producer.send('my-topic', msg.encode('utf-8'))
producer.flush()
