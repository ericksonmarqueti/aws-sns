package com.github.ericksonmarqueti.aws.sns.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Listener com as propriedades da aws.
 * 
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
public class SnsListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    
	/**
	 * {@inheritDoc}
	 */
	@Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.setProperty("aws.accessKeyId", "informeSeukeyId");
        System.setProperty("aws.secretAccessKey", "informeSeuSecretKey");
    }
}
