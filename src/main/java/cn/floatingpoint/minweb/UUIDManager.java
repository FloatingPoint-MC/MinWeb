package cn.floatingpoint.minweb;

import cn.floatingpoint.minweb.controller.MinController;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @projectName: MinWeb
 * @author: vlouboos
 * @date: 2023-07-22 14:25:41
 */
@Configurable
public class UUIDManager  {
    @PostConstruct
    public void run() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                MinController.uuids.forEach((s, aLong) -> {
                    if (System.currentTimeMillis() - aLong >= 300000) {
                        MinController.uuids.remove(s);
                    }
                });
            }
        }, 0, 1, TimeUnit.MINUTES);
    }
}
