from kafka import KafkaProducer
import time
import random
import json

producer = KafkaProducer(bootstrap_servers='localhost:9092')
status = producer.bootstrap_connected()
print("Bootstrap Server Connected:", status)
for _ in range(100):
    msg = json.dumps(
        {
            "type": random.choice(["imp", "vimp", "click"]), 
            "id": random.randint(1, 5), 
            "timestamp": int(time.time()), 
            "gender": random.choice(["MALE", "FEMALE"]), 
            "age": random.randint(18, 20),
        }, 
        sort_keys=True
    )
    print("Send Msg:", msg) 
    producer.send('my-topic', msg.encode('utf-8'))
producer.flush()
