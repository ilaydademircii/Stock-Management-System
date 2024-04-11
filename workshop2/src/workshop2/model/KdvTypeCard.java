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

public class KdvTypeCard {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static KdvTypeCard instance;
	private String CurrentCode;

	String code;
	String name;
	Double rate = 0.0;

	public KdvTypeCard() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
		setCurrentCode("");
	}

	public static KdvTypeCard getInstance() {
		if (instance == null) {
			instance = new KdvTypeCard();
		}
		return instance;
	}

	public KdvTypeCard getFirstCard() {
		String query = "SELECT * FROM kdvtypecard WHERE KdvTypeCode=(SELECT MIN(KdvTypeCode) FROM kdvtypecard)";
		getCardWithStatement(query);
		return KdvTypeCard.getInstance();
	}

	public KdvTypeCard getLastCard() {
		String query = "SELECT * FROM kdvtypecard WHERE KdvTypeCode=(SELECT MAX(KdvTypeCode) FROM kdvtypecard)";
		getCardWithStatement(query);
		return KdvTypeCard.getInstance();
	}

	public KdvTypeCard getByOrderIncrease() {
		String subQuery = "SELECT MIN(KdvTypeCode) FROM kdvtypecard WHERE KdvTypeCode > ?";
		getCardWithPreparedStatement(subQuery);
		if (KdvTypeCard.getInstance().getCode() == null) {
			return getLastCard();
		}

		return KdvTypeCard.getInstance();
	}

	public KdvTypeCard getByOrderDecrease() {
		String subQuery = "SELECT MAX(KdvTypeCode) FROM kdvtypecard WHERE KdvTypeCode < ?";
		getCardWithPreparedStatement(subQuery);
		if (KdvTypeCard.getInstance().getCode() == null) {
			return getFirstCard();
		}

		return KdvTypeCard.getInstance();
	}

	public List<String> getAllKdvTypeCodes() {
		List<String> list = new ArrayList<>();

		try {
			String query = "SELECT KdvTypeCode FROM kdvtypecard";
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString("KdvTypeCode"));
			}

		} catch (Exception e) {
		}
		return list;

	}

	public void delete() {
		try {
			if (isExists(KdvTypeCard.getInstance().getCode())) {
				String query = "Delete from kdvtypecard where KdvTypeCode =?";
				
				pstat = conn.prepareStatement(query);
				pstat.setString(1,KdvTypeCard.getInstance().getCode());

				pstat.executeUpdate();
				pstat.close();

				JOptionPane.showMessageDialog(null, "Kdv tipi kartı başarıyla silindi.", "  ",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"Kdv tipi kartı bulunamadı. Lütfen kdv tipi kodunuzu kontrol ediniz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kdv tipi kartının bağlı olduğu stok kartı bulunmaktadır. Silinemez.",
					" Hata ", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void save() {
		try {
			if (!KdvTypeCard.getInstance().getCode().isEmpty()) {
				if (!isExists(KdvTypeCard.getInstance().getCode())) {

					String query = "insert into kdvtypecard(KdvTypeCode,KdvTypeName,KdvTypeRate)values(?,?,?)";
					setCardWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Kdv tipi kartı başarıyla eklendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String query = "UPDATE kdvtypecard SET  KdvTypeName=?,KdvTypeRate=? WHERE KdvTypeCode=?";
					setCardWithPrepaeredStatement(query);

					JOptionPane.showMessageDialog(null, "Kdv tipi kartı başarıyla güncellendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Kdv tipi kodu boş bırakılamaz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);

		}
	}

	public boolean isExists(String kdvTypeCode) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM kdvtypecard WHERE KdvTypeCode=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, kdvTypeCode);

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
			KdvTypeCard kdvc = KdvTypeCard.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, kdvc.getCode());
			pstat.setString(2, kdvc.getName());
			pstat.setDouble(3, kdvc.getRate());

			setCurrentCode(kdvc.getCode());

			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCardWithStatement(String query) {
		KdvTypeCard card = KdvTypeCard.getInstance();
		try {

			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {
				card.setCode(rs.getString("KdvTypeCode"));
				card.setName(rs.getString("KdvTypeName"));
				card.setRate(rs.getDouble("KdvTypeRate"));
			}
			setCurrentCode(card.getCode());
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCardWithPreparedStatement(String subQuery) {
		KdvTypeCard card = KdvTypeCard.getInstance();

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
					card.setCode(rs.getString("KdvTypeCode"));
					card.setName(rs.getString("KdvTypeName"));
					card.setRate(rs.getDouble("KdvTypeRate"));
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

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getCurrentCode() {
		return CurrentCode;
	}

	public void setCurrentCode(String currentCode) {
		CurrentCode = currentCode;
	}

}
