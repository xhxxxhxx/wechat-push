package work.sajor.wechatpush.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import work.sajor.wechatpush.service.Pusher;

/**
 *@ClassName JobWorker
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 16:00
 */
@Component
public class JobWorker {
    /**
     * 要推送的用户openid
     */
    @Value("${target.openId}")
    private String openId;

    @Autowired
    Pusher pusherService;

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning(){
        pusherService.push(openId);
    }

}
