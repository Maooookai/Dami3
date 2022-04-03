package cn.maoookai.dami3.task;

import cn.maoookai.dami3.log.Log;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class SyncFriendTask {

    @Scheduled(fixedRate = 10000)
    public void execute(){
        Log.info("task executed after 10s");
    }

}
