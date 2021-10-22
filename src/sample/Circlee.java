package sample;
import javafx.scene.Cursor;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circlee extends Figur {
    private Circle circle;
    private boolean cirSetForan = true;
    private TextField text;

    //Lager en default Circle uten parameter verdier
    public Circlee() {}

    //Circle konstruktør med spesifiserte verdier fra brukeren
    public Circlee(double x, double y ) {
        circle = new Circle(x,y,50);
        circle.setFill(Color.RED);
        setX(x);
        setY(y);
    }
    //boolean verdi for figurer som overlapper hverandre
    public boolean isCirSetForan() {
        return cirSetForan;
    }

    //Her så opprettes circle ved hjelp av brukerens mus tastetrykk.
    //MOUSE_DRAGGED tilbyr en fleksibel valg av størrelse for sirkelen. Størrelsen blir basert på
    //start possisjon og slutt possisjon til MouseButton.SECONDARY
    //MouseButton.PRIMARY velger hvor sirkelen starter fra basert på X ogY coordinater(ev.getX(), ev.getY())
    public Circle getCreate() {
        circle.setCursor(Cursor.HAND);
        circle.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
            if (ev.getButton() == MouseButton.PRIMARY) {
                circle.setCenterX(ev.getX());
                circle.setCenterY(ev.getY());
            } else if (ev.getButton() == MouseButton.SECONDARY) {
                circle.setRadius(ev.getY());
            }
        });
        circle.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
            if(isCirSetForan()){
                circle.toFront();
            }
        });
        return circle;
    }

   //Skisse av våres orginale kode
  /* public Circle create(){
       circle.setCursor(Cursor.HAND);
      circle.setOnMouseDragged(event ->{
         circle.setCenterX(event.getX());
         circle.setCenterY(event.getY());
      });
   }

   */
 /*circle.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
      @Override
      public void handle(MouseEvent e) {
         if(e.getButton() == MouseButton.SECONDARY){
            circle.setOnMouseDragged(e->{
               circle.setRadius(circle.getRadius event.getY());
            });
         }
      }
   });

  */


}
