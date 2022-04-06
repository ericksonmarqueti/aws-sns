package com.github.ericksonmarqueti.aws.sns.service;

import com.github.ericksonmarqueti.aws.sns.config.AwsProperties;
import com.github.ericksonmarqueti.aws.sns.model.Message;
import com.github.ericksonmarqueti.aws.sns.model.RequestBuilder;
import com.github.ericksonmarqueti.aws.sns.model.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.exception.SdkServiceException;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

/**
 * Serviço de mensageria através da aws.
 * 
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
@Service
public class MessageService {
	
    private final static Logger LOG = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private SnsClient snsClient;
    
    @Autowired
    private AwsProperties awsProperties;

    public MessageResponse publish(Message message) {
        MessageResponse response = null;

        try {
            PublishRequest request = RequestBuilder.build(awsProperties.getTopicArn(), message);
            LOG.info("Request: {}", request);

            PublishResponse publishResponse = snsClient.publish(request);
            LOG.info("Publish response: {}", publishResponse);

            SdkHttpResponse httpResponse = publishResponse.sdkHttpResponse();
            
            response = new MessageResponse(
                    httpResponse.statusCode(),
                    httpResponse.statusText().orElse(null),
                    publishResponse.messageId());
            
            LOG.info("Response details: {}", response);
        } catch (SnsException e) {
            rethrow(e.statusCode(), e.getClass().getSimpleName() + ": " + e.awsErrorDetails());
        } catch (SdkServiceException e) {
            rethrow(e.statusCode(), e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (SdkClientException e) {
            rethrow(null, e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (SdkException e) {
            rethrow(null, e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return response;
    }

    private void rethrow(Integer statusCode, String detailedMessage) {
        MessageResponse response = new MessageResponse(statusCode, detailedMessage, null);
        throw new RuntimeException(response.toString());
    }
}
