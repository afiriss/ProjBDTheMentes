package Dominio;

public class Membro implements Comparable<Membro> {
	
	private int id;
	private String nome;
	private String nomeGang;
	private String idade;
	private String cpf;
	private Funcao nomeFuncao;
	private Funcao tempo;
	
	
	public Funcao getNomeFuncao() {
		return nomeFuncao;
	}
	public void setNomeFuncao(Funcao nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
	public Funcao getTempo() {
		return tempo;
	}
	public void setTempo(Funcao tempo) {
		this.tempo = tempo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeGang() {
		return nomeGang;
	}
	public void setNomeGang(String nomeGang) {
		this.nomeGang = nomeGang;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return nome + " (" + cpf  + ")";
	}
	
	@Override
	public int compareTo(Membro a) {
		return nome.compareTo(a.getNome());
	}
	

	
}
