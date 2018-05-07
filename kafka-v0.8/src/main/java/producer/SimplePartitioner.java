package producer;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * @description: 分区实现类
 * @author: kylin.qiuwx@foxmail.com
 * @create: 2018-05-07
 **/
public class SimplePartitioner implements Partitioner {
    public SimplePartitioner (VerifiableProperties props) {

    }

    public int partition(Object key, int a_numPartitions) {
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf('.');
        if (offset > 0) {
            partition = Integer.parseInt( stringKey.substring(offset+1)) % a_numPartitions;
        }
        return partition;
    }
}
