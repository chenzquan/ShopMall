package com.mmall.task;


import com.mmall.common.Const;
import com.mmall.common.RedisShardedPool;
import com.mmall.service.IOrderService;
import com.mmall.util.PropertiesUtil;
import com.mmall.util.RedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CloseOrderTask {

    @Autowired
    private IOrderService iOrderService;

    //这样写的话 集群下的后台 都会执行
//    @Scheduled(cron = "0 */1 * * * ?")//每1分钟(每个1分钟的整数倍)
    public void closeOrderTaskV1(){
        log.info("关闭订单定时任务启动");
        int hour = Integer.parseInt(PropertiesUtil.getProperty("close.order.task.time.hour","2"));
        iOrderService.closeOrder(hour);
        log.info("关闭订单定时任务结束");
    }

    //这里设置的value是一个时间戳 但没有利用起来
    @Scheduled(cron = "0 */1 * * * ?")
    public void closeOrderTaskV2(){
        log.info("关闭订单定时任务启动");

        long lockTimeout = Long.parseLong(PropertiesUtil.getProperty("lock.timeout","5000"));

        Long setnxResult = RedisPoolUtil.setnx(Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK,String.valueOf(System.currentTimeMillis() + lockTimeout));

        if(setnxResult!=null && setnxResult.intValue()==1){
            //如果返回值是1，代表设置成功，获取锁
            closeOrder(Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK);
        }else{
            log.info("没有获得分布式锁:{}",Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK);
        }
        log.info("关闭订单定时任务结束");
    }






    private void  closeOrder(String lockName){
        RedisPoolUtil.expire(lockName,50); //有效期为50秒， 防止死锁
        log.info("获取{}，ThreadName:{}",Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK,Thread.currentThread().getName());
        int hour = Integer.parseInt(PropertiesUtil.getProperty("closeo.order.task.time.hour","2"));
//        iOrderService.closeOrder(hour);
        RedisPoolUtil.del(Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK);

        log.info("释放{}，ThreadName:{}",Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK,Thread.currentThread().getName());
        log.info("====================================");

    }

}
