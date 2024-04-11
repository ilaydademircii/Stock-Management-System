package workshop2.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListStockCard {

	DatabaseConnection db;
	private Connection conn = null;
	private Statement stat = null;

	private static ListStockCard instance;
	private List<ListStockCard> list;

	// stockCard
	String stockCode;
	String stockName;
	String stockTypeName;
	String unit;
	String barcode;
	String kdvTypeName;
	String explanation;
	String date;

	// stockTypeCard
	String stockTypeCode;
//	String stockTypeName;
	String stockTypeExplanation;

	// kdvTypeCard
	String kdvTypeCode;
//	String kdvTypeName;
	Double kdvTypeRate;

	public ListStockCard() {
		db = DatabaseConnection.getInstance();
		conn = db.getConnection();
	}

	public static ListStockCard getInstance() {
		if (instance == null) {
			instance = new ListStockCard();
		}
		return instance;
	}

	public List<ListStockCard> stockCardList() {
		list = new ArrayList<ListStockCard>();
		try {

			String query = "SELECT stockcard.StockCode, stockcard.StockName, stockcard.Unit, stockcard.Barcode, stockcard.Explanation,"
					+ " stockcard.Date, stocktypecard.StockTypeCode,stocktypecard.StockTypeName, stocktypecard.StockTypeExplanation, "
					+ "kdvtypecard.KdvTypeCode, kdvtypecard.KdvTypeName, kdvtypeRate\r\n"
					+ "from stockcard\r\n" + "INNER JOIN stocktypecard ON stockcard.StockTypeId= stocktypecard.id\r\n"
					+ "INNER JOIN kdvtypecard ON stockcard.KdvTypeId= kdvtypecard.id\r\n"
					+ "ORDER BY stockcard.StockCode;";

			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			while (rs.next()) {
				ListStockCard lsc = new ListStockCard();
				lsc.setStockCode(rs.getString("stockcard.StockCode"));
				lsc.setStockName(rs.getString("stockcard.StockName"));
				lsc.setUnit(rs.getString("stockcard.Unit"));
				lsc.setBarcode(rs.getString("stockcard.Barcode"));
				lsc.setExplanation(rs.getString("stockcard.Explanation"));
				lsc.setDate(rs.getString("stockcard.Date"));
				lsc.setStockTypeCode(rs.getString("stocktypecard.StockTypeCode"));
				lsc.setStockTypeName(rs.getString("stocktypecard.StockTypeName"));
				lsc.setStockTypeExplanation(rs.getString("stocktypecard.StockTypeExplanation"));
				lsc.setKdvTypeCode(rs.getString("kdvtypecard.KdvTypeCode"));
				lsc.setKdvTypeName(rs.getString("kdvtypecard.KdvTypeName"));
				lsc.setKdvTypeRate(rs.getDouble("kdvtypecard.KdvTypeRate"));
				list.add(lsc);
			}

		} catch (Exception e) {
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
		}

		return list;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockTypeName() {
		return stockTypeName;
	}

	public void setStockTypeName(String stockTypeName) {
		this.stockTypeName = stockTypeName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getKdvTypeName() {
		return kdvTypeName;
	}

	public void setKdvTypeName(String kdvTypeName) {
		this.kdvTypeName = kdvTypeName;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStockTypeCode() {
		return stockTypeCode;
	}

	public void setStockTypeCode(String stockTypeCode) {
		this.stockTypeCode = stockTypeCode;
	}

	public String getStockTypeExplanation() {
		return stockTypeExplanation;
	}

	public void setStockTypeExplanation(String stockTypeExplanation) {
		this.stockTypeExplanation = stockTypeExplanation;
	}

	public String getKdvTypeCode() {
		return kdvTypeCode;
	}

	public void setKdvTypeCode(String kdvTypeCode) {
		this.kdvTypeCode = kdvTypeCode;
	}

	public Double getKdvTypeRate() {
		return kdvTypeRate;
	}

	public void setKdvTypeRate(Double kdvTypeRate) {
		this.kdvTypeRate = kdvTypeRate;
	}

}
