package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import config.GlobalConfig;

public class Bottles {
    private ArrayList<Bottle> bottles = new ArrayList<Bottle>();

    public Bottles() {
        for (int i = 0; i < GlobalConfig.QUANTITY - 2; i++) {
            bottles.add(new Bottle());
        }

        bottles.add(new Bottle(true));
        bottles.add(new Bottle(true));
    }

    private LinkedList<Color> shuffleColors() {
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
        LinkedList<Color> randomColors = shuffleColors();
        for (Bottle bottle : getBottles()) {
            Color[] contents = bottle.getContents();
            for (int i = 0; i < GlobalConfig.VOLUME; i++) {
                if (!bottle.getIsEmpty()) {
                    contents[i] = randomColors.getFirst();
                    if (i == 0) {
                        bottle.setTopColor(randomColors.getFirst());
                        bottle.setTopIndex(i);
                        bottle.setIsFull(true);
                        bottle.setIsEmpty(false);
                    }

                    randomColors.removeFirst();
                }
                else
                {
                    for (int j = 0; j < GlobalConfig.VOLUME; j++) {
                        contents[i] = Color.RESET;
                        bottle.setTopColor(Color.RESET);
                        bottle.setTopIndex(j);
                        bottle.setIsFull(false);
                        bottle.setIsEmpty(true);
                    }
                }
            }
        }
    }

    public ArrayList<Bottle> getBottles() {
        return this.bottles;
    }

    public void setBottles(ArrayList<Bottle> bottles) {
        this.bottles = bottles;
    }

    public void transferColor(int from, int to) {
        if (this.bottles.get(to).pushColor(this.bottles.get(from).getTopColor())) {
            bottles.get(from).popColor();
        }
    }
}
