package controller;

import model.Bottle;
import model.Bottles;
import model.Color;

import view.BottleView;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import config.GlobalConfig;

public class BottleController {
    private Bottles model;
    private BottleView view;

    public BottleController(Bottles model, BottleView view) {
        this.model = model;
        this.view = view;
    }

    public void run() throws IOException {
        view.gameRules();
        startGame();
    }

    private void startGame() {
        FillBottles();
        refresh();
        int inputs[] =  getInputs();
        System.out.println(inputs[0] + " : " + inputs[1]);
    }

    private int[] getInputs() {
        return view.getSelected(model);
    }

    private void refresh() {
        view.printBottles(model);
    }

    private LinkedList<Color> shuffleColors() {
        LinkedList<Color> color = new LinkedList<Color>();
        LinkedList<Color> noRepeat = new LinkedList<Color>();
        int quantity = GlobalConfig.VOLUME * (GlobalConfig.QUANTITY - 2);
        
        for (int i = 0; i < quantity; i += GlobalConfig.VOLUME) {
            if (noRepeat.isEmpty()) {
                 noRepeat = Color.colors();
            }
            
            for (int j = 0; j < GlobalConfig.VOLUME; j++) {
                color.add(noRepeat.getFirst());
            }

            noRepeat.removeFirst();
        }

        Collections.shuffle(color);
        return color;
    }

    public void FillBottles() {
        LinkedList<Color> randomColors = shuffleColors();
        for (Bottle bottle : model.getBottles()) {
            Color[] contents = bottle.getContents();
            for (int i = 0; i < GlobalConfig.VOLUME; i++) {
                if (!bottle.getIsEmpty()) {
                    contents[i] = randomColors.getFirst();
                    randomColors.removeFirst();
                }
                else
                {
                    for (int j = 0; j < GlobalConfig.VOLUME; j++) {
                        contents[i] = Color.RESET;
                    }
                }
            }
        }
    }
}
