package workshop2.command.comboBoxCommands;

import java.util.List;

import workshop2.model.KdvTypeCard;
import workshop2.view.StockCardFrame;

public class KdvTypeComboBoxCommand implements ComboBoxCommand{

	StockCardFrame frame;

	public KdvTypeComboBoxCommand(StockCardFrame frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void execute() {
		List<String> list = KdvTypeCard.getInstance().getAllKdvTypeCodes();
		frame.kdvType.removeAllItems();
		for (String kdvName : list) {
			frame.kdvType.addItem(kdvName);
		}
	}

}
