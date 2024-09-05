/** ******.********************************************************
 * Autor...........: Pedro Lucca Silva Martins
 * Matricula........: 202210183
 * Inicio...........: 05/10/2023
 * Ultima alteracao.: 14/10/2023
 * Nome.............: Leitores e escritores
 * Funcao...........: Classe principal
 *************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
  
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    
    Scene scene = new Scene(root);
    
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
