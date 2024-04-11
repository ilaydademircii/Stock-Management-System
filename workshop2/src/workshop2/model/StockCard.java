package workshop2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class StockCard {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static StockCard instance;
	private String CurrentCode;

	String stockCode;
	String stockName;
	String stockTypeCode;
	String unit;
	String barcode;
	String kdvTypeCode;
	String explanation;
	String date;

	public StockCard() {
		db = DatabaseConnection.getInstance();
		conn = db.getConnection();
		setCurrentCode("");
	}

	public static StockCard getInstance() {
		if (instance == null) {
			instance = new StockCard();
		}
		return instance;
	}

	public StockCard getFirstCard() {
		String query = "SELECT sc.StockCode, sc.StockName, st.StockTypeCode, sc.Unit, sc.Barcode, kd.KdvTypeCode, sc.Explanation, sc.Date\r\n"
				+ "FROM stockcard sc\r\n" + "INNER JOIN stocktypecard st ON sc.StockTypeId = st.id \r\n"
				+ "INNER JOIN kdvtypecard kd ON sc.KdvTypeId = kd.id where StockCode=(select min(StockCode) FROM stockcard);";
		getCardWithStatement(query);
		return StockCard.getInstance();
	}

	public StockCard getLastCard() {
		String query = "SELECT sc.StockCode, sc.StockName, st.StockTypeCode, sc.Unit, sc.Barcode, kd.KdvTypeCode, sc.Explanation, sc.Date\r\n"
				+ "FROM stockcard sc\r\n" + "INNER JOIN stocktypecard st ON sc.StockTypeId = st.id \r\n"
				+ "INNER JOIN kdvtypecard kd ON sc.KdvTypeId = kd.id where StockCode=(select max(StockCode) FROM stockcard);";
		getCardWithStatement(query);
		return StockCard.getInstance();
	}

	public StockCard getByOrderIncrease() {
		String subQuery = "SELECT MIN(StockCode) FROM stockcard WHERE StockCode > ?";
		getCardWithPreparedStatement(subQuery);
		if (StockCard.getInstance().getStockCode() == null) {
			return getLastCard();
		}
		return StockCard.getInstance();
	}

	public StockCard getByOrderDecrease() {
		String subQuery = "SELECT Max(StockCode) FROM stockcard WHERE StockCode < ?";
		getCardWithPreparedStatement(subQuery);
		if (StockCard.getInstance().getStockCode() == null) {
			return getFirstCard();
		}
		return StockCard.getInstance();
	}

	public void delete() {
		try {
			if (isExists(StockCard.getInstance().getStockCode())) {
				String query = "Delete from stockcard where StockCode =?";

				pstat = conn.prepareStatement(query);
				pstat.setString(1, StockCard.getInstance().getStockCode());

				pstat.executeUpdate();
				pstat.close();

				JOptionPane.showMessageDialog(null, "Stok kartı başarıyla silindi.", "  ",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Stok kartı bulunamadı. Lütfen stok kodunuzu kontrol ediniz.",
						" Hata ", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {

		try {
			if (!StockCard.getInstance().getStockCode().isEmpty()) {
				if (!isExists(StockCard.getInstance().getStockCode())) {

					String query = "insert into stockcard(StockCode,StockName,StockTypeId,Unit,Barcode,KdvTypeId,Explanation) values(?,?,(Select id from stocktypecard where StockTypeCode=?),?,?,(Select id from kdvtypecard where KdvTypeCode=?),?)";
					setCardWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Stok kartı başarıyla eklendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					String query = "UPDATE stockcard SET StockName=?,StockTypeId=(Select id from stocktypecard where StockTypeCode=?),Unit=?,Barcode=?,KdvTypeId=(Select id from kdvtypecard where KdvTypeCode=?),Explanation=? WHERE StockCode=?";
					setCardWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Stok kartı başarıyla güncellendi.", " ",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Stok kodu boş bırakılamaz.", " Hata ", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();

		}
	}

	public boolean isExists(String stockCode) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM stockcard WHERE stockCode=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, stockCode);

			ResultSet rs = pstat.executeQuery();
			rs.next();
			int sonuc = rs.getInt("var_mi");
			pstat.close();
			return sonuc == 1;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	public void setCardWithPrepaeredStatement(String query) {
		try {
			StockCard sc = StockCard.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, sc.getStockCode());
			pstat.setString(2, sc.getStockName());
			pstat.setString(3, sc.getStockTypeCode());
			pstat.setString(4, sc.getUnit());
			pstat.setString(5, sc.getBarcode());
			pstat.setString(6, sc.getKdvTypeCode());
			pstat.setString(7, sc.getExplanation());

			setCurrentCode(sc.getStockCode());

			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCardWithStatement(String query) {
		try {
			StockCard card = StockCard.getInstance();
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {
				card.setStockCode(rs.getString("StockCode"));
				card.setStockName(rs.getString("StockName"));
				card.setStockTypeCode(rs.getString("StockTypeCode"));
				card.setUnit(rs.getString("Unit"));
				card.setBarcode(rs.getString("Barcode"));
				card.setKdvTypeCode(rs.getString("KdvTypeCode"));
				card.setExplanation(rs.getString("Explanation"));
				card.setDate(rs.getString("Date"));
			}
			setCurrentCode(card.getStockCode());
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCardWithPreparedStatement(String subQuery) {
		StockCard card = StockCard.getInstance();
		try {
			pstat = conn.prepareStatement(subQuery);
			pstat.setString(1, getCurrentCode());

			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				setCurrentCode(rs.getString(1));

				String mainQuery = "SELECT sc.StockCode, sc.StockName, st.StockTypeCode, "
						+ "sc.Unit, sc.Barcode, kd.KdvTypeCode, sc.Explanation, sc.Date\r\n"
						+ "FROM stockcard sc\r\n" + "INNER JOIN stocktypecard st ON sc.StockTypeId = st.id \r\n"
						+ "INNER JOIN kdvtypecard kd ON sc.KdvTypeId = kd.id where StockCode=?;";
				pstat = conn.prepareStatement(mainQuery);
				pstat.setString(1, getCurrentCode());
				rs = pstat.executeQuery();

				if (rs.next()) {
					card.setStockCode(rs.getString("StockCode"));
					card.setStockName(rs.getString("StockName"));
					card.setStockTypeCode(rs.getString("StockTypeCode"));
					card.setUnit(rs.getString("Unit"));
					card.setBarcode(rs.getString("Barcode"));
					card.setKdvTypeCode(rs.getString("KdvTypeCode"));
					card.setExplanation(rs.getString("Explanation"));
					card.setDate(rs.getString("Date"));
				}

			}
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public String getStockTypeCode() {
		return stockTypeCode;
	}

	public void setStockTypeCode(String stockTypeCode) {
		this.stockTypeCode = stockTypeCode;
	}

	public String getKdvTypeCode() {
		return kdvTypeCode;
	}

	public void setKdvTypeCode(String kdvTypeCode) {
		this.kdvTypeCode = kdvTypeCode;
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

	public String getCurrentCode() {
		return CurrentCode;
	}

	public void setCurrentCode(String currentCode) {
		CurrentCode = currentCode;
	}
}
