package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


import java.util.ArrayList;

public class MainOblig extends Application {
    //Valg av farger og figurer deklarasjon
    //Label ved siden av ColorPicker beskriver valg av farger
    //ArrayList som plasserer alle figurene fra figur abstract klassen, inn i en Array(List)
    ColorPicker picker = new ColorPicker();
    Label lbl = new Label(" Velg Farge ");
    ArrayList<Figur> figures = new ArrayList<>();

    //Canvas
    private Pane pane;

    @Override
    public void start(Stage primaryStage) {
        pane = new Pane();
        //Lager radioknapper til hver figur
        RadioButton radioButton1 = new RadioButton("Rectangel");
        RadioButton radioButton2 = new RadioButton("Circle");
        RadioButton radioButton3 = new RadioButton("Linje");
        //ToggleGroup hindrer at brukeren velger flere figurer samtidig
        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);

        //Lager en HBox for å posisjoner nodene i riktig posisjon og avstand mellom hverandre
        HBox hbox = new HBox(lbl, picker, radioButton1, radioButton2, radioButton3);
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(25, 50, 50, 60));
        pane.getChildren().add(hbox);

        //Her oppretter Rectangell, Circlee og Linje objekter som blir plassert i canvasen
        pane.setOnMouseClicked(ev ->{
            if(ev.getButton().equals(MouseButton.MIDDLE)) {
                if (radioButton1.isSelected()) {
                    Figur figurRectangel = new Rectangell(100, 200, 100, 100);
                    Shape s = figurRectangel.getCreate();
                    pane.getChildren().add(s);
                    figures.add(figurRectangel);
                    s.setFill(picker.getValue());
                } else if (radioButton2.isSelected()) {
                    Figur figurCircle = new Circlee(100, 100);
                    Shape c = figurCircle.getCreate();
                    figures.add(figurCircle);
                    pane.getChildren().add(c);
                    c.setFill(picker.getValue());
                } else if (radioButton3.isSelected()) {
                    Figur figLinje = new Linje();
                    Shape linjeShape = figLinje.getCreate();
                    figures.add(figLinje);
                    pane.getChildren().add(linjeShape);

                }
            }
        });

        //Plasserer alle noder fra pane inn i scene og oppretter stage
        Scene scene = new Scene(pane,700,650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
