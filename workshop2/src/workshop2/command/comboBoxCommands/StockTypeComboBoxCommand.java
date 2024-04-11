package workshop2.command.comboBoxCommands;

import java.util.List;

import workshop2.model.StockTypeCard;
import workshop2.view.StockCardFrame;

public class StockTypeComboBoxCommand implements ComboBoxCommand{

	StockCardFrame frame;

	public StockTypeComboBoxCommand(StockCardFrame frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void execute() {
		List<String> list = StockTypeCard.getInstance().getAllStockTypeCodes();
		frame.stockType.removeAllItems();
		for (String stockTypeName : list) {
			frame.stockType.addItem(stockTypeName);
		}
	}

}
