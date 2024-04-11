package workshop2.command.deleteCommands;

import workshop2.model.StockCard;
import workshop2.view.StockCardFrame;

public class StockCardDeleteCommand {

	StockCardFrame frame;

	public StockCardDeleteCommand(StockCardFrame cardFrame) {
		super();
		this.frame = cardFrame;
	}

	public void execute() {
		StockCard sc = StockCard.getInstance();
		sc.setStockCode(frame.stockCode.getText().trim());
	}

}
