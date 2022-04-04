package cn.maoookai.dami3.handler;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class GroupMessageEventHandler extends SimpleListenerHost {

    @EventHandler
    public void onMessage(@NotNull GroupMessageEvent event) {
        String messageContent = event.getMessage().contentToString();
    }

}
