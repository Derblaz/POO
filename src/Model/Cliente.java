package Model;

public class Cliente {

	private String nome;
	private int telefone;
	private String endereco;
	private String referencia;
	private boolean ativo;
	private int devoluções;

	public Cliente(String nome, int telefone, String endereco, String referencia) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.referencia = referencia;
		this.ativo = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public int getDevoluções() {
		return devoluções;
	}

	public void setDevoluções() {
		this.devoluções ++;
	}

}
