package model;

import java.util.ArrayList;

import config.GlobalConfig;

public class Bottles{
    private ArrayList<Bottle> bottles = new ArrayList<Bottle>();

    public Bottles() {
        for (int i = 0; i < GlobalConfig.QUANTITY - 2; i++) {
            bottles.add(new Bottle());
        }

        bottles.add(new Bottle(true));
        bottles.add(new Bottle(true));
    }

    public ArrayList<Bottle> getBottles() {
        return this.bottles;
    }

    public void setBottles(ArrayList<Bottle> bottles) {
        this.bottles = bottles;
    }
}
