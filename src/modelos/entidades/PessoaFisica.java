package modelos.entidades;

import modelos.excecoes.ExcecoesPadrao;

public class PessoaFisica extends ContaBancaria{
	
	public PessoaFisica(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
		super(numeroConta, titular, saldo, limiteSaque);
	}
	
	@Override
	public void saque(Double valorSaque) throws ExcecoesPadrao {
		if(valorSaque>limiteSaque) {
			System.out.println();
			throw new ExcecoesPadrao("O valor inserido � maior que o limite permitido.");
		}
		if((valorSaque + 5)>saldo) {
			System.out.println();
			throw new ExcecoesPadrao("Saldo insuficiente.");
		}
		
		saldo -= (valorSaque + 5);
	}
}
