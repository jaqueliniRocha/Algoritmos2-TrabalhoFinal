package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByEmail implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return aluno1.getEmail().compareTo(aluno2.getEmail());
	}

}
