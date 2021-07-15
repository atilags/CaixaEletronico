package modelos.entidades;

import modelos.excecoes.ExcecoesPadrao;

public class PessoaFisica extends ContaBancaria{
	
	public PessoaFisica(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
		super(numeroConta, titular, saldo, limiteSaque);
	}
	
	@Override
	public void saque(Double valorSaque) throws ExcecoesPadrao {
		if(valorSaque>limiteSaque) {
			throw new ExcecoesPadrao("O valor inserido é maior que o limite permitido.");
		}
		if((valorSaque + 5)>saldo) {
			throw new ExcecoesPadrao("Saldo insuficiente.");
		}
		
		saldo -= (valorSaque + 5);
	}
}
