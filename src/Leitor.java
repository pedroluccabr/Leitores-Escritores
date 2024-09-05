
/** ******.********************************************************
 * Autor...........: Pedro Lucca Silva Martins
 * Matricula........: 202210183
 * Inicio...........: 05/10/2023
 * Ultima alteracao.: 14/10/2023
 * Nome.............: Leitores e escritores
 * Funcao...........: Classe de leitores
 *************************************************************** */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Leitor extends Thread {

  private ImageView image;
  private ImageView livro;
  private volatile Boolean pausado = false;
  private volatile boolean interrompido1 = false;
  private FXMLController controller;
  private Semaphore semaforo;
  private volatile int id;

  public Leitor(ImageView image, ImageView livro, int id, FXMLController controller) {
    this.image = image;
    this.livro = livro;
    this.id = id;
    this.controller = controller;
  }

  public void run() {
    while (true) {
      try {
        FXMLController.mutex.acquire();
      } catch (InterruptedException ex) {

      }
      FXMLController.rc += 1;
      if (FXMLController.rc == 1) {
        try {
          FXMLController.db.acquire();
          System.out.println("cru");
        } catch (InterruptedException ex) {

        }
      }
      FXMLController.mutex.release();
      System.out.println("primeira");
      leBaseDeDados();
      try {
        FXMLController.mutex.acquire();
      } catch (InterruptedException ex) {

      }
      FXMLController.rc -= 1;
      if (FXMLController.rc == 0) {
        FXMLController.db.release();
      }
      FXMLController.mutex.release();
      utilizaDadoLido();
    }
  }

  public void leBaseDeDados() {
    System.out.println(this.image + "Lendo");
    while (image != null && image.getLayoutX() < 400) {
      if (interrompido1) {
        interromperJogo();
        break;
      }

      while (pausado) {
        System.out.println("");
        if (!pausado) {
          break;
        }
      }

      Platform.runLater(() -> {
        image.setLayoutX(342);
      });

      try {
        Thread.sleep(((long) controller.getValorLe(id) * 1000));
        Platform.runLater(() -> {
          image.setLayoutX(220);
        });
        break;
      } catch (InterruptedException ex) {

      }
    }
  }

  public void utilizaDadoLido() {
    System.out.println(this.image + "utilizando");

    while (image != null && image.getLayoutX() < 400) {
      if (interrompido1) {
        interromperJogo();
        break;
      }

      while (pausado) {
        System.out.println("");
        if (!pausado) {
          break;
        }
      }
      try {
        Platform.runLater(() -> {
          livro.setVisible(true);
        });
        Thread.sleep(((long) controller.getValorUtilizar(id) * 1000));
        Platform.runLater(() -> {
          livro.setVisible(false);
        });
        break;
      } catch (InterruptedException ex) {

      }
    }
  }

  public void pausar() {
    pausado = true;
  }

  public void retomar() {
    pausado = false;
  }

  public void interromperJogo() {
    if (interrompido1) {
      Platform.runLater(() -> {
        image.setLayoutX(180);
      });
    }
  }

  public void pararThreads() {
    interrompido1 = true;
  }

  public void reiniciarInterrompido1() {
    interrompido1 = false;
  }
}
