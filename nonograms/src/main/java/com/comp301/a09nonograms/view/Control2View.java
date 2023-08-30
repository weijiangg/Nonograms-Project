package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Control2View implements FXComponent {
  private Controller controller;

  public Control2View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox pane = new HBox();
    Button clearBtn = new Button();
    clearBtn.setText("Clear");
    Button randBtn = new Button();
    randBtn.setText("Random");
    clearBtn.setOnAction(
        (MouseEvent) -> {
          controller.clearBoard();
        });
    randBtn.setOnAction(
        (MouseEvent) -> {
          controller.randPuzzle();
        });
    pane.getChildren().add(clearBtn);
    pane.getChildren().add(randBtn);
    pane.setAlignment(Pos.CENTER);
    return pane;
  }
}
