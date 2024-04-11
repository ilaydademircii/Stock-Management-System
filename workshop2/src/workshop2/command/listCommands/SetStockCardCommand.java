package workshop2.command.listCommands;

import workshop2.model.StockCard;
import workshop2.view.StockCardFrame;

public class SetStockCardCommand {

	StockCard stockCard;
	StockCardFrame frame;

	public SetStockCardCommand( StockCardFrame frame) {
		super();
		this.stockCard = StockCard.getInstance();
		this.frame = frame;
	}

	public void execute() {
			frame.stockCode.setText(stockCard.getStockCode());
			frame.stockName.setText(stockCard.getStockName());
			frame.stockType.setSelectedItem(stockCard.getStockTypeCode());
			frame.barcode.setText(stockCard.getBarcode());
			frame.kdvType.setSelectedItem(stockCard.getKdvTypeCode());
			frame.dateArea.setText(stockCard.getDate());
			frame.explanation.setText(stockCard.getExplanation());
			frame.unit.setSelectedItem(stockCard.getUnit());

	}

}
