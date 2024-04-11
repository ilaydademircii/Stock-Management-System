package workshop2.command.saveCommands;

import workshop2.model.StockCard;
import workshop2.view.StockCardFrame;

public class StockCardSaveCommand implements SaveCommand {

	StockCardFrame frame;
	StockCard sc;

	public StockCardSaveCommand(StockCardFrame cardFrame) {
		super();
		this.frame = cardFrame;
		sc = StockCard.getInstance();
	}

	@Override
	public void execute() {

		sc.setStockName(frame.stockName.getText().trim());
		sc.setStockCode(frame.stockCode.getText().trim());
		sc.setStockTypeCode(frame.stockType.getSelectedItem().toString());
		sc.setBarcode(frame.barcode.getText().trim());
		sc.setKdvTypeCode(frame.kdvType.getSelectedItem().toString());
		sc.setExplanation(frame.explanation.getText());
		sc.setDate(frame.dateArea.getText());
		sc.setUnit(frame.unit.getSelectedItem().toString());

	}
}