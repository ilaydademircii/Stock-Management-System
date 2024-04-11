package workshop2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import workshop2.view.MainFrame;

public class MainFrameController {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);

		mainFrame.stockCardMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockCardController cardController = new StockCardController(mainFrame);
				cardController.execute();
			}
		});

		mainFrame.stockTypeCardMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockTypeCardController cardController = new StockTypeCardController(mainFrame);
				cardController.execute();
			}
		});

		mainFrame.kdvTypeCardMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KdvTypeCardController cardController = new KdvTypeCardController(mainFrame);
				cardController.execute();

			}
		});

		mainFrame.listMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListStockCardController cardController = new ListStockCardController(mainFrame);
				cardController.execute();
			}
		});

		mainFrame.StockCardToolBarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockCardController cardController = new StockCardController(mainFrame);
				cardController.execute();
			}
		});
	}

}
