import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MiniNavegador extends Application { 

	@Override
	public void start(Stage palco){
		TextField campoUrl = new TextField();
		WebView navegador = new WebView();
		WebEngine motor = navegador.getEngine();

		// Carrega uma pag. da web ao pressionar enter 
		campoUrl.setOnAction(evento -> motor.load(formataUrl(campoUrl.getText())));

		VBox vbox = new VBox(); 
		vbox.getChildren().addAll(campoUrl, navegador);
		Scene cena = new Scene(vbox);

		palco.setTitle("Meu Browser Java");
		palco.setScene(cena);
		palco.show();
	}

	public static void main(String[] args){
		launch(args);
	}

	// Metodo para inserir HTTP se o usuário não digitar 
	public String formataUrl(String url){
		if(!url.startsWith("http://") && !url.startsWith("https://")){
			url = "http://" + url;
		}
		return url;
	}
}
