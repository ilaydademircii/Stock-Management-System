package workshop2.command.deleteCommands;

import workshop2.model.KdvTypeCard;
import workshop2.view.KdvTypeCardFrame;

public class KdvTypeCardDeleteCommand implements DeleteCommand{

	KdvTypeCardFrame frame;

	public KdvTypeCardDeleteCommand(KdvTypeCardFrame cardFrame) {
		super();
		this.frame = cardFrame;
	}

	@Override
	public void execute() {
		KdvTypeCard kdvc = KdvTypeCard.getInstance();
		kdvc.setCode(frame.kdvTypeCode.getText().trim());
	}
}
