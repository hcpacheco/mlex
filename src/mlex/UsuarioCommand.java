package mlex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;



public class UsuarioCommand
{		
	private final static int OPCAO_VOLTAR = 5;
	private static Repositorio repositorio = new Repositorio();
	private Scanner scanner = new Scanner(System.in);
	private Properties configuracoes = new Properties();
	private String usuario = "admin";
	private String senha = "admin";
	private String ordenacao = "n";
	Jogo jogoAtual;
	
	public UsuarioCommand()
	{
		if (new File("./.mlex.conf").exists() == false)
		{
			configuracoes.setProperty("usuario", "admin");
			configuracoes.setProperty("senha", "admin");
			configuracoes.setProperty("ordenado", "n");
			
			try
			{
				configuracoes.store(new FileOutputStream("./.mlex.conf"), null);
			}
			catch (IOException e) 
			{
				System.out.println("Problema escrevendo arquivo de configuracao default");
			}
		}
		else
		{
			try
			{
				configuracoes.load(new FileInputStream("./.mlex.conf"));
			}
			catch (IOException e)
			{
				System.out.println("Problema na leitura do arquivo de configuracao");
			}
			
			usuario = configuracoes.getProperty("usuario");
			senha = configuracoes.getProperty("senha");
			ordenacao = configuracoes.getProperty("ordenacao");
		}
	}
	
	String getUsuario()
	{
		return this.usuario;
	}
	
	String getSenha()
	{
		return this.senha;
	}
	
	String getOrdenacao()
	{
		return this.ordenacao;
	}
	
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
				
				//String nomeJogoProcurado = usuario digita nome do jogo;
				//int id = repositorio.getIdParaVerInfoDeJogo(nomeJogoProcurado);
				//abre arquivo com id;
				//imprime o jogo
				int opcaoJogo = -1;
				do
				{
					this.menuJogo(opcaoJogo);
					opcaoJogo = scanner.nextInt();
				} while (opcaoJogo != OPCAO_VOLTAR);
				break;
			case 2:
				//add um jogo
				repositorio.getInformacoesJogo();
				repositorio.adicionaJogo();
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
				//int filt = this.menuFiltro();
				//String nomefilt;
				//repositorio.filtroPorAtributoDoJogo(nomefilt, filt);
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
//				String nomeDeCategoria;
//				repositorio.filtroDascategorias(nomeDeCategoria, 0);
//								
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
//				String nomeDeCategoria;
//				repositorio.filtroDascategorias(nomeDeCategoria, 1);
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
		System.out.println("Digite o nome do jogo a ser pesquisado: ");
		String nomeJogoPesquisado = scanner.next();
		int idJogoPesquisado = repositorio.getIdParaVerInfoDeJogo(nomeJogoPesquisado);
		
		if (idJogoPesquisado == -1)
		{
			System.out.println("Jogo com esse nome nao existe no repositorio");
			return -1;
		}
		else
		{
			switch(opcaoDeJogo)
			{
				case -1:
					break;
				case 0:
					System.out.println("Digite o que deseja modificar");
					System.out.println("1 - nomeJogo"
									+ "2 - lancamento"
									+ "3 - desenvolvedor"
									+ "4 - versao"
									+ "5 - genero");
					int opcao = scanner.nextInt();
					String atributoAtualizado;
					switch (opcao)
					{
						case 1:
							System.out.println("Digite o nome atualizado do jogo:");
							atributoAtualizado = scanner.next();
							repositorio.atualizaAtributo(idJogoPesquisado, 1, atributoAtualizado);
							break;
						case 2:
							System.out.println("Digite a data atualizada de lancamento do jogo (DD/MM/AAAA):");
							repositorio.atualizaAtributo(idJogoPesquisado, 2, atributoAtualizado);
							break;
						case 3:
							System.out.println("Digite o nome atualizado do desenvolvedor do jogo:");
							repositorio.atualizaAtributo(idJogoPesquisado, 3, atributoAtualizado);
							break;
						case 4:
							System.out.println("Digite a versao atualizada  do jogo:");
							repositorio.atualizaAtributo(idJogoPesquisado, 4, atributoAtualizado);
							break;
						case 5:
							System.out.println("Digite o genero atualizado do jogo:");
							repositorio.atualizaAtributo(idJogoPesquisado, 5, atributoAtualizado);
							break;
						default:
							break;
					}
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
		}
		
		return opcaoDeJogo;
	}
	
	public int menuFiltro()
	{
		System.out.println("\n1)Filtrar por nome do jogo;\n"
				+ "2)Filtrar data do lancamento do jogo;\n"
				+ "3)Filtrar por nome do desenvolvedor do jogo;\n"
				+ "4)Cancela;\n");
		
		int opcaoDeFiltro = scanner.nextInt();
		
		return opcaoDeFiltro;
	}

}
