package com.github.ericksonmarqueti.aws.sns.model;

/**
 * Response da mensagem a ser devolvida ao client.
 * 
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
public class MessageResponse {
	
    private Integer statusCode;
    private String message;
    private String publishedMessageId;

    public MessageResponse(Integer statusCode, String message, String publishedMessageId) {
        this.statusCode = statusCode;
        this.message = message;
        this.publishedMessageId = publishedMessageId;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getPublishedMessageId() {
        return publishedMessageId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SnsResponse{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", publishedMessageId='" + publishedMessageId + '\'' +
                '}';
    }
}
