package org.hsl.sample_api.notification.sender;

import org.hsl.sample_api.notification.message.SlackMessage;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackSender {

    private Logger logger = LoggerFactory.getLogger(SlackSender.class);

    @Value("${notification.slack.enabled}")
    private boolean slackEnabled;

    @Value("${notification.slack.webhook.url}")
    private String webhookUrl;

    @Value("${notification.slack.channel}")
    private String channel;

    @Value("${notification.slack.botName}")
    private String botName;

    @Value("${notification.slack.icon.emoji}")
    private String iconEmoji;

    @Value("${notification.slack.icon.url}")
    private String iconUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void sendSlack(String contents) {
        if (slackEnabled) {
            try {
                SlackMessage slackMessage = new SlackMessage(contents, channel, botName, iconEmoji, iconUrl);
                String payload = new Gson().toJson(slackMessage);

                // RestTeplate는 보통 bean으로 선언해서 씀
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

                HttpEntity<String> entity = new HttpEntity<>(payload, headers);
                restTemplate.postForEntity(webhookUrl, entity, String.class);
            } catch (Exception e) {
                logger.error("Unhandled Exception occurs while send slack. [Reason] : ", e);
            }
        }
    }
}
