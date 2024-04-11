package workshop2.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ListStockCardFrame extends JInternalFrame {
	public DefaultTableModel modelim;
	public JButton listButton;
	public JMenuItem stockCardMenuItem;
	public JMenuItem excelMenuItem;
	public JMenuItem toTheScreenMenuItem;
	public JMenuItem eMailMenuItem;

	Object[] colums = { "Stok Kodu", "Stok Adı", "Birimi", "Barkodu", "Stok Tipi Kodu", "Stok Tipi Adı",
			"Stok Tipi Açıklaması", "KDV Tipi Kodu", "Kdv Tipi Adı", "Kdv Tipi Oranı", "Açıklama", "Oluşturma Zamanı" };
	public JTable table;
	public JPopupMenu popupMenu;

	public ListStockCardFrame() {
		setTitle("Stok Kart Listesi");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 1405, 694);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("STOK KART LİSTESİ");
		lblNewLabel.setBounds(583, 26, 253, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		listButton = new JButton("Listele");
		listButton.setBounds(638, 593, 177, 34);

		listButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(listButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 104, 1296, 439);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		popupMenu = new JPopupMenu();

		stockCardMenuItem = new JMenuItem("Stok Kartı");
		excelMenuItem = new JMenuItem("Excel");
		toTheScreenMenuItem = new JMenuItem("Ekrana");
		eMailMenuItem = new JMenuItem("E-Posta");

		popupMenu.add(stockCardMenuItem);
		popupMenu.add(excelMenuItem);
		popupMenu.add(toTheScreenMenuItem);
		popupMenu.add(eMailMenuItem);
		modelim = new DefaultTableModel();
		modelim.setColumnIdentifiers(colums);

	}

}
