package org.hsl.sample_api.notification.message;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

public class SlackMessage {

    @SerializedName("text")
    private String text;

    @SerializedName("channel")
    private String channel;

    @SerializedName("username")
    private String botName;

    @SerializedName("icon_emoji")
    private String iconEmoji;

    @SerializedName("icon_url")
    private String iconUrl;

    public SlackMessage(String text, String channel, String botName, String iconEmoji, String iconUrl) {
        this.text = text;
        this.channel = channel;
        this.botName = botName;

        if (StringUtils.isNotEmpty(iconEmoji)) {
            this.iconEmoji = iconEmoji;
        }

        if (StringUtils.isNotEmpty(iconUrl)) {
            this.iconUrl = iconUrl;
        }
    }
}
