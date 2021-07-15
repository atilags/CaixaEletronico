package modelos.entidades;

import modelos.excecoes.ExcecoesPadrao;

public class PessoaJuridica extends ContaBancaria{
	
	// A unica diferen�a de pessoa Fisica para Juridica � que uma cobra 5 reais para o saque e a outra n�o tem essa cobran�a.
	
	public PessoaJuridica(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
		super(numeroConta, titular, saldo, limiteSaque);
	}
	
	@Override
	public void saque(Double valorSaque) throws ExcecoesPadrao {
		if(valorSaque>limiteSaque) {
			throw new ExcecoesPadrao("O valor inserido � maior que o limite permitido.");
		}
		if(valorSaque>saldo) {
			throw new ExcecoesPadrao("Saldo insuficiente.");
		}
		
		saldo -= valorSaque;
	}

}
