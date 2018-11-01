package Model;

public class Bebida extends ItemCardapio {
	private int qtdEstoque;

	public Bebida(String nome, double valor, int qtdEstoque) {
		super(nome, valor);
		if (qtdEstoque>0){
			this.qtdEstoque = qtdEstoque;
		}else
			System.out.println("Quantidade menor ou iqual a 0(zero).");		
	}	

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public boolean baixar(int qtd){
		if(qtd<this.qtdEstoque){
			this.qtdEstoque -= qtd;			
			return true;
		}
		else{
			System.out.println("Quantidade em estoque insuficiente"
					+"\nEstoque atual: "+this.qtdEstoque);
			return false;
		}	
	}
@Override
	public String toString() {
		return "Quantidade em estoque: "+ qtdEstoque;
	}	

	
}
