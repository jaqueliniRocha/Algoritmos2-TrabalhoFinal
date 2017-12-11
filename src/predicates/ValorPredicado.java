package predicates;

import interfaces.Predicado;
import model.Aluno;

public class ValorPredicado implements Predicado<Integer> {
	
	private Integer valor;

	public ValorPredicado(Integer valor) {
		this.valor = valor;
	}

	@Override
	public boolean teste(Integer objeto) {
		if(valor.equals(objeto)){
			return true;
		}
		return false;
	}


}
