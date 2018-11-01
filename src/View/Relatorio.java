package View;

import java.util.Date;
import java.util.List;

import Model.Bebida;
import Model.Entregador;
import Model.ItemPedido;
import Model.Lanche;
import Model.Pedido;
import Model.Refeicao;
import Model.Sobremesa;

public class Relatorio {	
	 
	public Relatorio() {

	}
	
//	public void imprimirPedidos(){
//		
//		BancoDeDados.pedidos.forEach(pedido -> {
//			System.out.println("Pedido:" + pedido.getSituacao());
//		});
//		
//	}

	public void PedidoDoDia(List<Entregador> entregadores, Date data){
		StringBuilder result = new StringBuilder();

		for (Entregador entregador : entregadores) {
			int i = 0;
			for(Pedido pedido: entregador.getPedido()){	
				i++;
				//if(pedido.getData() == data){
					result.append("\nPedido_"+i+": ");
					result.append(pedido.getCliente().getNome()+" ");
					result.append(pedido.getData()+" ");
					double total = 0;
					for(ItemPedido item: pedido.getItens()){
						total+=item.getQtd()*item.getItem().getValor();
					}
					result.append(total+" ");
				//}
				
			}
		}
		System.out.println(result.toString());
	}
	
	public void Entregadores(List<Entregador> entregadores){
		StringBuilder result = new StringBuilder();

		for (Entregador entregador : entregadores) {
			int qtd = 0;
			double total = 0;
			result.append("\nEntregador: "+entregador.getNome()+" - ");
			for(Pedido pedido: entregador.getPedido()){	
				qtd++;					
					for(ItemPedido item: pedido.getItens()){
						total+=item.getQtd()*item.getItem().getValor();
					}
													
			}
			result.append("entregas: "+qtd+" - ");
			result.append("valor total:"+total+" - ");
			result.append("comisão: "+total*0.05d);
		}
		System.out.println(result.toString());
	}
	
	public void ItensVendidos(List<Entregador> entregadores){
		int pico_bebida = 0;
		int pico_lanche = 0;
		int pico_refeicao = 0;
		int pico_sobremesa = 0;
		
		int bebida = 0;
		int lanche = 0;
		int refeicao = 0;
		int sobremesa = 0;
		
		StringBuilder result = new StringBuilder();
		result.append("\n- Relatorio de itens vendidos -");
		for (Entregador entregador : entregadores) {
			
			
			for(Pedido pedido: entregador.getPedido()){	
					int picoB = 0;	
					int picoL = 0;
					int picoR = 0;
					int picoS = 0;
					for(ItemPedido item: pedido.getItens()){
						if(item.getItem() instanceof Bebida){
							bebida+=item.getQtd();
							picoB+=item.getQtd();
						}
						if(item.getItem() instanceof Lanche){
							lanche+=item.getQtd();
							picoL+=item.getQtd();
						}
						if(item.getItem() instanceof Refeicao){
							refeicao+=item.getQtd();
							picoR+=item.getQtd();
						}
						if(item.getItem() instanceof Sobremesa){
							sobremesa+=item.getQtd();
							picoS+=item.getQtd();
						}
					}
					if(picoB>5)
						pico_bebida++;
					if(picoL>5)
						pico_lanche++;
					if(picoR>5)
						pico_refeicao++;
					if(picoS>5)
						pico_sobremesa++;
													
			}
			
		}
		result.append("\nBebidas: "+bebida+" unidades com "+pico_bebida+" picos de procura");
		result.append("\nLanches:"+lanche+" unidades com "+pico_lanche+" picos de procura");
		result.append("\nRefeicao:"+refeicao+" unidades com "+pico_refeicao+" picos de procura");
		result.append("\nSobremesa: "+sobremesa+" unidades com "+pico_sobremesa+" picos de procura");
		
		System.out.println(result.toString());
	}
}
