package workshop2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class StockTypeCard {

	DatabaseConnection db;;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static StockTypeCard instance;
	private String CurrentCode;

	String code;
	String name;
	String explanation;

	public StockTypeCard() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
		setCurrentCode("");
	}

	public static StockTypeCard getInstance() {
		if (instance == null) {
			instance = new StockTypeCard();
		}
		return instance;
	}

	public StockTypeCard getFirstCard() {
		String query = "Select * from stocktypecard where StockTypeCode=(select min(StockTypeCode) FROM stocktypecard)";
		getCardWithStatement(query);
		return StockTypeCard.getInstance();
	}

	public StockTypeCard getLastCard() {
		String query = "Select * from stocktypecard where StockTypeCode=(select max(StockTypeCode) FROM stocktypecard)";
		getCardWithStatement(query);
		return StockTypeCard.getInstance();
	}

	public StockTypeCard getByOrderIncrease() {

		String subQuery = "SELECT MIN(StockTypeCode) FROM stocktypecard WHERE StockTypeCode > ?";
		getCardWithPreparedStatement(subQuery);
		if (StockTypeCard.getInstance().getCode() == null) {
			return getLastCard();
		}
		return StockTypeCard.getInstance();
	}

	public StockTypeCard getByOrderDecrease() {
		String subQuery = "SELECT MAX(StockTypeCode) FROM stocktypecard WHERE StockTypeCode < ?";
		getCardWithPreparedStatement(subQuery);
		if (StockTypeCard.getInstance().getCode() == null) {
			return getFirstCard();
		}
		return StockTypeCard.getInstance();
	}

	public List<String> getAllStockTypeCodes() {
		List<String> list = new ArrayList<>();

		try {
			String query = "SELECT StockTypeCode FROM stocktypecard";
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString("StockTypeCode"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delete() {
		try {
			if (isExists(StockTypeCard.getInstance().getCode())) {
				String query = "Delete from stocktypecard where StockTypeCode =?";
				
				pstat = conn.prepareStatement(query);
				pstat.setString(1, StockTypeCard.getInstance().getCode());
				
				pstat.executeUpdate();
				pstat.close();

				JOptionPane.showMessageDialog(null, "Stok tipi kartı başarıyla silindi.", "  ",
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"Stok tipi kartı bulunamadı. Lütfen stok tipi kodunuzu kontrol ediniz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Stok tipi kartının bağlı olduğu stok kartı bulunmaktadır. Silinemez.",
					" Hata ", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			if (!StockTypeCard.getInstance().getCode().isEmpty()) {
				if (!isExists(StockTypeCard.getInstance().getCode())) {

					String query = "insert into stocktypecard(StockTypeCode,StockTypeName,StockTypeExplanation)values(?,?,?)";
					setCardWithPreparedStatement(query);

					JOptionPane.showMessageDialog(null, "Stok tipi kartı başarıyla eklendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					String query = "UPDATE stocktypecard SET  StockTypeName=?,StockTypeExplanation=? WHERE StockTypeCode=?";
					setCardWithPreparedStatement(query);

					JOptionPane.showMessageDialog(null, "Stok tipi kartı başarıyla güncellendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Stok tipi kodu boş bırakılamaz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();

		}
	}

	public boolean isExists(String stockTypeCode) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM stocktypecard WHERE StockTypeCode=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, stockTypeCode);

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

	public void getCardWithStatement(String query) {
		try {
			StockTypeCard card = StockTypeCard.getInstance();
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {
				card.setCode(rs.getString("StockTypeCode"));
				card.setName(rs.getString("StockTypeName"));
				card.setExplanation(rs.getString("StockTypeExplanation"));
			}
			setCurrentCode(card.getCode());
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCardWithPreparedStatement(String query) {
		try {
			StockTypeCard sc = StockTypeCard.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, sc.getCode());
			pstat.setString(2, sc.getName());
			pstat.setString(3, sc.getExplanation());

			setCurrentCode(sc.getCode());

			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCardWithPreparedStatement(String subQuery) {
		StockTypeCard card = StockTypeCard.getInstance();

		try {

			pstat = conn.prepareStatement(subQuery);

			pstat.setString(1, getCurrentCode());
			pstat.executeQuery();

			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				setCurrentCode(rs.getString(1));

				String mainQuery = "SELECT * FROM stocktypecard WHERE StockTypeCode = ?";
				pstat = conn.prepareStatement(mainQuery);
				pstat.setString(1, getCurrentCode());
				rs = pstat.executeQuery();

				if (rs.next()) {
					card.setCode(rs.getString("StockTypeCode"));
					card.setName(rs.getString("StockTypeName"));
					card.setExplanation(rs.getString("StockTypeExplanation"));
				}

			}
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getCurrentCode() {
		return CurrentCode;
	}

	public void setCurrentCode(String currentCode) {
		CurrentCode = currentCode;
	}

}
