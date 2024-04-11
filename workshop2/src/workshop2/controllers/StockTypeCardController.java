package workshop2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import workshop2.command.deleteCommands.StockTypeCardDeleteCommand;
import workshop2.command.navigationCommands.StockTypeButtonCommand;
import workshop2.command.saveCommands.StockTypeCardSaveCommand;
import workshop2.model.StockTypeCard;
import workshop2.view.MainFrame;
import workshop2.view.StockTypeCardFrame;

public class StockTypeCardController {

	MainFrame mainFrame;
	StockTypeCardFrame frame;

	StockTypeCardSaveCommand saveCommand;
	StockTypeCardDeleteCommand deleteCommand;
	StockTypeButtonCommand buttonCommand;

	StockTypeCard stockTypeCard;

	public StockTypeCardController(MainFrame mainFrame) {
		super();
		this.stockTypeCard = StockTypeCard.getInstance();
		this.frame = new StockTypeCardFrame();
		this.mainFrame = mainFrame;
		this.saveCommand = new StockTypeCardSaveCommand(frame);
		this.deleteCommand = new StockTypeCardDeleteCommand(frame);
		this.buttonCommand = new StockTypeButtonCommand(frame);
	}

	public void execute() {
		fillFrameInstance();
		save();
		delete();
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
				buttonCommand.setCard(stockTypeCard.getFirstCard());
				buttonCommand.execute();
			}
		});
	}

	private void getLast() {
		frame.lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(stockTypeCard.getLastCard());
				buttonCommand.execute();
			}
		});
	}

	private void getNext() {
		frame.nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(stockTypeCard.getByOrderIncrease());
				buttonCommand.execute();

			}
		});
	}

	private void getPrevious() {
		frame.previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(stockTypeCard.getByOrderDecrease());
				buttonCommand.execute();

			}
		});
	}

	public void save() {
		frame.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCommand.execute();
				stockTypeCard.save();
			}
		});
	}

	public void delete() {
		frame.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCommand.execute();
				stockTypeCard.delete();
			}
		});
	}

}
