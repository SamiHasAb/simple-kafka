# kafka-publisher and kafka-consumer
Apache Kafka Publisher and kafka-consumer Examples using SpringBoot

# start zookeeper.start bat file 
zookeeper-server-start.bat D:\DEV-SOFTWARES\kafka_2.12-1.1.0\config\zookeeper.properties

# start kafka server
kafka-server-start.bat D:\DEV-SOFTWARES\kafka_2.12-1.1.0\config\server.properties

# Create Topic:
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic topicname

# Produce a message 
kafka-console-producer.bat --broker-list localhost:9092 --topic topicname

# Consume a message
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topicname
