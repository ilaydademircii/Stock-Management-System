package workshop2.command.excelCommands;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import workshop2.view.ListStockCardFrame;

public class CreateExcelFileCommand {

	ListStockCardFrame frame;

	public CreateExcelFileCommand(ListStockCardFrame frame) {
		super();
		this.frame = frame;
	}

	public void execute() {

		try {
			File file = new File("stockcardlist.xls");
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet("Stok Listesi", 0);

			for (int i = 0; i < 12; i++) {
				Label column = new Label(i, 0, frame.table.getColumnName(i));
				sheet.addCell((WritableCell) column);

			}

			for (int i = 0; i < frame.table.getRowCount(); i++) {
				for (int j = 0; j < frame.table.getColumnCount(); j++) {
					if (frame.table.getValueAt(i, j) != null) {
						Label row = new Label(j, i + 1, frame.table.getValueAt(i, j).toString());
						sheet.addCell((WritableCell) row);
					}
				}
			}
			workbook.write();
			workbook.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
