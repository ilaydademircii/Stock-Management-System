package workshop2.view;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public JDesktopPane desktopPane;
	public JMenuItem stockCardMenuItem;
	public JMenuItem stockTypeCardMenuItem;
	public JMenuItem kdvTypeCardMenuItem;
	public JMenuItem listMenuItem;
	public JButton StockCardToolBarButton;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 672);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Stok");
		menuBar.add(mnNewMenu);

		stockCardMenuItem = new JMenuItem("Stok Kart");

		mnNewMenu.add(stockCardMenuItem);

		stockTypeCardMenuItem = new JMenuItem("Stok Tipi Kartı");

		mnNewMenu.add(stockTypeCardMenuItem);

		kdvTypeCardMenuItem = new JMenuItem("Kdv Tipi Kartı");
		mnNewMenu.add(kdvTypeCardMenuItem);

		listMenuItem = new JMenuItem("Stok Kart Listele");
		mnNewMenu.add(listMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_73753716930100");

		JToolBar toolBar = new JToolBar();

		StockCardToolBarButton = new JButton("");
		StockCardToolBarButton
				.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\icons8-card-20.png"));

		toolBar.add(StockCardToolBarButton);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addComponent(toolBar,
				GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE));
		gl_desktopPane.setVerticalGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane
						.createSequentialGroup().addComponent(toolBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(572, Short.MAX_VALUE)));
		desktopPane.setLayout(gl_desktopPane);
	}
}
