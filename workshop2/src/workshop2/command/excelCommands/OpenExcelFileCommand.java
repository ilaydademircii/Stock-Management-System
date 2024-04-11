package workshop2.command.excelCommands;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenExcelFileCommand {

	public OpenExcelFileCommand() {
		super();
	}

	public void execute() {
		String excelFilePath = "C:\\Users\\zehra\\guruyazilim\\workshop2\\stockcardlist.xls";

		try {
			File excelFile = new File(excelFilePath);

			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (excelFile.exists()) {
					desktop.open(excelFile);
				} else {
					System.out.println("Belirtilen dosya mevcut değil.");
				}
			} else {
				System.out.println("Masaüstü desteği devre dışı bırakılmış.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
