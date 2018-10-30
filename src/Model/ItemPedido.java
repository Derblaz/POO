package Model;

public class ItemPedido {
	private int qtd;
	private ItemCardapio item;

	public ItemPedido(int qtd, ItemCardapio item) {
		this.qtd = qtd;
		this.item = item;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public ItemCardapio getItem() {
		return item;
	}

	public void setItem(ItemCardapio item) {
		this.item = item;
	}

}
