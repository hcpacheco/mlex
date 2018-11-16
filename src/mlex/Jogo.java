package mlex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jogo extends FileHandler{
	private int idJogo;
	private String nomeJogo; 
	private String lancamento; 
	private String desenvolvedor;
	private String versao = "valor indexistente";
	private String genero = "valor indexistente";
	private Comentario comentarios;
	Scanner scanner = new Scanner(System.in);
	String caminhoObjetoJogo;
	
	public Jogo(int id, String nomeJogo, String lancamento, String desenvolvedor)
	{
		this.idJogo = id;
		this.nomeJogo = nomeJogo; 
		this.lancamento = lancamento; 
		this.desenvolvedor = desenvolvedor;
	}
	
	public String getNomeJogo()
	{
		return this.nomeJogo;
	}
	
	public int getIdJogo()
	{
		return this.idJogo;
	}
	
	public List<String> retornaListaAtributosRelevantes()
	{
		String[] atributosRelevantes = new String[] {(Integer.toString(this.idJogo)), this.nomeJogo, this.lancamento, this.desenvolvedor};
		List<String> listaAtributosRelevantes= Arrays.asList(atributosRelevantes);
		return listaAtributosRelevantes;
	}
	
	public void atualizaAtributos(int opcao, String atributoAtualizado)
	{
		switch (opcao)
		{
			case 1:
				nomeJogo = atributoAtualizado;
			case 2:
				lancamento = atributoAtualizado;
			case 3:
				desenvolvedor = atributoAtualizado;
			case 4:
				versao = atributoAtualizado;
			case 5:
				genero = atributoAtualizado;
		}		
		caminhoObjetoJogo = "./etc/" + Integer.toString(idJogo);
		this.salvaObjetoEmArquivo(this, caminhoObjetoJogo);
	}
	
	@Override
	public String toString()
	{
		//refazer para ficar bonito
		return ( Integer.toString(this.idJogo) + ',' + this.nomeJogo + ',' + this.lancamento + ',' + this.desenvolvedor); 
	}
	

}
