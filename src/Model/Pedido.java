package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	/*
	 * Não aceita pedidos com quantidade superior ao estoque de bebidas
	 * 
	 * Uma vez que um pedido é feito, ele é considerado pendente até que seja
	 * passado para um entregador. Quando o entregador retorna com o pagamento,
	 * o pedido é considerado atendido.
	 * 
	 * Apenas pedidos ainda pendentes podem ser alterados ou cancelados pelo
	 * cliente. No último caso, o pedido é excluído do sistema. Caso o
	 * entregador não encontre o cliente em seu endereço e retorne com os
	 * produtos, o pedido deve ser considerado devolvido e não deverá ser
	 * excluído do sistema.
	 */
	private String situacao;
	private Date data;
	private Cliente cliente;
	private Entregador entregador;
	private Cheque cheque;
	private List<ItemPedido> itens = new ArrayList<>();

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
			((Bebida) itemcardapio).baixar(qtd);
		}
		//condição para adicionar pedido
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

}
