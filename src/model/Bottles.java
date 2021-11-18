package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import config.GlobalConfig;

public class Bottles {
    private ArrayList<Bottle> bottles = new ArrayList<Bottle>();

    public Bottles() {
        for (int i = 0; i < GlobalConfig.QUANTITY; i++) {
            bottles.add(new Bottle());
        }
    }

    private LinkedList<Color> shuffledColors() {
        LinkedList<Color> color = new LinkedList<Color>();
        LinkedList<Color> noRepeat = new LinkedList<Color>();
        int quantity = GlobalConfig.VOLUME * (GlobalConfig.QUANTITY - 2);
        
        for (int i = 0; i < quantity; i += GlobalConfig.VOLUME) {
            if (noRepeat.isEmpty()) {
                 noRepeat = Color.colors();
                 Collections.shuffle(noRepeat);
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
        LinkedList<Color> randomColors = shuffledColors();
        for (int i = 0; i < GlobalConfig.QUANTITY; i++) {
            for (int j = 0; j < GlobalConfig.VOLUME; j++) {
                if (i >= GlobalConfig.QUANTITY - 2) {
                    bottles.get(i).pushColor(Color.RESET);
                } else {
                    bottles.get(i).pushColor(randomColors.getFirst());
                    randomColors.removeFirst();
                }
            }

            if (i >= GlobalConfig.QUANTITY - 2) {
                bottles.get(i).setTopIndex(-1);
            }
        }
    }

    public ArrayList<Bottle> getBottles() {
        return bottles;
    }

    public void setBottles(ArrayList<Bottle> bottles) {
        this.bottles = bottles;
    }

    public void transferColor(int from, int to) {
        Color topColor = bottles.get(from).getTopColor();
        while (bottles.get(from).getTopColor() == topColor) {


            //VERIFICAR TUDO ANTES

            if (bottles.get(to).isFull()) {
                break;
            } else {
                if (bottles.get(to).pushColor(this.bottles.get(from).getTopColor())) {
                    bottles.get(from).popColor();
                }
            }
        }
    }
}
