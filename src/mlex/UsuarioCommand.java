package mlex;

import java.io.IOException;
import java.util.Scanner;


public class UsuarioCommand
{		
	private final static int OPCAO_VOLTAR = 5;
	private static Repositorio repositorio = new Repositorio();
	private Scanner scanner = new Scanner(System.in);
	
	
	public int menuInicial(int opcaoMenu)
	{
		switch(opcaoMenu)
		{
			case -1:
				break;
			case 0:
				//ver tds jogos
				break;
			case 1:
				//ve um jogo e pode:
				//remove-lo, modifica-lo, adicionar comentario, verificar integridade, enviar por email
				int opcaoJogo = -1;
				do
				{
					this.menuJogo(opcaoJogo);
					opcaoJogo = scanner.nextInt();
				} while (opcaoJogo != OPCAO_VOLTAR);
				break;
			case 2:
				//add um jogo
				break;
			case 3:
				//opcoes da colecoes
				int opcaoCategoria = -1;
				do
				{
					this.menuCategorias(opcaoCategoria);
					opcaoCategoria = scanner.nextInt();
				} while (opcaoCategoria != OPCAO_VOLTAR);
				break;
			case 4:
				//filtroo
				break;
			case 5:
				//configs
				break;
			case 666:
				//encerra o programa
				break;
			default: 
				System.out.println("Nao eras, meu bruxo!");
		}
		
		System.out.println("\n0)Mostrar os jogos do repositorio;\n"
				+ "1)Selecionar jogo;\n"
				+ "2)Adicionar um jogo ao repositorio;\n"
				+ "3)Acessar colecoes;\n"
				+ "4)Filtrar jogos;\n"
				+ "5)Configuracoes do usuario;\n"
				+ "666)Sair;\n"
				+ "Escolha a acao que deseja realizar: ");
		
		return opcaoMenu;
	}
	
	public int menuCategorias(int opcaoDeCategoria)
	{
		//exibe todas colecoes --- CICA FAZ ISSO AQUI
		
		switch(opcaoDeCategoria)
		{
			case -1:
				break;
			case 0:
				//exibe jogos em x colecao
				break;
			case 1:
				//cria nova colecao
				break;
			case 2:
				//adiciona um jogo a uma colecao
				break;
			case 3:
				//remove um jogo de uma colecao
				break;
			case 4:
				//filtra jogos dentro de uma colecao
				break;
			case 5:
				break;
			default: 
				System.out.println("Nao eras, meu bruxo!");
		}
		
		System.out.println("\n0)Buscar jogos da colecao;\n"
				+ "1)Criar colecao;\n"
				+ "2)Adicionar um jogo a colecao;\n"
				+ "3)Remover jogo de colecao;\n"
				+ "4)Filtrar colecoes;\n"
				+ "5)Voltar;\n"
				+ "Escolha a acao que deseja realizar: ");
		
		
		return opcaoDeCategoria;
	}
	
	public int menuJogo(int opcaoDeJogo)
	{
		//busca por um jogo -- CICA FAIS GALERO
		
		switch(opcaoDeJogo)
		{
			case -1:
				break;
			case 0:
				//modifica
				break;
			case 1:
				//remove
				break;
			case 2:
				//adicionar comentario
				break;
			case 3:
				//verificar integridade
				break;
			case 4:
				//enviar por email
				break;
			case 5:
				//volta
				break;
			default: 
				System.out.println("Nao eras, meu bruxo!");
		}
		
		System.out.println("\n0)Modificar informacoes;\n"
				+ "1)Remover do repositorio;\n"
				+ "2)Adicionar comentario;\n"
				+ "3)Verificar integridade;\n"
				+ "4)Recomendar para um amigo;\n"
				+ "5)Voltar;\n"
				+ "Escolha a acao que deseja realizar: ");		
		
		return opcaoDeJogo;
	}

}
