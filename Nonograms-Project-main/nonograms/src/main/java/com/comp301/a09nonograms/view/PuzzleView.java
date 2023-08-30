package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PuzzleView implements FXComponent {
  private Controller controller;

  public PuzzleView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane pane = new GridPane();
    for (int i = 1; i < controller.getClues().getHeight() + 1; i++) {
      int[] temp = controller.getClues().getRowClues(i - 1);
      HBox rowClues = new HBox();
      rowClues.setAlignment(Pos.CENTER_RIGHT);
      for (int j : temp) {
        if (j != 0) {
          rowClues.getChildren().add(new Text(String.valueOf(j)));
          rowClues.getChildren().add(new Text(" "));
        }
      }
      pane.add(rowClues, 0, i);
    }
    for (int i = 1; i < controller.getClues().getWidth() + 1; i++) {
      int[] temp = controller.getClues().getColClues(i - 1);
      VBox colClues = new VBox();
      colClues.setAlignment(Pos.BOTTOM_CENTER);
      for (int j : temp) {
        if (j != 0) {
          colClues.getChildren().add(new Text(String.valueOf(j)));
        }
      }
      pane.add(colClues, i, 0);
    }
    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      for (int j = 0; j < controller.getClues().getWidth(); j++) {
        Button block = new Button();
        block.setPrefSize(40, 40);
        if (controller.isShaded(i, j)) {
          block.setStyle("-fx-background-color: black");
        } else if (controller.isEliminated(i, j)) {
          block.setStyle("-fx-background-color: red");
        } else {
          block.setStyle("-fx-background-color: white");
        }
        int finalI = i;
        int finalJ = j;
        block.setOnMouseClicked(
            (MouseEvent) -> {
              if (MouseEvent.getButton().equals(MouseButton.SECONDARY))
                controller.toggleEliminated(finalI, finalJ);
              else if (MouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                controller.toggleShaded(finalI, finalJ);
              }
            });
        pane.add(block, j + 1, i + 1);
      }
    }
    pane.setGridLinesVisible(true);
    pane.setAlignment(Pos.CENTER);
    return pane;
  }
}
