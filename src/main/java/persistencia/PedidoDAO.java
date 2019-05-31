package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Pedido;


public class PedidoDAO implements Serializable{
private static final long serialVersionUID = 1L;
	
	public static void inserir(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pedido);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pedido);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pedido);
		t.commit();
		sessao.close();
	}
	
	public static List<Pedido> listagem(String filtro){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Pedido order by ped_id");
		}
		else {
			consulta = sessao.createQuery("from Pedido where ped_id like :parametro order by ped_id");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List<Pedido> lista = consulta.list();
		sessao.close();
		return lista;
	}
}
