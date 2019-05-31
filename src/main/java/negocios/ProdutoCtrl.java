package negocios;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import beans.Produto;
import persistencia.ProdutoDAO;
import relatorios.GerarRelatorios;

@ManagedBean
@SessionScoped
public class ProdutoCtrl implements Serializable{
	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private List<Produto> listaProdutos;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getListaProdutos(){
		return listaProdutos;
	}
	
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	private void pesquisar() {
		listaProdutos = ProdutoDAO.listagem("");
	}
	
	
	public List<Produto> getListagem(){
		pesquisar();
		return listaProdutos;
	}
	
	public String actionImprimir() {
		HashMap<String, Object> parametros = new HashMap();
		String relatorio = "rel_produto";
		try {
			GerarRelatorios.imprimeRelatorio(listaProdutos, parametros, relatorio);
		} catch (Exception e) {
			System.out.println("Erro ao gerar o relatório. Erro " +e.getMessage() );
		}
		return null;
	}
	
	public String actionGravar() {
		if (produto.getId() == 0) {
			ProdutoDAO.inserir(produto);
			return actionInserir();
		}
		else {
			ProdutoDAO.alterar(produto);
			return "lista_produto";
		}
	}
	
	public String actionInserir() {
		produto = new Produto();
		return "form_produto";
	}
	
	public String actionExcluir() {
		ProdutoDAO.excluir(produto);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "Excluído com Sucesso!"));
		return "form_produto";
	}
	
	public String actionAlterar(Produto p) {
		produto = p;
		return "form_produto";
	}
}
