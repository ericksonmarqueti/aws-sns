package com.github.ericksonmarqueti.aws.sns.model;

import software.amazon.awssdk.services.sns.model.MessageAttributeValue;
import software.amazon.awssdk.services.sns.model.PublishRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Construtor de um request para ser publicado.
 * 
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
public class RequestBuilder {
    
	// Atributos
	public static final String PRODUTO = "Produto";
    public static final String VALOR = "Valor";
 
    // Mensagem
    public static final String MESSAGE = "Essa mensagem pode conter atributos em JSON.";

    /**
     * Cria a mensagem a ser publicada.
     * @param topicArn
     * @param message
     * @return um {@link PublishRequest}
     */
    public static PublishRequest build(String topicArn, Message message) {
        Map<String, MessageAttributeValue> attributes = new HashMap<>();
        
        attributes.put(PRODUTO, buildAttribute(message.getProduto(), "String"));
        attributes.put(VALOR, buildAttribute(message.getValor().toString(), "Number"));

        PublishRequest request = PublishRequest.builder()
                .topicArn(topicArn)
                .message(MESSAGE)
                .messageAttributes(attributes)
                .subject("Mensagem gerada usando Spring Boot, Maven e AWS SNS")
                .build();

        return request;
    }

    private static MessageAttributeValue buildAttribute(String value, String dataType) {
        return MessageAttributeValue.builder()
                .dataType(dataType)
                .stringValue(value)
                .build();
    }
}
