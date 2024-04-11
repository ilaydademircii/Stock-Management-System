package workshop2.command.listCommands;

import workshop2.model.ListStockCard;
import workshop2.view.ListStockCardFrame;

public class ListingCommand {

	ListStockCardFrame frame;

	public ListingCommand(ListStockCardFrame cardFrame) {
		super();
		this.frame = cardFrame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);
		for (ListStockCard c : ListStockCard.getInstance().stockCardList()) {
			Object[] rowData = { c.getStockCode(), c.getStockName(), c.getUnit(),
					c.getBarcode(), c.getStockTypeCode(),c.getStockTypeName(),
					c.getStockTypeExplanation(), c.getKdvTypeCode(), c.getKdvTypeName(),
					c.getKdvTypeRate(), c.getExplanation(), c.getDate() };
			frame.modelim.addRow(rowData);

		}
		frame.table.setModel(frame.modelim);
	}

}
