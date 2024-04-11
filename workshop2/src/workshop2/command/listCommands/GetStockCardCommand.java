package workshop2.command.listCommands;

import workshop2.model.StockCard;
import workshop2.view.ListStockCardFrame;

public class GetStockCardCommand {

	ListStockCardFrame listStockCardFrame;
	StockCard stockCard;

	public GetStockCardCommand(ListStockCardFrame listStockCardFrame) {
		super();
		this.listStockCardFrame = listStockCardFrame;
		this.stockCard = StockCard.getInstance();
	}

	public void execute() {
			int selectedRow = listStockCardFrame.table.getSelectedRow();
			if (selectedRow >= 0) {
				stockCard.setStockCode(listStockCardFrame.table.getValueAt(selectedRow, 0).toString());
				stockCard.setStockName(listStockCardFrame.table.getValueAt(selectedRow, 1).toString());
				stockCard.setUnit(listStockCardFrame.table.getValueAt(selectedRow, 2).toString());
				stockCard.setBarcode(listStockCardFrame.table.getValueAt(selectedRow, 3).toString());
				stockCard.setStockTypeCode(listStockCardFrame.table.getValueAt(selectedRow, 4).toString());
				stockCard.setKdvTypeCode(listStockCardFrame.table.getValueAt(selectedRow, 7).toString());
				stockCard.setExplanation(listStockCardFrame.table.getValueAt(selectedRow, 10).toString());
				stockCard.setDate(listStockCardFrame.table.getValueAt(selectedRow, 11).toString());
			}
	}
}
