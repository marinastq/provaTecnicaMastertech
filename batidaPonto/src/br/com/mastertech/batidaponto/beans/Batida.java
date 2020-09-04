package br.com.mastertech.batidaponto.beans;

import java.util.Date;

public class Batida {
	
	//id, dataHora, tipo
	private int id; 
	private Date dataBatida;
	private String tipo; //E - entrada S - saida
	
	public Batida(int id, Date dataBatida, String tipo) {
		super();
		this.id = id;
		this.dataBatida = dataBatida;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}
	public Date getDataBatida() {
		return dataBatida;
	}
	public String getTipo() {
		return tipo;
	}
}
