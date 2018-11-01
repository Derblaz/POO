package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Pedido {

	private String situacao;
	private Date data;
	private Cliente cliente;
	private Entregador entregador;
//	private Cheque cheque;
	private List<ItemPedido> itens = new ArrayList<>();
	
//	private SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Pedido( Cliente cliente) {
		if(cliente.isAtivo()){
			this.situacao = "Pendente";		
			this.data = new Date();
			this.cliente = cliente;

		} else{
			System.out.println("Erro: Cliente não ativo.");
		}
				
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getData() {
		return data;
	}

	@Override
	public String toString() {
		String entrega = "";
		if(this.entregador == null){
			entrega = "Não identificado"; 
		}else entrega = entregador.getNome();
		
		StringBuilder result = new StringBuilder();
		
		result.append("Pedido");
		result.append("\nCliente: "+cliente.getNome());
		result.append("\nEndereço: "+cliente.getEndereco());
		result.append("\nEntregador: "+entrega);
		result.append("\nSituação: "+this.situacao);
		int i=0;
		double sum=0;
		for (ItemPedido itemPedido : itens) {
			i++;
			result.append("\nItem "+i+" - ");
			result.append(itemPedido.getQtd());
			result.append(" "+itemPedido.getItem().getNome());
			sum +=itemPedido.getItem().getValor()*itemPedido.getQtd();
		}
			
		result.append("\nTotal = "+sum);
		return result.toString();		
	}
	
	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public void addItem(int qtd, ItemCardapio itemcardapio){
		if(itemcardapio instanceof Bebida ){
			if(((Bebida) itemcardapio).baixar(qtd))
				this.itens.add(new ItemPedido(qtd,itemcardapio));
		}else
		this.itens.add(new ItemPedido(qtd,itemcardapio));
	}
	
	public void concluido(){
		this.situacao="Atendido";
	}
	
	public void devolvido(){
		if(entregador == null){
			System.out.println("Erro: Entregador não identificado.");
		}else {
			this.situacao="Devolvido";
			System.out.println("Pedido devolvido com sucesso.");
			this.cliente.setDevoluções();
			if(this.cliente.getDevoluções()>=3){
				this.cliente.setAtivo(false);
			}
			
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
