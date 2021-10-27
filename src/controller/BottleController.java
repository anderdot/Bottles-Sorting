package controller;

import model.Bottles;
import view.BottleView;

public class BottleController {
    private Bottles model;
    private BottleView view;

    public BottleController(Bottles model, BottleView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.gameRules();
        startGame();
    }

    private void startGame() {
        model.FillBottles();
        refresh();
        do {
            int inputs[] =  getInputs();
            // System.out.println(inputs[0] + " : " + inputs[1]);
            model.transferColor(inputs[0], inputs[1]);
            refresh();
        } while (true);
       
        // model.getBottles().get(inputs[1]).stackUp(Color.RED);
    }

    private int[] getInputs() {
        return view.getSelected(model);
    }

    private void refresh() {
        view.printBottles(model);
    }
}
