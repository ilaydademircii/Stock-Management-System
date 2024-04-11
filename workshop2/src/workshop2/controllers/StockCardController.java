package workshop2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import workshop2.command.comboBoxCommands.KdvTypeComboBoxCommand;
import workshop2.command.comboBoxCommands.StockTypeComboBoxCommand;
import workshop2.command.deleteCommands.StockCardDeleteCommand;
import workshop2.command.navigationCommands.StockCardButtonCommand;
import workshop2.command.saveCommands.StockCardSaveCommand;
import workshop2.model.StockCard;
import workshop2.view.MainFrame;
import workshop2.view.StockCardFrame;

public class StockCardController {

	public MainFrame mainFrame;
	public StockCardFrame frame;

	StockCardSaveCommand saveCommand;
	StockCardDeleteCommand deleteCommand;
	KdvTypeComboBoxCommand kdvTypeComboBoxCommand;
	StockTypeComboBoxCommand stockTypeComboBoxCommand;
	StockCardButtonCommand buttonCommand;

	StockCard stockCard;

	public StockCardController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.stockCard = StockCard.getInstance();
		this.frame = new StockCardFrame();
		this.saveCommand = new StockCardSaveCommand(frame);
		this.deleteCommand = new StockCardDeleteCommand(frame);
		this.stockTypeComboBoxCommand = new StockTypeComboBoxCommand(frame);
		this.kdvTypeComboBoxCommand = new KdvTypeComboBoxCommand(frame);
		this.buttonCommand = new StockCardButtonCommand(frame);
	}

	public void execute() {
		fillFrameInstance();
		save();
		delete();
		setKdvTypeComboBox();
		setStockTypeComboBox();
		getFirst();
		getLast();
		getNext();
		getPrevious();
	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void getFirst() {
		frame.firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(stockCard.getFirstCard());
				buttonCommand.execute();
			}
		});
	}

	private void getLast() {
		frame.lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(stockCard.getLastCard());
				buttonCommand.execute();
			}
		});
	}

	private void getNext() {
		frame.nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(stockCard.getByOrderIncrease());
				buttonCommand.execute();

			}
		});
	}

	private void getPrevious() {
		frame.previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(stockCard.getByOrderDecrease());
				buttonCommand.execute();
			}
		});
	}

	public void setKdvTypeComboBox() {
		kdvTypeComboBoxCommand.execute();
	}

	public void setStockTypeComboBox() {
		stockTypeComboBoxCommand.execute();
	}

	public void save() {
		frame.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCommand.execute();
				stockCard.save();
			}
		});
	}

	public void delete() {
		frame.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCommand.execute();
				stockCard.delete();
			}
		});
	}

	public StockCardFrame getFrame() {
		return frame;
	}

	public void setFrame(StockCardFrame frame) {
		this.frame = frame;
	}
}
