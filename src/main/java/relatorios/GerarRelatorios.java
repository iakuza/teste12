package relatorios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource; 

public class GerarRelatorios {
	
	public static void imprimeRelatorio(List lista, HashMap<String, Object> parametros, String relatorio) throws IOException, SQLException{
		try {
			byte[] arquivo = new byte[0];

			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.responseComplete();

			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
			String caminho = scontext.getRealPath("/WEB-INF/classes/relatorios/" + relatorio + ".jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, parametros, ds);
			arquivo = JasperExportManager.exportReportToPdf(jasperPrint);

			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setContentLength(arquivo.length);

			ServletOutputStream saida = response.getOutputStream();

			saida.write(arquivo, 0, arquivo.length);
			saida.flush();
			saida.close();
		} catch (Exception ex) {
			System.err.println("O arquivo não foi gerado corretamente!");
			ex.printStackTrace();
		}
		
	}
}
