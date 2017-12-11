package test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;

public class ProgramaC_Alunos {

	//define os dados que serao utilizados nas buscas
	private static final String name = "Polly Hansen";
	private static final String email = "parksgilliam@fishland.com";
	private static final int idade = 32;
	private static final String cidade = "Umapine";
	
	public static void main(String[] args) {
		//cria um objeto FileReader com o arquivo CSV que deve ser importado
		FileReader arquivo = null;
		try {
			arquivo = new FileReader("data/alunos.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		//carrega a lista de alunos em uma lista encadeada
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo);
		
		//cria objeto Aluno com os campos que serao utilizados na busca
		Aluno alunoParaBusca = new Aluno();
		alunoParaBusca.setNome(name);
		alunoParaBusca.setEmail(email);
		alunoParaBusca.setIdade(idade);
		alunoParaBusca.setCidade(cidade);
		
		//imprime o retorno do metodo de busca da lista encadada, buscando pelo nome
		System.out.println(lista.search(alunoParaBusca, new SearchByName()));
		
		//imprime o retorno do metodo de busca da lista encadada, buscando pelo email
		System.out.println(lista.search(alunoParaBusca, new SearchByEmail()));
		
		//imprime o retorno do metodo de busca da lista encadada, buscando pela idade e cidade
		System.out.println(lista.search(alunoParaBusca, new SearchByAgeAndCity()));
	}

}
