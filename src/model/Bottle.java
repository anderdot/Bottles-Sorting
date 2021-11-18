package model;

import config.GlobalConfig;

public class Bottle {
    private Color[] contents;
    private int topIndex;

    public Bottle() {
        contents = new Color[GlobalConfig.VOLUME];
        topIndex = -1;
    }

    public boolean pushColor(Color color) {
        if (isFullWithSameColor()) return false;
        if (isFull()) return false;
        
        //if (getTopColor() == color) {
            topIndex++;
            contents[topIndex] = color;

            return true;
        //}
        
        //return false;
    }

    public boolean popColor() {
        if (isEmpty()) return false;
        
        contents[topIndex] = Color.RESET;
        topIndex--;

        return true;
    }

    private boolean isFullWithSameColor() {
        if (isFull()) {
            for (Color color : contents) {
                if (color != getTopColor()) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public Color getTopColor() {
        return isEmpty() ? Color.RESET : contents[topIndex];
    }

    public int getTopIndex() {
        return topIndex;
    }

    public void setTopIndex(int topIndex) {
        this.topIndex = topIndex;
    }

    public boolean isEmpty() {
        return topIndex == -1 ? true : false;
    }

    public boolean isFull() {
        return topIndex == GlobalConfig.VOLUME - 1 ? true : false;
    }

    public Color[] getContents() {
        return contents;
    }

    
}
