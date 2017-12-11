package predicates;

import interfaces.Predicado;
import model.Aluno;

public class NamePredicate implements Predicado<Aluno> {
	
	private String nome;

	public NamePredicate(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean teste(Aluno objeto) {
		if(nome.equals(objeto.getNome())){
			return true;
		}
		return false;
	}


}
