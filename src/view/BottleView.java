package view;

import model.Bottles;
import model.Color;

import java.io.IOException;
import java.util.Scanner;

import config.GlobalConfig;

public class BottleView {
    public void gameRules() throws IOException {
        //Runtime.getRuntime().exec("cls");
        System.out.println();
    }

    public int[] getSelected(Bottles model) {
        System.out.println("Selecione a primeira garrafa:");
        int b1 = captureInputs();

        //validar se esta vazia (!model.getBottles().get(selected).getIsEmpty())
        //validar se ela ja não esta completa de uma cor

        System.out.println("Selecione a segunda garrafa:");
        int b2 = captureInputs();

        //validar se não é a b1
        //validar se ela não ta cheia
        //validar se ela tem a cor de cima certa

        int[] selected = new int[2];
        selected[0] = b1;
        selected[1] = b2;

        return selected;
    }

    private int captureInputs() {
        Scanner scanner = new Scanner(System.in);
        int selected;

        do {
            selected = (int) (scanner.nextInt() - 1);

            if (selected >= 0) {
                if (selected < GlobalConfig.QUANTITY) {
                    return selected;
                }
            }
        } while (true);
    }

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
            if (i < 9) System.out.print(" ");
        }

        System.out.println("\n");
    }
}
