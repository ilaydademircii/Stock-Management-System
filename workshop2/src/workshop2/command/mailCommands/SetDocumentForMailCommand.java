package workshop2.command.mailCommands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import workshop2.model.ListStockCard;

public class SetDocumentForMailCommand {

	public SetDocumentForMailCommand() {
		super();
	}

	public void execute() {
		try {
			String reportPath = "C:\\Users\\zehra\\guruyazilim\\workshop2\\StockCardList.jrxml";
			JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

			Collection<Map<String, ?>> dataVector = new Vector<>();

			for (ListStockCard s : ListStockCard.getInstance().stockCardList()) {
				Map<String, Object> row = new HashMap<>();
				row.put("StockCode", s.getStockCode());
				row.put("StockName", s.getStockName());
				row.put("Unit", s.getUnit());
				row.put("Barcode", s.getBarcode());
				row.put("StockTypeCode", s.getStockTypeCode());
				row.put("StockTypeName", s.getStockTypeName());
				row.put("StockTypeExplanation", s.getStockTypeExplanation());
				row.put("KdvTypeCode", s.getKdvTypeCode());
				row.put("KdvTypeName", s.getKdvTypeName());
				row.put("KdvTypeRate", s.getKdvTypeRate().toString());
				row.put("Explanation", s.getExplanation());
				row.put("Date", s.getDate());
				dataVector.add(row);
			}
			JRMapCollectionDataSource jrDataSource = new JRMapCollectionDataSource(dataVector);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);

			String pdfFilePath = "C:\\Users\\zehra\\guruyazilim\\workshop2\\StockCardList.pdf";
			JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFilePath);

		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

}