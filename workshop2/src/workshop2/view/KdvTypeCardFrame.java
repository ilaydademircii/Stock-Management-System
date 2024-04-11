package workshop2.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KdvTypeCardFrame extends JInternalFrame {
	public JTextField kdvTypeCode;
	public JTextField kdvTypeName;
	public JTextField kdvTypeRate;
	public JButton saveButton;
	public JButton deleteButton;
	public JButton previousButton;
	public JButton nextButton;
	public JButton firstButton;
	public JButton lastButton;

	public KdvTypeCardFrame() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Kdv Tipi Kartı");
		setBounds(100, 100, 474, 418);
		getContentPane().setLayout(null);

		JLabel lblKdvTipiKodu = new JLabel("Kdv Tipi Kodu :");
		lblKdvTipiKodu.setBounds(20, 30, 115, 30);
		lblKdvTipiKodu.setHorizontalAlignment(SwingConstants.LEFT);
		lblKdvTipiKodu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblKdvTipiKodu);

		JLabel lblKdvTipiAd = new JLabel("Kdv Tipi Adı :");
		lblKdvTipiAd.setBounds(20, 80, 115, 30);
		lblKdvTipiAd.setHorizontalAlignment(SwingConstants.LEFT);
		lblKdvTipiAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblKdvTipiAd);

		JLabel lblKdvTipiOran = new JLabel("Kdv Tipi Oranı :");
		lblKdvTipiOran.setBounds(20, 130, 115, 30);
		lblKdvTipiOran.setHorizontalAlignment(SwingConstants.LEFT);
		lblKdvTipiOran.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblKdvTipiOran);

		kdvTypeCode = new JTextField();
		kdvTypeCode.setBounds(150, 30, 240, 30);
		kdvTypeCode.setColumns(10);
		getContentPane().add(kdvTypeCode);

		kdvTypeName = new JTextField();
		kdvTypeName.setBounds(150, 80, 240, 30);
		kdvTypeName.setColumns(10);
		getContentPane().add(kdvTypeName);

		saveButton = new JButton("Kaydet");
		saveButton.setBounds(275, 195, 100, 25);
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(saveButton);

		deleteButton = new JButton("Sil");
		deleteButton.setBounds(275, 230, 100, 25);
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(deleteButton);

		kdvTypeRate = new JTextField();
		kdvTypeRate.setBounds(150, 130, 240, 30);
		kdvTypeRate.setColumns(10);
		getContentPane().add(kdvTypeRate);

		firstButton = new JButton("");

		firstButton.setBounds(83, 283, 57, 23);
		firstButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\first.png"));
		getContentPane().add(firstButton);

		previousButton = new JButton("");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		previousButton.setBounds(150, 283, 57, 23);
		previousButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\left2.png"));
		getContentPane().add(previousButton);

		nextButton = new JButton("");

		nextButton.setBounds(217, 283, 57, 23);
		nextButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\right2.png"));
		getContentPane().add(nextButton);

		lastButton = new JButton("");
		lastButton.setBounds(284, 283, 57, 23);
		lastButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\end2.png"));
		getContentPane().add(lastButton);

	}
}
