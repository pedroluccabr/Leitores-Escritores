
/** ******.********************************************************
 * Autor...........: Pedro Lucca Silva Martins
 * Matricula........: 202210183
 * Inicio...........: 05/10/2023
 * Ultima alteracao.: 14/10/2023
 * Nome.............: Leitores e escritores
 * Funcao...........: Controlador da GUI
 *************************************************************** */
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class FXMLController implements Initializable {

  @FXML
  private ImageView leitor1;
  @FXML
  private ImageView leitor2;
  @FXML
  private ImageView leitor3;
  @FXML
  private ImageView leitor4;
  @FXML
  private ImageView leitor5;
  @FXML
  private ImageView escritor1;
  @FXML
  private ImageView escritor2;
  @FXML
  private ImageView escritor3;
  @FXML
  private ImageView escritor4;
  @FXML
  private ImageView escritor5;
  @FXML
  private Button reset;
  @FXML
  private Button pauseLeitor1;
  @FXML
  private Button pauseLeitor2;
  @FXML
  private Button pauseLeitor3;
  @FXML
  private Button pauseLeitor4;
  @FXML
  private Button pauseLeitor5;
  @FXML
  private Button retomaLeitor1;
  @FXML
  private Button retomaLeitor2;
  @FXML
  private Button retomaLeitor3;
  @FXML
  private Button retomaLeitor4;
  @FXML
  private Button retomaLeitor5;
  @FXML
  private Button pauseEscritor1;
  @FXML
  private Button pauseEscritor2;
  @FXML
  private Button pauseEscritor3;
  @FXML
  private Button pauseEscritor4;
  @FXML
  private Button pauseEscritor5;
  @FXML
  private Button retomaEscritor1;
  @FXML
  private Button retomaEscritor2;
  @FXML
  private Button retomaEscritor3;
  @FXML
  private Button retomaEscritor4;
  @FXML
  private Button retomaEscritor5;
  @FXML
  private Slider sliderLeitor1Utiliza;
  @FXML
  private Slider sliderLeitor2Utiliza;
  @FXML
  private Slider sliderLeitor3Utiliza;
  @FXML
  private Slider sliderLeitor4Utiliza;
  @FXML
  private Slider sliderLeitor5Utiliza;
  @FXML
  private Slider sliderLeitor1Le;
  @FXML
  private Slider sliderLeitor2Le;
  @FXML
  private Slider sliderLeitor3Le;
  @FXML
  private Slider sliderLeitor4Le;
  @FXML
  private Slider sliderLeitor5Le;
  @FXML
  private Slider sliderEscritor1Obtem;
  @FXML
  private Slider sliderEscritor2Obtem;
  @FXML
  private Slider sliderEscritor3Obtem;
  @FXML
  private Slider sliderEscritor4Obtem;
  @FXML
  private Slider sliderEscritor5Obtem;
  @FXML
  private Slider sliderEscritor1Escreve;
  @FXML
  private Slider sliderEscritor2Escreve;
  @FXML
  private Slider sliderEscritor3Escreve;
  @FXML
  private Slider sliderEscritor4Escreve;
  @FXML
  private Slider sliderEscritor5Escreve;
  @FXML
  private ImageView lampada1;
  @FXML
  private ImageView lampada2;
  @FXML
  private ImageView lampada3;
  @FXML
  private ImageView lampada4;
  @FXML
  private ImageView lampada5;
  @FXML
  private ImageView livroLendo1;
  @FXML
  private ImageView livroLendo2;
  @FXML
  private ImageView livroLendo3;
  @FXML
  private ImageView livroLendo4;
  @FXML
  private ImageView livroLendo5;
  @FXML
  private ImageView livroEscrevendo1;
  @FXML
  private ImageView livroEscrevendo2;
  @FXML
  private ImageView livroEscrevendo3;
  @FXML
  private ImageView livroEscrevendo4;
  @FXML
  private ImageView livroEscrevendo5;
  @FXML
  private Button buttonContinuar;
  @FXML
  private ImageView tutorial;

  private Leitor leitor6;
  private Leitor leitor7;
  private Leitor leitor8;
  private Leitor leitor9;
  private Leitor leitor0;

  private Escritor escritor6;
  private Escritor escritor7;
  private Escritor escritor8;
  private Escritor escritor9;
  private Escritor escritor0;

  public static Semaphore mutex = new Semaphore(1);
  public static Semaphore db = new Semaphore(1);
  public static volatile int rc = 0;

  @FXML
  private void handleButtonAction(ActionEvent event) {
    System.out.println("Iniciou");

    leitor6 = new Leitor(leitor1, livroLendo1, 0, this);
    leitor7 = new Leitor(leitor2, livroLendo2, 1, this);
    leitor8 = new Leitor(leitor3, livroLendo3, 2, this);
    leitor9 = new Leitor(leitor4, livroLendo4, 3, this);
    leitor0 = new Leitor(leitor5, livroLendo5, 4, this);

    escritor6 = new Escritor(escritor1, lampada1, livroEscrevendo1, 0, this);
    escritor7 = new Escritor(escritor2, lampada2, livroEscrevendo2, 1, this);
    escritor8 = new Escritor(escritor3, lampada3, livroEscrevendo3, 2, this);
    escritor9 = new Escritor(escritor4, lampada4, livroEscrevendo4, 3, this);
    escritor0 = new Escritor(escritor5, lampada5, livroEscrevendo5, 4, this);

    if (leitor6 != null && !leitor6.isAlive()) {
      leitor6.start();
    }
    if (leitor7 != null && !leitor7.isAlive()) {
      leitor7.start();
    }
    if (leitor8 != null && !leitor8.isAlive()) {
      leitor8.start();
    }
    if (leitor9 != null && !leitor9.isAlive()) {
      leitor9.start();
    }
    if (leitor0 != null && !leitor0.isAlive()) {
      leitor0.start();
    }

    if (escritor6 != null && !escritor6.isAlive()) {
      escritor6.start();
    }
    if (escritor7 != null && !escritor7.isAlive()) {
      escritor7.start();
    }
    if (escritor8 != null && !escritor8.isAlive()) {
      escritor8.start();
    }
    if (escritor9 != null && !escritor9.isAlive()) {
      escritor9.start();
    }
    if (escritor0 != null && !escritor0.isAlive()) {
      escritor0.start();
    }
  }

  @FXML
  private void handleButtonActionReset(ActionEvent event) {
    System.out.println("resetado");

    if (leitor6 != null) {
      leitor6.pararThreads();
      leitor7.pararThreads();
      leitor8.pararThreads();
      leitor9.pararThreads();
      leitor0.pararThreads();
      try {
        leitor6.join();
        leitor7.join();
        leitor8.join();
        leitor9.join();
        leitor0.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      leitor6.interrupt();
      leitor7.interrupt();
      leitor8.interrupt();
      leitor9.interrupt();
      leitor0.interrupt();
    } else if (leitor6 != null) {
      leitor6.reiniciarInterrompido1();
      leitor7.reiniciarInterrompido1();
      leitor8.reiniciarInterrompido1();
      leitor9.reiniciarInterrompido1();
      leitor0.reiniciarInterrompido1();
    }

    /*if(leitor6 != null){
      sliderLeitor1.setValue(0);
      leitor6.interrupt();
    }
    if(leitor7 != null){
      sliderLeitor2.setValue(0);
      leitor7.interrupt();
    }
    if(leitor8 != null){
      sliderLeitor3.setValue(0);
      leitor8.interrupt();
    }
    if(leitor9 != null){
      sliderLeitor4.setValue(0);
      leitor9.interrupt();
    }
    if(leitor0 != null){
      sliderLeitor5.setValue(0);
      leitor0.interrupt();
    }
    
    if(escritor6 != null){
      sliderEscritor1.setValue(0);
      escritor6.interrupt();
    }
    if(escritor7 != null){
      sliderEscritor2.setValue(0);
      escritor7.interrupt();
    }
    if(escritor8 != null){
      sliderEscritor3.setValue(0);
      escritor8.interrupt();
    }
    if(escritor9 != null){
      sliderEscritor4.setValue(0);
      escritor9.interrupt();
    }
    if(escritor0 != null){
      sliderEscritor5.setValue(0);
      escritor0.interrupt();
    }*/
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

    lampada1.setVisible(false);
    lampada2.setVisible(false);
    lampada3.setVisible(false);
    lampada4.setVisible(false);
    lampada5.setVisible(false);
    livroLendo1.setVisible(false);
    livroLendo2.setVisible(false);
    livroLendo3.setVisible(false);
    livroLendo4.setVisible(false);
    livroLendo5.setVisible(false);
    livroEscrevendo1.setVisible(false);
    livroEscrevendo2.setVisible(false);
    livroEscrevendo3.setVisible(false);
    livroEscrevendo4.setVisible(false);
    livroEscrevendo5.setVisible(false);

    sliderLeitor1Utiliza.setValue(1);
    sliderLeitor2Utiliza.setValue(1);
    sliderLeitor3Utiliza.setValue(1);
    sliderLeitor4Utiliza.setValue(1);
    sliderLeitor5Utiliza.setValue(1);
    sliderLeitor1Le.setValue(1);
    sliderLeitor2Le.setValue(1);
    sliderLeitor3Le.setValue(1);
    sliderLeitor4Le.setValue(1);
    sliderLeitor5Le.setValue(1);
    sliderEscritor1Obtem.setValue(1);
    sliderEscritor2Obtem.setValue(1);
    sliderEscritor3Obtem.setValue(1);
    sliderEscritor4Obtem.setValue(1);
    sliderEscritor5Obtem.setValue(1);
    sliderEscritor1Escreve.setValue(1);
    sliderEscritor2Escreve.setValue(1);
    sliderEscritor3Escreve.setValue(1);
    sliderEscritor4Escreve.setValue(1);
    sliderEscritor5Escreve.setValue(1);
  }

  public void pauseLeitor1(ActionEvent event) {
    if (leitor6 != null) {
      leitor6.pausar();
    }
  }

  public void pauseLeitor2(ActionEvent event) {
    if (leitor7 != null) {
      leitor7.pausar();
    }
  }

  public void pauseLeitor3(ActionEvent event) {
    if (leitor8 != null) {
      leitor8.pausar();
    }
  }

  public void pauseLeitor4(ActionEvent event) {
    if (leitor9 != null) {
      leitor9.pausar();
    }
  }

  public void pauseLeitor5(ActionEvent event) {
    if (leitor0 != null) {
      leitor0.pausar();
    }
  }

  public void retomaLeitor1(ActionEvent event) {
    if (leitor6 != null) {
      leitor6.retomar();
    }
  }

  public void retomaLeitor2(ActionEvent event) {
    if (leitor7 != null) {
      leitor7.retomar();
    }
  }

  public void retomaLeitor3(ActionEvent event) {
    if (leitor8 != null) {
      leitor8.retomar();
    }
  }

  public void retomaLeitor4(ActionEvent event) {
    if (leitor9 != null) {
      leitor9.retomar();
    }
  }

  public void retomaLeitor5(ActionEvent event) {
    if (leitor0 != null) {
      leitor0.retomar();
    }
  }

  public void pauseEscritor1(ActionEvent event) {
    if (escritor6 != null) {
      escritor6.pausar();
    }
  }

  public void pauseEscritor2(ActionEvent event) {
    if (escritor7 != null) {
      escritor7.pausar();
    }
  }

  public void pauseEscritor3(ActionEvent event) {
    if (escritor8 != null) {
      escritor8.pausar();
    }
  }

  public void pauseEscritor4(ActionEvent event) {
    if (escritor9 != null) {
      escritor9.pausar();
    }
  }

  public void pauseEscritor5(ActionEvent event) {
    if (escritor0 != null) {
      escritor0.pausar();
    }
  }

  public void retomaEscritor1(ActionEvent event) {
    if (escritor6 != null) {
      escritor6.retomar();
    }
  }

  public void retomaEscritor2(ActionEvent event) {
    if (escritor7 != null) {
      escritor7.retomar();
    }
  }

  public void retomaEscritor3(ActionEvent event) {
    if (escritor8 != null) {
      escritor8.retomar();
    }
  }

  public void retomaEscritor4(ActionEvent event) {
    if (escritor9 != null) {
      escritor9.retomar();
    }
  }

  public void retomaEscritor5(ActionEvent event) {
    if (escritor0 != null) {
      escritor0.retomar();
    }
  }

  public double getValorUtilizar(int id) {
    switch (id) {
      case 0:
        return sliderLeitor1Utiliza.getValue();
      case 1:
        return sliderLeitor2Utiliza.getValue();
      case 2:
        return sliderLeitor3Utiliza.getValue();
      case 3:
        return sliderLeitor4Utiliza.getValue();
      case 4:
        return sliderLeitor5Utiliza.getValue();
    }
    return 0;
  }

  public double getValorLe(int id) {
    switch (id) {
      case 0:
        return sliderLeitor1Le.getValue();
      case 1:
        return sliderLeitor2Le.getValue();
      case 2:
        return sliderLeitor3Le.getValue();
      case 3:
        return sliderLeitor4Le.getValue();
      case 4:
        return sliderLeitor5Le.getValue();
    }
    return 0;
  }

  public double getValorObtem(int id) {
    switch (id) {
      case 0:
        return sliderEscritor1Obtem.getValue();
      case 1:
        return sliderEscritor2Obtem.getValue();
      case 2:
        return sliderEscritor3Obtem.getValue();
      case 3:
        return sliderEscritor4Obtem.getValue();
      case 4:
        return sliderEscritor5Obtem.getValue();
    }
    return 0;
  }

  public double getValorEscreve(int id) {
    switch (id) {
      case 0:
        return sliderEscritor1Escreve.getValue();
      case 1:
        return sliderEscritor2Escreve.getValue();
      case 2:
        return sliderEscritor3Escreve.getValue();
      case 3:
        return sliderEscritor4Escreve.getValue();
      case 4:
        return sliderEscritor5Escreve.getValue();
    }
    return 0;
  }

  public void buttonContinuar(ActionEvent Event) {
    buttonContinuar.setVisible(false);
    tutorial.setVisible(false);
    reset.setDisable(true);
  }

}
