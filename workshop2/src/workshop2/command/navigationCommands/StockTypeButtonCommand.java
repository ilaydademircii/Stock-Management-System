package workshop2.command.navigationCommands;

import workshop2.model.StockTypeCard;
import workshop2.view.StockTypeCardFrame;

public class StockTypeButtonCommand implements ButtonCommand {

	StockTypeCardFrame frame;
	StockTypeCard card;

	public StockTypeButtonCommand(StockTypeCardFrame frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.stockTypeCode.setText(card.getCode());
		frame.stockTypeName.setText(card.getName());
		frame.stockTypeExplanation.setText(card.getExplanation());

	}

	public StockTypeCard getCard() {
		return card;
	}

	public void setCard(StockTypeCard card) {
		this.card = card;
	}

}
