package beans;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


	
	@Entity
	@Table (name="itenspedido")
	public class ItensPedido {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ipe_id")
		private int id;
		
		@Column(name = "ipe_qtde", nullable = true)
		private float quantidade;
		
		@Column(name = "ipe_valorUnit", nullable = true)
		private float valorUnitario;
		
		@Column(name = "ipe_subtotal", nullable = true)
		private float itensSubTotal;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public float getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(float quantidade) {
			this.quantidade = quantidade;
		}

		public float getValorUnitario() {
			return valorUnitario;
		}

		public void setValorUnitario(float valorUnitario) {
			this.valorUnitario = valorUnitario;
		}

		public float getItensSubTotal() {
			return itensSubTotal;
		}

		public void setItensSubTotal(float itensSubTotal) {
			this.itensSubTotal = itensSubTotal;
		}
		
		@OneToMany(mappedBy="itenspedido", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private List<Produto> produtos = new ArrayList<Produto>();
		
		public List<Produto> getProdutos(){
			return produtos;
		}
		public void setProdutos(List<Produto> produtos) {
			this.produtos=produtos;
		}
		
		@OneToMany(mappedBy="itenspedido", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private List<Servico> servicos = new ArrayList<Servico>();
		
		public List<Servico> getServicos(){
			return servicos;
		}
		public void setServicos(List<Servico> servicos) {
			this.servicos=servicos;
		}
		
		
		
	}
