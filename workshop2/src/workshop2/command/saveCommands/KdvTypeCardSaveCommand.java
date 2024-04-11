package workshop2.command.saveCommands;

import javax.swing.JOptionPane;

import workshop2.model.KdvTypeCard;
import workshop2.view.KdvTypeCardFrame;

public class KdvTypeCardSaveCommand implements SaveCommand {

	KdvTypeCardFrame frame;
	KdvTypeCard kdvc;

	public KdvTypeCardSaveCommand(KdvTypeCardFrame cardFrame) {
		super();
		this.frame = cardFrame;
		this.kdvc = KdvTypeCard.getInstance();
	}

	@Override
	public void execute() {

		kdvc.setCode(frame.kdvTypeCode.getText().trim());
		kdvc.setName(frame.kdvTypeName.getText().trim());
		String rateText = frame.kdvTypeRate.getText().trim();
		if (!rateText.isEmpty()) {
			try {
				Double rate = Double.parseDouble(rateText);
				kdvc.setRate(rate);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Geçerli bir kdv oranı giriniz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
