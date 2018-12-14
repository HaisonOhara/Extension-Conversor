package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MenuController {

	@FXML
	private TextField NovoField;

	@FXML
	private TextField CaminhoField;

	@FXML
	private TextField AntigoField;

	@FXML
	void StartOnAction(ActionEvent event) {

		
		List alist = new ArrayList<>();
		String first = CaminhoField.getText().replaceAll("/", "\\");
		String antigo = AntigoField.getText();
		String novo = NovoField.getText();
		// a dd the list of commands to the list
		alist.add("cmd.exe");
        alist.add("/C");
		alist.add("ren *." + antigo + " *." + novo);

		// initialize the processbuilder
		ProcessBuilder builder = new ProcessBuilder();
		builder.command(alist);
		builder.directory(new File(first));
		try {
			// start the process
			builder.start();

			JOptionPane.showMessageDialog(null, "Conversion Done!", "InfoBox: " + "Aviso", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(null, "Directory not Found!", "InfoBox: " + "Warning!", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Folder");

	}

	@FXML
	void CancelOnAction(ActionEvent event) {

		Platform.exit();
	}

}
