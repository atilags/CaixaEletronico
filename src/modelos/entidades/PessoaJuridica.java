package modelos.entidades;

import modelos.excecoes.ExcecoesPadrao;

public class PessoaJuridica extends ContaBancaria{
	
	// A unica diferença de pessoa Fisica para Juridica é que uma cobra 5 reais para o saque e a outra não tem essa cobrança.
	
	public PessoaJuridica(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
		super(numeroConta, titular, saldo, limiteSaque);
	}
	
	@Override
	public void saque(Double valorSaque) throws ExcecoesPadrao {
		if(valorSaque>limiteSaque) {
			throw new ExcecoesPadrao("O valor inserido é maior que o limite permitido.");
		}
		if(valorSaque>saldo) {
			throw new ExcecoesPadrao("Saldo insuficiente.");
		}
		
		saldo -= valorSaque;
	}

}
