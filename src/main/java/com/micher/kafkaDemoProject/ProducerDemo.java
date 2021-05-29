package com.micher.kafkaDemoProject;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {

    private static final String BOOTSTRAP_SERVERS = "localhost:9092";

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", BOOTSTRAP_SERVERS);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //create producer
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);

        //create a producer record
        ProducerRecord<String, String> record = new ProducerRecord<>("firstTopic", "Hello world!");

        kafkaProducer.send(record);

        //flush data
        kafkaProducer.flush();
        //flush data and close
        kafkaProducer.close();

    }
}
