package cn.ukar.pool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jyou on 2017/9/6.
 */
public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕" + ThreadPoolSign.getInstance().getExecutor().getPoolSize());
    }

    public static void main(String[] args) {
        ThreadPoolSign instance = ThreadPoolSign.getInstance();
        ThreadPoolExecutor executor = instance.getExecutor();
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
