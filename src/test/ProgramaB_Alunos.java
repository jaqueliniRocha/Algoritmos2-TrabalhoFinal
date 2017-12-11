package test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;
import predicates.NamePredicate;

public class ProgramaB_Alunos {
	
	//NAO FIZ

	private static final String name = "Polly Hansen";
	private static final String email = "parksgilliam@fishland.com";
	private static final int idade = 32;
	private static final String cidade = "Umapine";
	
	public static void main(String[] args) {
		FileReader arquivo = null;
		try {
			arquivo = new FileReader("data/alunos.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo);
		
		Aluno alunoParaBusca = new Aluno();
		
		System.out.println(lista.search(alunoParaBusca, new SearchByName()));
		
		lista.removeIf(new NamePredicate(name));
		
		if (lista.search(alunoParaBusca, new SearchByName()) != null)
			System.out.println(name + " nao deveria estar na lista.");

		System.out.println(lista.search(alunoParaBusca, new SearchByEmail()));
		
		System.out.println(lista.search(alunoParaBusca, new SearchByAgeAndCity()));
	}

}
