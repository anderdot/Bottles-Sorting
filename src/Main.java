import model.Bottles;
import view.BottleView;
import controller.BottleController;

public class Main {
    public static void main(String[] args) throws Exception {
        Bottles model = new Bottles();
        BottleView view = new BottleView();
        BottleController controller = new BottleController(model, view);
        controller.run();
    }
}
