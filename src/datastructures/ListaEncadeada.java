package datastructures;

import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;

import comparators.OrdenaPorEmail;
import model.Aluno;
import model.Celula;
import predicates.NamePredicate;

/**
 * 
 * @author jaquelini.rocha
 *
 * @param <T>
 */
public class ListaEncadeada<T> {

	private Celula<T> primeira;
	private Celula<T> ultima;
	
	/**
	 * Adiciona um dado no final da lista
	 * 
	 * @param dado
	 */
	public void append(T dado) {
		//aqui crio um celula e coloco o 'dado' como elemento dela
		Celula<T> celula = new Celula<T>();
		celula.setElemento(dado);
		
		//verifica se existe uma primeira, se for nula, entao a celula criada se tornara a primeira
		if(primeira == null){
			primeira = celula;
			
		} else {
			//caso tenha alguma celula na lista, entao a nova eh colocada no final e se torna a nova 'ultima'
			celula.setAnterior(ultima);
			ultima.setProxima(celula);
		}
		
		//a celula adicionada vira a nova 'ultima'
		ultima = celula;
	}

	/**
	 * Metodo que adiciona no comeco da lista
	 */
	public void addFirst(T dado) {
		//aqui crio um celula e coloco o 'dado' como elemento dela
		Celula<T> celula = new Celula<T>();
		celula.setElemento(dado);
		
		//defino o proximo da celula criada como sendo a primeira, e a anterior da primeira se torna a celula criada
		//ou seja, a nova celula vai para o comeco da lista
		celula.setProxima(primeira);
		primeira.setAnterior(celula);
		
		//a nova celula se torna a primeira
		this.primeira = celula;
	}

	/**
	 * Faz a busca de um elemento de acordo com o comparator do parametro
	 * 
	 * @param key objeto a ser comparado
	 * @param cmp comparator que contem os criterios de comparacao, por exemplo: nome, email, cidade e idade, etc.
	 * @return o valor encontrado ou null
	 */
	public T search(T key, Comparator<T> cmp) {
		Celula<T> celulaAtual = primeira;
		
		//do...while que percorre a lista tentando comparar cada elemento, do primeiro ao ultimo, se é igual
		//ao key passado por parametros, onde os criterios de comparacao estao na variavel 'cmp' que eh o comparator
		do {
			if(cmp.compare(key, celulaAtual.getElemento()) == 0){
				//se o resultado da comparacao for zero, significa que os elementos atendem aos criterios de comparacao
				return celulaAtual.getElemento();
			}
			
			//pega a proxima celula da lista para comparar
			celulaAtual = celulaAtual.getProxima();
			
		} while (celulaAtual != null); //enquanto existir uma proxima celula, continua tentando comparar
		
		return null;
	}

	/**
	 * Imprime os elementos da lista
	 */
	public void printObjects() {
		Celula<T> celulaAtual = primeira;
		do {
			System.out.println(celulaAtual.getElemento());
			
			celulaAtual = celulaAtual.getProxima();
			
		} while (celulaAtual != null); //enquanto houver proxima celula, vai imprimindo
	}

	/**
	 * Carrega os Alunos de um arquivo CSV, que vem no parametro como um objeto FileReader
	 * 
	 * @param arquivo contem o arquivo que sera lido
	 * @return retorna uma lista encadeada com os alunos lidos
	 */
	public static ListaEncadeada<model.Aluno> loadFromFile(FileReader arquivo){
		//cria uma nova lista encadeada de Aluno vazia
		ListaEncadeada<Aluno> alunos = new ListaEncadeada<>();
		
		//cria o scanner que sera utilizado pra ler os dados
		Scanner sc = new Scanner(arquivo);
		
		//define quais caracteres vao ser a quebra ao ler as informacoes, no caso sera a virgula (que define cada coluna) e 
		//o caractere de quebra de linha, para pegar a proxima linha do csv e continuar lendo
		sc.useDelimiter("[,\n]");

		//enquanto tiver algum conteudo a ser lido do arquivo...
		while (sc.hasNext()) {
			//cria um Aluno e coloca as informacoes lidas nele
			Aluno aluno = new Aluno();
			aluno.setMatricula(sc.next());
			aluno.setNome(sc.next());
			aluno.setEmail(sc.next());
			aluno.setIdade(sc.nextInt());
			aluno.setSexo(sc.next());
			aluno.setEmpresa(sc.next());
			aluno.setCidade(sc.next());
			
			//ao final adiciona o Aluno na lista encadeada
			alunos.append(aluno);
		}

		sc.close();
		
		//retorna a lista encadeada com todos os alunos lidos
		return alunos;
	}

	public static ListaEncadeada<Aluno> loadFromFile(FileReader arquivo, OrdenaPorEmail ordenaPorEmail) {
		// TODO nao implementado
		return null;
	}

	public void removeIf(NamePredicate namePredicate) {
		// TODO nao implementado
	}
}
