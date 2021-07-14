package programa;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelos.entidades.ContaBancaria;
import modelos.entidades.PessoaFisica;
import modelos.entidades.PessoaJuridica;
import modelos.excecoes.ExcecoesPadrao;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		
		List<ContaBancaria> cadastros = new ArrayList<>();
		
		try {
			System.out.print("Digite a quantidade de cadastros a ser realizado: ");
			int quant = tec.nextInt();
			
			for(int i = 0; i < quant; i++) {
				tec.nextLine();
				System.out.print("Informe o nome do titular: ");
				String titular = tec.nextLine();
				
				System.out.print("Informe o número da conta: ");
				Integer numeroConta = tec.nextInt();
				
				System.out.print("Informe o saldo inicial: ");
				Double saldo = tec.nextDouble();
				
				System.out.print("Informe qual o limite de saque para a conta: ");
				Double limiteSaque = tec.nextDouble();
				
				int escolha;
				do {
					System.out.print("Informe se essa é uma conta para Pessoa Física(1) ou Pessoa Jurídica(2), digite 1 ou 2: ");
					escolha = tec.nextInt();
					
					switch(escolha) {
						case 1:
							cadastros.add(new PessoaFisica(numeroConta, titular, saldo, limiteSaque));
							break;
						case 2:
							cadastros.add(new PessoaJuridica(numeroConta, titular, saldo, limiteSaque));
							break;
						default:
							System.out.print("Opção não reconhecida.");
							escolha = 3;
					}
				} while(escolha == 3);
				
				for(ContaBancaria contas: cadastros) {
					do {
						System.out.println();
						System.out.print("- Digite a opção desejada -");
						System.out.println();
						System.out.println("1 - Saldo");
						System.out.println("2 - Saque");
						System.out.println("3 - Deposito");
						System.out.println("4 - Data do ultimo Saque");
						System.out.println("5 - Sair");
						escolha = tec.nextInt();
						
						switch(escolha) {
							case 1:
								System.out.println("Seu saldo é: R$" + String.format("%.2f", contas.getSaldo()));
								System.out.println("Operação realizada com sucesso!");
								escolha = 6;
								break;
							case 2:
								System.out.print("Valor de saque: ");
								Double valorSaque = tec.nextDouble();
								contas.saque(valorSaque);
								Date now = new Date();
								contas.gravaUltimoSaque(now);
								System.out.println("Operação realizada com sucesso!");
								escolha = 6;
								break;
							case 3:
								System.out.print("Valor de deposito: ");
								Double deposito = tec.nextDouble();
								contas.deposito(deposito);
								System.out.println("Operação realizada com sucesso!");
								escolha = 6;
								break;
							case 4:
								System.out.println("Data e hora do ultimo saque: " + contas.getUltimoSaque());
								System.out.println("Operação realizada com sucesso!");
								escolha = 6;
								break;
							case 5:
								System.out.println("Obrigado pela preferencia.");
								break;
							default:
								System.out.print("Opção não reconhecida.");
								escolha = 6;
						}
						
					} while(escolha == 6);
				}
			}
		}
		catch(ExcecoesPadrao e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println();
			System.out.println("Algo foi digitado incorretamente.");
		}
		catch(RuntimeException e) {
			System.out.println();
			System.out.println("Algum erro inexperado ocorreu, sinto muito pelo transtorno.");
		}
		
		tec.close();
	}

}
