# aws-sns
Projeto de mensageria utilizando Spring Boot + Maven + AWS SNS.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Ter instalado o `Eclipse` ou outra IDE de desenvolvimento `Java`.
* Ter acesso aos web-services da Amazon em https://aws.amazon.com/pt/
* 

## ⚙️ Configurando o web-service SNS na Amazon

Faça login em sua conta da amazon e siga os passos:

```
1. Na dashboard de SNS, crie um tópico (ex: aws-sns) do tipo "Padrão".
2. Dentro deste tópico, crie uma assinatura do tipo "E-Mail-JSON"
3. Confirme a inscrição no e-mail recebido pela AWS.
4. Na dashboard de IAM, crie um usuário (ex: sns-user) do tipo Programático.
5. Para este usuário, crie um grupo (ex: sns-group) com a permissão AmazonSNSFullAccess.
```

## ☕ Configurando o projeto Java

Para usar a aplicação, siga estas etapas:

```
1. Vá ao arquivo "application.properties" e informe o arn do Tópico criado (ex: arn:aws:sns:us-east-1:999999999999:aws-sns) e a região (ex: us-east-1)
2. Vá na classe SnsListener e informe as propriedades aws.accessKeyId e aws.secretAccessKey que são obitadas no sns-user.
3. Execute a classe AwsSimpleNotificationServiceApplication como aplicação java.
```

## 🚀 Executando uma chamada no Postman

```
1. Crie uma nova HTTP Request.
2. Utilize o verbo "POST".
3. Informe a seguinte URL: http://localhost:8080/v1/aws-sns/sendMessage
3. Acesse o Body da request e selecione o tipo "raw". Altere o tipo Text para JSON.
4. Informe um um conteúdo em Json válido na área de digitação. (ex: {"produto": "Notebook","valor": "3500.00"})
5. Clique em SEND e aguarde. Caso a chamada retorne status 200, vá ao e-mail e consulte as propriedades recebidas.

```


## 📝 Licença

Copyright © 2022 - [ericksonmarqueti](https://github.com/ericksonmarqueti)

A permissão é concedida, gratuitamente, a qualquer pessoa que obtenha uma cópia deste arquivo, com restrição de publicar como SEU repositório. Porém, sem restrição nos direitos de usar, copiar, modificar e mesclar. Há ainda o cuidado de não utilizar as logos, imagens e font dentro do repositório, que representam uma empresa real com direitos autorais.

[⬆ Voltar ao topo](#aws-sns)<br>
