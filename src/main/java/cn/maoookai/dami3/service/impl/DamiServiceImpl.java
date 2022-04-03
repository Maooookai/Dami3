package cn.maoookai.dami3.service.impl;

import cn.maoookai.dami3.handler.FriendMessageEventHandler;
import cn.maoookai.dami3.handler.GroupMessageEventHandler;
import cn.maoookai.dami3.log.Log;
import cn.maoookai.dami3.service.DamiService;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.BotEvent;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Configuration
public class DamiServiceImpl implements DamiService {

    @Value("${qq.number}")
    private long qq;

    @Value("${qq.password}")
    private String password;

    @Value("${qq.device}")
    private BotConfiguration.MiraiProtocol device;

    @Bean
    @Override
    public void login() {
        Log.info("将要登录的QQ账号：" + qq);
        Log.info("密码：" + password);
        Log.info("登录协议：" + device);
        Bot dami = BotFactory.INSTANCE.newBot(qq, password, new BotConfiguration() {
            {
                setProtocol(device);
                setHeartbeatStrategy(HeartbeatStrategy.STAT_HB);
                setWorkingDir(new File("mirai"));
            }
        });
        dami.login();
        EventChannel<Event> channel = GlobalEventChannel.INSTANCE.filter(ev -> ev instanceof BotEvent && ((BotEvent) ev).getBot().getId() == qq);
        channel.exceptionHandler(exception -> {
                    Log.error(exception.toString());
                    return null;
        });
        channel.registerListenerHost(new FriendMessageEventHandler());
        channel.registerListenerHost(new GroupMessageEventHandler());
        Log.info("登录完成");
    }
}
