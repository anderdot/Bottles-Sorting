package view;

import model.Bottles;

import config.Color;
import config.GlobalConfig;

public class BottleView {
    public void printBottles(Bottles bottles) {
        for (int i = 0; i < GlobalConfig.QUANTITY; i++) {
            System.out.print(" ▃▃     ▃▃");
        }

        System.out.println();
        String leftBottle = Color.RESET + "  " + Color.WHITE + " ";
        String rightBottle = Color.WHITE + " " + Color.RESET + " ";
        for (int i = 0; i < GlobalConfig.VOLUME; i++) {
            for (int j = 0; j < GlobalConfig.QUANTITY; j++) {
                Color[] contents = bottles.getBottles().get(j).getContents();
                System.out.print(leftBottle + contents[i].toString() + "     " + rightBottle);
            }

            System.out.println();
        }

        for (int i = 0; i < GlobalConfig.QUANTITY; i++) {
            System.out.print("  ▀▀▀▀▀▀▀ ");
        }

        System.out.println();
        for (int i = 0; i < GlobalConfig.QUANTITY; i++) {
            System.out.print("    ["+ (i + 1) + "]  ");
            if ((i + 1) <= 9) System.out.print(" ");
        }

        System.out.println("\n");
    }
}
