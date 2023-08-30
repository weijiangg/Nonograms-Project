package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class View implements FXComponent {
  private Controller controller;

  public View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();
    layout.setAlignment(Pos.CENTER);
    ControlView controlView = new ControlView(controller);
    layout.getChildren().add(controlView.render());
    PuzzleView puzzleView = new PuzzleView(controller);
    layout.getChildren().add(puzzleView.render());
    MessageView messageView = new MessageView(controller);
    layout.getChildren().add(messageView.render());
    Control2View control2View = new Control2View(controller);
    layout.getChildren().add(control2View.render());
    return layout;
  }
}
