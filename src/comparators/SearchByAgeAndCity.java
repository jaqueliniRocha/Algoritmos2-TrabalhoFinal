package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByAgeAndCity implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		if(aluno1.getCidade().equals(aluno2.getCidade()) && aluno1.getIdade() == aluno2.getIdade()) {
			return 0;
		}
		return 1;
	}
	

}
