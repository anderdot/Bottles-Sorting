package model;

import java.util.LinkedList;

public enum Color {
    RESET   ("\033[0m"),
    BLACK   ("\033[0;100m"), 
    RED     ("\033[0;101m"), 
    GREEN   ("\033[0;102m"), 
    YELLOW  ("\033[0;103m"), 
    PINK    ("\033[0;105m"),
    WHITE   ("\033[0;107m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public static LinkedList<Color> colors() {
        LinkedList<Color> color = new LinkedList<Color>();
        color.add(Color.BLACK);
        color.add(Color.RED);
        color.add(Color.GREEN);
        color.add(Color.YELLOW);
        color.add(Color.PINK);

        return color;
    }   

    @Override
    public String toString() {
        return code;
    }
}
