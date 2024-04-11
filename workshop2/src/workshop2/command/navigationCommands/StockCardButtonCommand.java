package workshop2.command.navigationCommands;

import workshop2.model.StockCard;
import workshop2.view.StockCardFrame;

public class StockCardButtonCommand implements ButtonCommand {

	StockCardFrame frame;
	StockCard card;

	public StockCardButtonCommand(StockCardFrame frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.stockCode.setText(card.getStockCode());
		frame.stockName.setText(card.getStockName());
		frame.stockType.setSelectedItem(card.getStockTypeCode());
		frame.unit.setSelectedItem(card.getUnit());
		frame.barcode.setText(card.getBarcode());
		frame.kdvType.setSelectedItem(card.getKdvTypeCode());
		frame.explanation.setText(card.getExplanation());
		frame.dateArea.setText(card.getDate());

	}

	public StockCard getCard() {
		return card;
	}

	public void setCard(StockCard card) {
		this.card = card;
	}

}
