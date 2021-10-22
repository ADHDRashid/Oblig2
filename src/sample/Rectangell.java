package sample;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rectangell extends Figur {
    private Rectangle recta;
    private double musx;
    private  double musy;
    private boolean drar = false;
    private boolean setForan = true;

    //Rectangle r;

    //boolean verdi for figurer som overlapper hverandre
    public boolean isSetForan() {
        return setForan;
    }

    //Default Rectangle uten variabler
    public Rectangell() {}

    //Defualt Rectangle konstruktr som inneholder variabler for opprettelse av Rectangle
    //setX() og setY() er metoder hentet fra abstract figur klassen
    public Rectangell(double x,double y,double width,double height) {
        recta = new Rectangle(x,y,width,height);
        setX(x);
        setY(y);
    }

    //Overrider metoden getCreate() fra figurer abstract klassen, for å opprette rectangle
    //Samme ting skjer her som Circle figuren.
    //størrelsen blir basert fra start posisjon, til slutt posisjon til Mus knappen
    @Override
    public Shape getCreate(){
        recta.setCursor(Cursor.HAND);
        recta.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
            if (ev.getButton() == MouseButton.PRIMARY) {
                recta.setX(ev.getX());
                recta.setY(ev.getY());
            } else if (ev.getButton() == MouseButton.SECONDARY) {
                recta.setWidth(ev.getX());
                recta.setHeight(ev.getY());
            }
        });
        recta.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
            if(isSetForan()){
                recta.toFront();
            }
        });

        //returnerer rectangle for å opprettelse
        return recta;
    }




}
