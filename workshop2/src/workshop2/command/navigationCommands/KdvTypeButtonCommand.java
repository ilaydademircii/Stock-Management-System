package workshop2.command.navigationCommands;

import workshop2.model.KdvTypeCard;
import workshop2.view.KdvTypeCardFrame;

public class KdvTypeButtonCommand implements ButtonCommand {

	KdvTypeCardFrame kdvTypeCardFrame;
	KdvTypeCard card;

	public KdvTypeButtonCommand(KdvTypeCardFrame kdvTypeCardFrame) {
		super();
		this.kdvTypeCardFrame = kdvTypeCardFrame;
	}

	@Override
	public void execute() {
		kdvTypeCardFrame.kdvTypeCode.setText(card.getCode());
		kdvTypeCardFrame.kdvTypeName.setText(card.getName());
		kdvTypeCardFrame.kdvTypeRate.setText(card.getRate().toString());
	}

	public KdvTypeCard getCard() {
		return card;
	}

	public void setCard(KdvTypeCard card) {
		this.card = card;
	}

}
