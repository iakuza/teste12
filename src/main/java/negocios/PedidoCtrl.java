package negocios;

import java.io.Serializable;
import java.util.List;

import beans.Pedido;
import persistencia.PedidoDAO;

public class PedidoCtrl implements Serializable {
	private static final long serialVersionUID = 1L;
	private Pedido pedido;
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public List<Pedido> getListagem(){
		return PedidoDAO.listagem("");
	}
	
	public String actionGravar() {
		if (pedido.getId() == 0) {
			PedidoDAO.inserir(pedido);
			return actionInserir();
		}
		else {
			PedidoDAO.alterar(pedido);
			return "lista_pedido";
		}
	}
	
	public String actionInserir() {
		pedido = new Pedido();
		return "form_pedido";
	}
	
	public String actionExcluir(Pedido p) {
		PedidoDAO.excluir(p);
		return "lista_pedido";
	}
	
	public String actionAlterar(Pedido p) {
		pedido = p;
		return "form_pedido";
	}
}
