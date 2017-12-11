package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByName implements Comparator<Aluno> {
	
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return aluno1.getNome().compareTo(aluno2.getNome());
	}

}
