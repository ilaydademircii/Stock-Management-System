package workshop2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import workshop2.command.deleteCommands.KdvTypeCardDeleteCommand;
import workshop2.command.navigationCommands.KdvTypeButtonCommand;
import workshop2.command.saveCommands.KdvTypeCardSaveCommand;
import workshop2.model.KdvTypeCard;
import workshop2.view.KdvTypeCardFrame;
import workshop2.view.MainFrame;

public class KdvTypeCardController {

	private MainFrame mainFrame;
	KdvTypeCardFrame frame;

	KdvTypeCardSaveCommand saveCommand;
	KdvTypeCardDeleteCommand deleteCommand;
	KdvTypeButtonCommand buttonCommand;

	KdvTypeCard kdvTypeCard;

	public KdvTypeCardController(MainFrame mainFrame) {
		super();
		this.frame = new KdvTypeCardFrame();
		this.mainFrame = mainFrame;
		this.saveCommand = new KdvTypeCardSaveCommand(frame);
		this.deleteCommand = new KdvTypeCardDeleteCommand(frame);
		this.kdvTypeCard = KdvTypeCard.getInstance();
		this.buttonCommand = new KdvTypeButtonCommand(frame);

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
				buttonCommand.setCard(kdvTypeCard.getFirstCard());
				buttonCommand.execute();

			}
		});
	}

	private void getLast() {
		frame.lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(kdvTypeCard.getLastCard());
				buttonCommand.execute();
			}
		});
	}

	private void getNext() {
		frame.nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(kdvTypeCard.getByOrderIncrease());
				buttonCommand.execute();
			}
		});
	}

	private void getPrevious() {
		frame.previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCommand.setCard(kdvTypeCard.getByOrderDecrease());
				buttonCommand.execute();
			}
		});
	}

	public void save() {
		frame.saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCommand.execute();
				kdvTypeCard.save();
			}
		});
	}

	public void delete() {
		frame.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCommand.execute();
				kdvTypeCard.delete();
			}
		});
	}

}
