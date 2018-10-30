package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	/*
	 * N�o aceita pedidos com quantidade superior ao estoque de bebidas
	 * 
	 * Uma vez que um pedido � feito, ele � considerado pendente at� que seja
	 * passado para um entregador. Quando o entregador retorna com o pagamento,
	 * o pedido � considerado atendido.
	 * 
	 * Apenas pedidos ainda pendentes podem ser alterados ou cancelados pelo
	 * cliente. No �ltimo caso, o pedido � exclu�do do sistema. Caso o
	 * entregador n�o encontre o cliente em seu endere�o e retorne com os
	 * produtos, o pedido deve ser considerado devolvido e n�o dever� ser
	 * exclu�do do sistema.
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
			System.out.println("Erro: Cliente n�o ativo.");
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
			entrega = "N�o identificado"; 
		}else entrega = entregador.getNome();
		
		StringBuilder result = new StringBuilder();
		
		result.append("Pedido");
		result.append("\nCliente: "+cliente.getNome());
		result.append("\nEndere�o: "+cliente.getEndereco());
		result.append("\nEntregador: "+entrega);
		result.append("\nSitua��o: "+this.situacao);
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
		//condi��o para adicionar pedido
		this.itens.add(new ItemPedido(qtd,itemcardapio));
	}
	
	public void concluido(){
		this.situacao="Atendido";
	}
	
	public void devolvido(){
		if(entregador == null){
			System.out.println("Erro: Entregador n�o identificado.");
		}else {
			this.situacao="Devolvido";
			System.out.println("Pedido devolvido com sucesso.");
			this.cliente.setDevolu��es();
			if(this.cliente.getDevolu��es()>=3){
				this.cliente.setAtivo(false);
			}
			
		}
	}

}
