package beans;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


	@Entity
	@Table (name="pedido")
	public class Pedido {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ped_id")
		private int id;
		
		@Column(name = "ped_dataEmissao", nullable = true)
		private Date dataEmissao;
		
		@Column(name = "ped_status", length = 20, nullable = true)
		private String status;
		
		@Column(name = "ped_total_produto", nullable = true)
		private float totalProduto;
		
		@Column(name = "ped_total_servico", nullable = true)
		private float totalServico;
		
		@Column(name = "ped_total_geral", nullable = true)
		private float totalGeral;
		
		@Column(name = "ped_desconto", nullable = true)
		private float desconto;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getDataEmissao() {
			return dataEmissao;
		}

		public void setDataEmissao(Date dataEmissao) {
			this.dataEmissao = dataEmissao;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public float getTotalProduto() {
			return totalProduto;
		}

		public void setTotalProduto(float totalProduto) {
			this.totalProduto = totalProduto;
		}

		public float getTotalServico() {
			return totalServico;
		}

		public void setTotalServico(float totalServico) {
			this.totalServico = totalServico;
		}

		public float getTotalGeral() {
			return totalGeral;
		}

		public void setTotalGeral(float totalGeral) {
			this.totalGeral = totalGeral;
		}

		public float getDesconto() {
			return desconto;
		}

		public void setDesconto(float desconto) {
			this.desconto = desconto;
		}
		
		@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private List<ItensPedido> itenspedidos = new ArrayList<ItensPedido>();
		
		public List<ItensPedido> getItensPedidos(){
			return itenspedidos;
		}
		public void setItensPedidos(List<ItensPedido> itenspedidos) {
			this.itenspedidos=itenspedidos;
		
		}
}		
