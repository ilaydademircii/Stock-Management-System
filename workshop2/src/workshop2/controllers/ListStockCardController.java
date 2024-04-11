package workshop2.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import workshop2.command.excelCommands.CreateExcelFileCommand;
import workshop2.command.excelCommands.OpenExcelFileCommand;
import workshop2.command.jasperCommands.JasperCommand;
import workshop2.command.listCommands.GetStockCardCommand;
import workshop2.command.listCommands.ListingCommand;
import workshop2.command.listCommands.SetStockCardCommand;
import workshop2.command.mailCommands.SendMailCommand;
import workshop2.command.mailCommands.SetDocumentForMailCommand;
import workshop2.model.StockCard;
import workshop2.view.ListStockCardFrame;
import workshop2.view.MainFrame;
import workshop2.view.StockCardFrame;

public class ListStockCardController {

	private MainFrame mainFrame;
	ListStockCardFrame frame;
	StockCardFrame stockCardFrame;

	ListingCommand listingcommand;
	GetStockCardCommand getStockCardCommand;
	SetStockCardCommand setStockCardCommand;

	public StockCard stockCard;
	
	OpenExcelFileCommand openExcelFileCommand;
	CreateExcelFileCommand createExcelFileCommand;
	SetDocumentForMailCommand setDocumentForMailCommand;
	JasperCommand jasperCommand;
	SendMailCommand sendMailCommand;
	StockCardController stockCardController;

	public ListStockCardController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new ListStockCardFrame();
		this.createExcelFileCommand = new CreateExcelFileCommand(frame);
		this.openExcelFileCommand = new OpenExcelFileCommand();
		this.getStockCardCommand = new GetStockCardCommand(frame);
		this.jasperCommand = new JasperCommand();
		this.sendMailCommand = new SendMailCommand();
		this.listingcommand = new ListingCommand(frame);
		this.setDocumentForMailCommand = new SetDocumentForMailCommand();

	}

	public void execute() {
		fillFrameInstance();
		list();
		selectionOnTable();
		showStockCard();
		addPopup(frame.table, frame.popupMenu);
		getExcelDocument();
		getToTheScreen();
		getMail();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	public void list() {
		frame.listButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listingcommand.execute();

			}
		});
	}

	public void selectionOnTable() {
		frame.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					getStockCardCommand.execute();
				}

			}
		});
	}

	public void showStockCard() {
		frame.stockCardMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockCardController = new StockCardController(mainFrame);
				stockCardController.execute();
				setStockCardCommand = new SetStockCardCommand( stockCardController.getFrame());
				setStockCardCommand.execute();
			}
		});
	}

	public void getExcelDocument() {
		frame.excelMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createExcelFileCommand.execute();
				openExcelFileCommand.execute();
			}
		});
	}

	public void getToTheScreen() {
		frame.toTheScreenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jasperCommand.execute();
			}
		});
	}

	public void getMail() {
		frame.eMailMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setDocumentForMailCommand.execute();
					sendMailCommand.execute();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void setStockCard(StockCard stockCard) {
		this.stockCard = stockCard;
	}

	public StockCard getStockCard() {
		return stockCard;
	}

}
