package org.hsl.sample_api.notification;

import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;
import org.hsl.sample_api.notification.sender.SlackSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationManager {

    // 롬복 로거를 쓰면 아래 줄을 안써도 됨
    //private Logger logger = LoggerFactory.getLogger(NotificationManager.class);

    private final SlackSender slackSender;

    public NotificationManager(SlackSender slackSender) {
        this.slackSender = slackSender;
    }

    public void sendNotification(String stackTrace) {
        log.info("#### Send Notification");

        String contents = generateMessage(stackTrace);

        slackSender.sendSlack(contents);
    }

    private String generateMessage(String stackTrace) {
        return new StringJoiner(System.getProperty("line.separator"))
            .add("[Notification]")
            .add("[Exception Occurs]")
            .add("[Stack Trace] : " + stackTrace).toString();
    }
}
