package com.github.ericksonmarqueti.aws.sns.model;

import java.math.BigDecimal;

/**
 * Representa os atributos da mensagem.
 * 
 * @author Erickson Marqueti (ericomarqueti@gmail.com)
 */
public class Message {
	
    private String produto;
    private BigDecimal valor;

    public Message(String produto, BigDecimal valor) {
        this.produto = produto;
        this.valor = valor;
    }

    public String getProduto() {
		return produto;
	}
    
    public void setProduto(String produto) {
		this.produto = produto;
	}
    
    public BigDecimal getValor() {
		return valor;
	}
    
    public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
    
}
