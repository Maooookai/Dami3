package cn.maoookai.dami3.handler;

import cn.maoookai.dami3.log.Log;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class FriendMessageEventHandler extends SimpleListenerHost {

    @EventHandler
    public void onMessage(@NotNull MessageEvent event) {
        String messageContent = event.getMessage().contentToString();
        Log.info(event.getSender().getId() +"："+ messageContent);
    }

}
