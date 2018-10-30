package View;

import java.util.Date;

import Model.Bebida;
import Model.Cheque;
import Model.Cliente;
import Model.Entregador;
import Model.Lanche;
import Model.Pedido;
import Model.Refeicao;
import Model.Sobremesa;


public class Main {
	
	public static void main(String[] args){
	
	/*
	 * Carregamento de dados;
	 * Informações básicas para execução dos procedimentos do sistema.
	 */
		
	Cliente cl_1 = new Cliente("Bruno Max", 85999991, "Soriano Albuquerque, 83", "Lar Amigos de Jesus");
	Cliente cl_2 = new Cliente("João", 85999992, "Rua 1, 11", "");
	Cliente cl_3 = new Cliente("Pedro", 85999993, "Rua 2, 12", "");
	Cliente cl_4 = new Cliente("Camila", 85999994, "Rua 3, 13", "");
	Cliente cl_5 = new Cliente("Joana", 85999995, "Rua 4, 14", "");
	Cliente cl_6 = new Cliente("Edilson", 85999996, "Rua 5, 15", "");
	Cliente cl_7 = new Cliente("Fulano", 85999997, "Rua 6, 16", "");
	Cliente cl_8 = new Cliente("Sicrano", 85999998, "Rua 7, 17", "");
	Cliente cl_9 = new Cliente("Arnaldo", 85999999, "Rua 8, 18", "");
	Cliente cl_10 = new Cliente("Maria", 85999910, "Rua 9, 19", "");

	Entregador etrg_1 = new Entregador("Joaquim", "NPQ2345");
	Entregador etrg_2 = new Entregador("Artur", "NPQ3456");
	Entregador etrg_3 = new Entregador("Ronaldo", "NPQ4567");
	Entregador etrg_4 = new Entregador("Zezim", "NPQ5678");
	Entregador etrg_5 = new Entregador("Amanda", "NPQ6789");
	
	Lanche lan_1 = new Lanche("Batata Frita", 0);
	Lanche lan_2 = new Lanche("Fruta", 0);
	Lanche lan_3 = new Lanche("Hot Dog", 0);
	Lanche lan_4 = new Lanche("Pão de Queijo", 0);
	
	Refeicao Ref_1 = new Refeicao("Lasanha", 0);
	Refeicao Ref_2 = new Refeicao("Feijão Verde", 0);
	Refeicao Ref_3 = new Refeicao("Prato Completo", 0);
	Refeicao Ref_4 = new Refeicao("Peixe", 0);
	
	Bebida beb_1 = new Bebida("CocaCola", 7.5d, 50);
	Bebida beb_2 = new Bebida("Fanta", 0, 0);
	Bebida beb_3 = new Bebida("Sprite", 0, 0);
	Bebida beb_4 = new Bebida("Cajuina", 0, 0);
	
	Sobremesa sbr_1 = new Sobremesa("Pudim", 0);
	Sobremesa sbr_2 = new Sobremesa("Doce", 0);
	Sobremesa sbr_3 = new Sobremesa("Torta", 0);
	Sobremesa sbr_4 = new Sobremesa("Brigadeiro", 0);
	
	Cheque Chq_1 = new Cheque(0002, 2345, 88787, "Banco novo");
	
	/*
	 * Atendimento de Pedidos
	 * Lançamento das informações nos pedidos 
	 */
	
		
	Pedido p = new Pedido(cl_1);
	Pedido p2 = new Pedido(cl_1);

	
	p.addItem(2, beb_1);
	p.addItem(5, beb_1);
	p.addItem(3, beb_3);
	
	etrg_1.entregar(p);
	etrg_1.entregar(p2);
	//p.concluido();
	p.devolvido();
	p.devolvido();
	p2.devolvido();
	

	
	System.out.println(p);
	
	Pedido p3 = new Pedido(cl_1);
	
	/*
	 * Impressão de informações
	 * 
	 */

	

	}
}
