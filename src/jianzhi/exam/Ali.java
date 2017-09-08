package jianzhi.exam;

import java.util.Scanner;

/**
 * 有一个消息队列集群，集群里每台Broker的响应时间RT都不一样，但是每台Broker的极限服务QPS都是一样的，超过这个QPS会出现过载雪崩。而消息的生产者客户端，每次发送都会选择其中的一台broker来发送，一般来说发送逻辑是运行在一个线程池里面。假设cpu资源充足，通过实现一个负载均衡算法，使得生产者能够达到最大吞吐量，最优的平均响应时间，但是又不能把任何一台服务器压垮。已知每个broker的rt、极限qps，消息生产者的线程数量，请求总数，如果采用吞吐量最优的算法，求处理完所有请求需要的耗时，单位毫秒。
 * 概念说明：
 * QPS：query per second， 每秒请求量
 * RT：response time，请求的响应时间
 * Broker：消息队列的服务器
 * <p>
 * 200
 * 12,11,13,20,50
 * 40000
 * 8
 * 41000
 * <p>
 * <p>
 * 200
 * 1,1,1,10,10
 * 5000
 * 10
 * 5000
 * Created by liec on 2017-03-22.
 */
public class Ali {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxQps = Integer.valueOf(in.nextLine());
        final String[] rtList = in.nextLine().split(",");
        final int requestNum = Integer.valueOf(in.nextLine());
        final int threadNum = Integer.valueOf(in.nextLine());
        System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
    }

    /**
     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
     *
     * @return
     */
    static long doneTime(int maxQps, String[] rtList, int requestNum, int threadNum) {
        // 最大处理qps
        long qps_sum = 0;
        // 检查每一个broker的qps，根据其rt
        for (int i = 0; i < rtList.length; i++) {
            long brokerQps = threadNum * 1000 / Integer.valueOf(rtList[i]);
            // 防止雪崩
            qps_sum += brokerQps > maxQps ? maxQps : brokerQps;
        }
        // 最终整个集群的处理能力
        long doneTime = requestNum * 1000 / qps_sum;
        return doneTime;
    }
}
