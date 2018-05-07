package producer;



import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * @description: 0.8版本生产者
 * @author: kylin.qiuwx@foxmail.com
 * @create: 2018-05-04
 **/
public class ProducerTest {
    public static void main(String[] args) {
        long events = Long.parseLong("20");
        Random rnd = new Random();

        Properties props = new Properties();
        props.put("metadata.broker.list", "demo228.test.com:6667");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "producer.SimplePartitioner");
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<String, String>(config);

        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = System.currentTimeMillis();
            String ip = "192.168.2." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
            producer.send(data);
            System.out.println("==V8===");
        }
        producer.close();
    }
}
