
/** ******.********************************************************
 * Autor...........: Pedro Lucca Silva Martins
 * Matricula........: 202210183
 * Inicio...........: 05/10/2023
 * Ultima alteracao.: 14/10/2023
 * Nome.............: Leitores e escritores
 * Funcao...........: Classe de escritores
 *************************************************************** */
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import java.util.concurrent.Semaphore;

public class Escritor extends Thread {

  private ImageView image;
  private ImageView lampada;
  private ImageView livro;
  private volatile boolean pausado = false;
  private volatile boolean interrompido1 = false;
  private FXMLController controller;
  private Semaphore semaforo;
  private volatile int id;

  public Escritor(ImageView image, ImageView lampada, ImageView livro, int id, FXMLController controller) {
    this.image = image;
    this.lampada = lampada;
    this.livro = livro;
    this.id = id;
    this.controller = controller;
  }

  public void run() {
    while (true) {
      movimentacaoObtem();
      try {
        FXMLController.db.acquire();
      } catch (InterruptedException ex) {

      }
      escreveBaseDeDados();
      FXMLController.db.release();
    }
  }

  public void escreveBaseDeDados() {
    System.out.println(this.image + "Escrevendo");

    movimentacaoEscreve();

  }

  private void movimentacaoEscreve() {
    while (image != null && image.getLayoutX() > 550) {
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
          image.setLayoutX(608);
          livro.setVisible(true);
        });
        Thread.sleep(((long) controller.getValorEscreve(id) * 1000));
        Platform.runLater(() -> {
          image.setLayoutX(715);
          livro.setVisible(false);
        });
        break;
      } catch (InterruptedException ex) {

      }
    }
  }

  private void movimentacaoObtem() {
    Platform.runLater(() -> {
      System.out.println("entrou no lampada");
          lampada.setVisible(true);
        });
    while (image != null && image.getLayoutX() > 550) {
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
        
        Thread.sleep(((long) controller.getValorObtem(id) * 1000));
        Platform.runLater(() -> {
          lampada.setVisible(false);
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
        image.setLayoutX(765);
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
