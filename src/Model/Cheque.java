package Model;

public class Cheque {
	private int numero;
	private int conta;
	private int agencia;
	private String banco;

	public Cheque(int numero, int conta, int agencia, String banco) {
		super();
		this.numero = numero;
		this.conta = conta;
		this.agencia = agencia;
		this.banco = banco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
