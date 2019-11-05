package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("First.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Item Sharing Service");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
