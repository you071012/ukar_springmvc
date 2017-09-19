package cn.ukar.pool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jyou on 2017/9/6.
 *
 * 模拟写一个单例，获取线程池
 */
public class ThreadPoolSign {
    private static final String lock = "lock";
    //参数，1：核心池的大小，2：线程池最大线程数，3：表示线程没有任务执行时最多保持多久时间会终止，4：参数keepAliveTime的时间单位，5：队列
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
    private ThreadPoolSign() {}
    private static ThreadPoolSign single=null;
    //静态工厂方法
    public static ThreadPoolSign getInstance() {
        synchronized (lock){
            if (single == null) {
                single = new ThreadPoolSign();
            }
        }
        return single;
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    public static void main(String[] args) {
        long time = 1504678320060l;
        Date date = new Date(time);
        System.out.println(date);
    }
}
