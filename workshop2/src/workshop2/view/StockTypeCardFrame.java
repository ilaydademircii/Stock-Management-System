package workshop2.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StockTypeCardFrame extends JInternalFrame {
	public JTextField stockTypeCode;
	public JTextField stockTypeName;
	public JTextArea stockTypeExplanation;
	public JButton saveButton;
	public JButton deleteButton;
	public JButton firstButton;
	public JButton previousButton;
	public JButton nextButton;
	public JButton lastButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public StockTypeCardFrame() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		setTitle("Stok Tipi Kartı");
		setBounds(100, 100, 490, 446);
		getContentPane().setLayout(null);

		JLabel lblStokTipiKodu = new JLabel("Stok Tipi Kodu :");
		lblStokTipiKodu.setHorizontalAlignment(SwingConstants.LEFT);
		lblStokTipiKodu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStokTipiKodu.setBounds(20, 30, 115, 30);
		getContentPane().add(lblStokTipiKodu);

		JLabel lblStokTipiAd = new JLabel("Stok Tipi Adı :");
		lblStokTipiAd.setHorizontalAlignment(SwingConstants.LEFT);
		lblStokTipiAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStokTipiAd.setBounds(20, 80, 115, 30);
		getContentPane().add(lblStokTipiAd);

		JLabel lblAklama = new JLabel("Açıklama :");
		lblAklama.setHorizontalAlignment(SwingConstants.LEFT);
		lblAklama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAklama.setBounds(20, 130, 115, 30);
		getContentPane().add(lblAklama);

		stockTypeCode = new JTextField();
		stockTypeCode.setColumns(10);
		stockTypeCode.setBounds(150, 30, 240, 30);
		getContentPane().add(stockTypeCode);

		stockTypeName = new JTextField();
		stockTypeName.setColumns(10);
		stockTypeName.setBounds(150, 80, 240, 30);
		getContentPane().add(stockTypeName);

		stockTypeExplanation = new JTextArea();
		stockTypeExplanation.setBounds(150, 130, 240, 120);
		getContentPane().add(stockTypeExplanation);

		saveButton = new JButton("Kaydet");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		saveButton.setBounds(273, 282, 100, 25);
		getContentPane().add(saveButton);

		deleteButton = new JButton("Sil");
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deleteButton.setBounds(273, 317, 100, 25);
		getContentPane().add(deleteButton);

		firstButton = new JButton("");

		firstButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\first.png"));

		firstButton.setBounds(143, 353, 57, 23);
		getContentPane().add(firstButton);

		previousButton = new JButton("");
		previousButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\left2.png"));
		previousButton.setBounds(210, 353, 57, 23);
		getContentPane().add(previousButton);

		nextButton = new JButton("");
		nextButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\right2.png"));
		nextButton.setBounds(277, 353, 57, 23);
		getContentPane().add(nextButton);

		lastButton = new JButton("");
		lastButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\end2.png"));
		lastButton.setBounds(344, 353, 57, 23);
		getContentPane().add(lastButton);

	}
}
