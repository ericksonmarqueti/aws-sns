package com.github.ericksonmarqueti.aws.sns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.ericksonmarqueti.aws.sns.model.Message;
import com.github.ericksonmarqueti.aws.sns.model.MessageResponse;
import com.github.ericksonmarqueti.aws.sns.service.MessageService;

/**
 * Disponibiliza os endpoints de mensageria. 
 * 
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
@RestController
@RequestMapping(value = "v1/aws-sns")
public class MessageController {

	@Autowired
    private MessageService messageService;

    @PostMapping(value = "/sendMessage")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse publishMessage(@RequestBody Message message) {
        return messageService.publish(message);
    }

}
