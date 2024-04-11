package workshop2.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class StockCardFrame extends JInternalFrame {
	public JTextField stockCode;
	public JTextField stockName;
	public JTextField barcode;
	public JComboBox<String> stockType;
	public JComboBox<String> unit;
	public JComboBox<String> kdvType;
	public JTextArea explanation;
	public JFormattedTextField dateArea;
	public JButton saveButton;
	public JButton deleteButton;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_1_1;
	public JLabel lblNewLabel_1_2;
	public JLabel lblNewLabel_2_2;
	public JLabel lblNewLabel_1_2_1;
	public JLabel lblNewLabel_1_3;
	public JLabel lblNewLabel_1_2_3;
	public JLabel lblNewLabel_1_2_2;
	public JButton firstButton;
	public JButton previousButton;
	public JButton nextButton;
	public JButton lastButton;
	public static StockCardFrame instance;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
//	public static StockCardFrame getInstance() {
//		if (instance == null) {
//			instance = new StockCardFrame();
//		}
//		return instance;
//	}

	public StockCardFrame() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Stok Kartı");
		setBounds(100, 100, 872, 591);
		getContentPane().setLayout(null);

		stockCode = new JTextField();
		stockCode.setColumns(10);
		stockCode.setBounds(182, 28, 240, 30);
		getContentPane().add(stockCode);

		lblNewLabel = new JLabel("Stok Kodu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(62, 28, 90, 30);
		getContentPane().add(lblNewLabel);

		stockName = new JTextField();
		stockName.setColumns(10);
		stockName.setBounds(182, 78, 240, 30);
		getContentPane().add(stockName);

		stockType = new JComboBox<String>();
		stockType.setBounds(182, 128, 200, 30);
		getContentPane().add(stockType);

		unit = new JComboBox<String>();
		unit.setBounds(182, 178, 200, 30);
		getContentPane().add(unit);
		unit.addItem("1");
		unit.addItem("2");

		lblNewLabel_1 = new JLabel("Stok Adı");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(62, 78, 90, 30);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_1_1 = new JLabel("Stok Tipi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(62, 128, 90, 30);
		getContentPane().add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("Birimi");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(62, 178, 90, 30);
		getContentPane().add(lblNewLabel_1_2);

		lblNewLabel_1_2_1 = new JLabel("Barkodu");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(62, 228, 90, 30);
		getContentPane().add(lblNewLabel_1_2_1);

		lblNewLabel_1_2_2 = new JLabel("KDV Tipi");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(62, 278, 90, 30);
		getContentPane().add(lblNewLabel_1_2_2);

		lblNewLabel_1_2_3 = new JLabel("Açıklama");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(62, 328, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);

		barcode = new JTextField();
		barcode.setColumns(10);
		barcode.setBounds(182, 228, 240, 30);
		getContentPane().add(barcode);

		kdvType = new JComboBox<String>();
		kdvType.setBounds(182, 278, 200, 30);
		getContentPane().add(kdvType);

		explanation = new JTextArea();
		explanation.setBounds(182, 328, 240, 120);
		getContentPane().add(explanation);

		dateArea = new JFormattedTextField();
		dateArea.setEnabled(false);
		dateArea.setBounds(182, 468, 240, 30);
		getContentPane().add(dateArea);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Oluşturma Zamanı");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_3_1.setBounds(62, 468, 144, 30);
		getContentPane().add(lblNewLabel_1_2_3_1);

		saveButton = new JButton("Kaydet");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		saveButton.setBounds(531, 158, 100, 25);
		getContentPane().add(saveButton);

		deleteButton = new JButton("Sil");
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deleteButton.setBounds(531, 193, 100, 25);
		getContentPane().add(deleteButton);

		firstButton = new JButton("");
		firstButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\first.png"));
		firstButton.setBounds(462, 278, 57, 23);
		getContentPane().add(firstButton);

		previousButton = new JButton("");
		previousButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\left2.png"));
		previousButton.setBounds(529, 278, 57, 23);
		getContentPane().add(previousButton);

		nextButton = new JButton("");
		nextButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\right2.png"));
		nextButton.setBounds(596, 278, 57, 23);
		getContentPane().add(nextButton);

		lastButton = new JButton("");
		lastButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\end2.png"));
		lastButton.setBounds(663, 278, 57, 23);
		getContentPane().add(lastButton);

	}
}
