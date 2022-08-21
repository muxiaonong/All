package com.muxiaonong.normal;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 同步发送
 */
public class SyncProducer {


    public static void main(String[] args) throws Exception{
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group_test");

        // 设置NameServer的地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        //producer.setSendLatencyFaultEnable(true);

        // 启动Producer实例
        producer.start();


        for (int i = 0; i < 10; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // 发送消息到一个Broker
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }

}
