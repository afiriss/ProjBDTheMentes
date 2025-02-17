package Dominio;

public class Funcao {
	
	private int idFuncao;	
	private String nomeFuncao;
	private String tempo;
	private Membro membro;
	
	public int getIdFuncao() {
		return idFuncao;
	}
	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
	}
	public String getNomeFuncao() {
		return nomeFuncao;
	}
	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public Membro getMembro() {
		return membro;
	}
	public void setMembro(Membro membro) {
		this.membro = membro;
	}

}
