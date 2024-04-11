package workshop2.command.saveCommands;

import workshop2.model.StockTypeCard;
import workshop2.view.StockTypeCardFrame;

public class StockTypeCardSaveCommand implements SaveCommand {

	StockTypeCardFrame frame;
	StockTypeCard stc;
	
	public StockTypeCardSaveCommand(StockTypeCardFrame cardFrame) {
		super();
		this.frame = cardFrame;
		this.stc=StockTypeCard.getInstance();
	}

	@Override
	public void execute() {
		stc.setCode(frame.stockTypeCode.getText().trim());
		stc.setName(frame.stockTypeName.getText().trim());
		stc.setExplanation(frame.stockTypeExplanation.getText());
	}
}
