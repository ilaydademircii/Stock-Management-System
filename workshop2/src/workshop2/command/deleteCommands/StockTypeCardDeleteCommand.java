package workshop2.command.deleteCommands;

import workshop2.model.StockTypeCard;
import workshop2.view.StockTypeCardFrame;

public class StockTypeCardDeleteCommand implements DeleteCommand{

	StockTypeCardFrame frame;

	public StockTypeCardDeleteCommand(StockTypeCardFrame cardFrame) {
		super();
		this.frame = cardFrame;
	}

	@Override
	public void execute() {
		StockTypeCard stc = StockTypeCard.getInstance();
		stc.setCode(frame.stockTypeCode.getText().trim());
	}

}
