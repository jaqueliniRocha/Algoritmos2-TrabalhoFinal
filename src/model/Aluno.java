package model;

public class Aluno {
	
	private String matricula;
	private String nome;
	private String email;
	private int idade;
	private String sexo;
	private String empresa;
	private String cidade;
	
	public String getMatricula(){
		return matricula;
	}
	
	public void setMatricula(String matricula){
		this.matricula = matricula;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public int getIdade(){
		return idade;
	}
	
	public void setIdade(int idade){
		this.idade = idade;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	public String getEmpresa(){
		return empresa;
	}
	
	public void setEmpresa(String empresa){
		this.empresa = empresa;
	}
	
	public String getCidade(){
		return cidade;
	}
	
	public void setCidade(String cidade){
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", sexo="
				+ sexo + ", empresa=" + empresa + ", cidade=" + cidade + "]";
	}
}
