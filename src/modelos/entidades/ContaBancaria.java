package modelos.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import modelos.excecoes.ExcecoesPadrao;

public abstract class ContaBancaria {
	
	private Integer numeroConta;
	private String titular;
	protected Double saldo;
	protected Double limiteSaque;
	private Date ultimoSaque;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}
	
	public Integer getNumeroConta() {
		return numeroConta;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public Double getLimiteSaque() {
		return limiteSaque;
	}
	
	public String getUltimoSaque() {
		return sdf.format(ultimoSaque);
	}
	
	public void gravaUltimoSaque(Date agora) {
		ultimoSaque = agora;
	}
	
	public void alteraLimite(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposito(Double deposito) {
		saldo += deposito;
	}
	
	public abstract void saque(Double valorSaque) throws ExcecoesPadrao;
	
}
