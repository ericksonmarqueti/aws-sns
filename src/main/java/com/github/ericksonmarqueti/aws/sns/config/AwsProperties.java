package com.github.ericksonmarqueti.aws.sns.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

/**
 * Provê as configurações da aplicação. 
 * @see application.properties
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
@Configuration
@ConfigurationProperties(prefix = "aws.sns")
public class AwsProperties {

    @NotNull
    private String region;

    @NotNull
    private String topicArn;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTopicArn() {
        return topicArn;
    }

    public void setTopicArn(String topicArn) {
        this.topicArn = topicArn;
    }
}
