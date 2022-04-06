package com.github.ericksonmarqueti.aws.sns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.ericksonmarqueti.aws.sns.config.SnsListener;

/**
 * Aplicação para rodar um notificação de mensagem via aws.
 * 
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
@SpringBootApplication
public class AwsSimpleNotificationServiceApplication {

	public static void main(String[] args) {
		// Instanciar a aplicação.
        SpringApplication app = new SpringApplication(AwsSimpleNotificationServiceApplication.class);
        // Adiciona o listener com a chave e secret da aws.
        app.addListeners(new SnsListener());
        // Executa a aplicação com os argumentos.
        app.run(args);
	}

}
