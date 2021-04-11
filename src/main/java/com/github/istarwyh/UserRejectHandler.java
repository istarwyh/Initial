package com.github.istarwyh;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: UserRejectHandler
 * @Author: wx:istarwyh
 * @Date: 2021-04-11 15:48
 * @Version: ing
 */
public class UserRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected: " + executor.toString());
    }
}
