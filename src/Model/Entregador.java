package Model;
import java.util.ArrayList;
import java.util.List;


public class Entregador {
	private String nome;
	public String placaDoVeiculo;
	private List<Pedido> pedido = new ArrayList<Pedido>();

	public Entregador(String nome, String placaDoVeiculo) {
		this.nome = nome;
		this.placaDoVeiculo = placaDoVeiculo;	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlacaDoVeiculo() {
		return placaDoVeiculo;
	}

	public void setPlacaDoVeiculo(String placaDoVeiculo) {
		this.placaDoVeiculo = placaDoVeiculo;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido.add(pedido);
	}
	
	public void entregar(Pedido pedido){
		this.pedido.add(pedido);
		pedido.setSituacao("Em andamento");
		pedido.setEntregador(this);
		
	}

}
