package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import home.MyInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static home.MyInfo.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.control.ListView;

public class MyPageController implements Initializable {

	@FXML Label mypage_name;
	@FXML Label mypage_id;
	@FXML Label mypage_phone;
	
//	static String[] mypage_info = DBMembers.load_myInfo(my_id);
	@FXML HBox mpTopHbox;
	@FXML HBox mpBtnColor;
	@FXML Button mpBtn1;
	@FXML Button mpBtn2;
	@FXML Button mpBtn3;
	@FXML Button mpBtn4;
	@FXML Button mpBtn5;
	@FXML Button mpBtn6;
	@FXML Button mpMoveUserHome;
	@FXML Label mpTitle;
	@FXML Label mpLabel;
	@FXML AnchorPane mpPaneUnderLabel;
	@FXML Button mpMythingBtn;
	@FXML Button mpYourthingBtn;
	@FXML Label mpNotificationLabel;
	@FXML Line mpLine1;
	@FXML Line mpLine2;
	@FXML Line mpLine3;
	@FXML Line mpLine4;
	@FXML AnchorPane mpBackColor;
	@FXML Label mpLab1;
	@FXML Label mpLab2;
	@FXML Label mpLab3;
	@FXML ListView mpNotiView;

	
	void init() {
		Socket socket = MyInfo.socket;
		
		
        try {
           String m = "myInfo:" + my_id;
           
           BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
           
           pw.println(m);
           pw.flush();
           String information = br.readLine();
           
           System.out.println(information);
           
           mypage_id.setText(my_id);
//   			mypage_name.setText(information[0]);
//   			mypage_phone.setText(information[1]);
          
        } catch (IOException e1) {
           e1.printStackTrace();
        }
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Socket socket = MyInfo.socket;
		
        try {
           String m = "myInfo:" + my_id;
           
           BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
           
           pw.println(m);
           pw.flush();
           String[] information = br.readLine().split(":");
           System.out.println(information);
           
           mypage_id.setText(my_id);
   			mypage_name.setText(information[0]);
   			mypage_phone.setText(information[1]);
          
        } catch (IOException e1) {
           e1.printStackTrace();
        }
		
	}

	@FXML public void moveUserHome() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mypage_id.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/userMain.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void moveMyThings() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mypage_id.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myThings.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/myThings.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void moveYourThings() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mypage_id.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/yourThings.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/yourThings.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void myThingsmoveUserHome() {}

	@FXML public void yourThingsmoveMyPage() {}

	@FXML public void yourThingsmoveUserHome() {}

	@FXML public void myThingsmoveMyPage() {}

	@FXML public void mpMoveLike() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mpTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/like.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/like.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}
	
	
}
