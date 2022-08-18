package work.sajor.wechatpush.controller;

/**
 *@ClassName PushController
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 15:48
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.sajor.wechatpush.service.Pusher;

@RestController
public class PushController {
    /**
     * 要推送的用户openid
     */
    @Value("${target.openId}")
    private String target;
    @Value("${target.test.openId}")
    private String testTarget;

    @Autowired
    Pusher pusherService;

    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/push")
    public void push() {
        pusherService.push(target);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/test")
    public void pushTest() {
        pusherService.push(testTarget);
    }


    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) {
        pusherService.push(id);
    }
}