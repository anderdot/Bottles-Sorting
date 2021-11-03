package model;

import config.GlobalConfig;

public class Bottle {
    private Color[] contents;
    private Color topColor;
    private int topIndex;
    private boolean isEmpty;
    private boolean isFull;
    private boolean isFullWithSameColor;

    public Bottle() {
        this.contents = new Color[GlobalConfig.VOLUME];
        this.isFullWithSameColor = false;
        this.isEmpty = false;
    }

    public Bottle(boolean isEmpty) {
        this.contents = new Color[GlobalConfig.VOLUME];
        this.isFullWithSameColor = false;
        this.isEmpty = isEmpty;
    }

    public Color[] getContents() {
        return this.contents;
    }

    public boolean pushColor(Color color) {
        if (!isFullWithSameColor) {
            if (!isFull) {
                return checkBellow(this.topIndex, color);
            }
        }

        return false;
    }

    public boolean checkBellow(int i, Color color) {
        if (this.isEmpty) {
            contents[GlobalConfig.VOLUME - 1] = color;
            this.topColor = color;
            this.topIndex = GlobalConfig.VOLUME - 1;
            this.isEmpty = false;
            return true;
        } else {
            if (contents[i] == Color.RESET) {
                if (i < GlobalConfig.VOLUME) {
                    return checkBellow(++i, color);
                } else {
                    return false;
                }
            } else {
                if (contents[i] == color) {
                    // while (contents[i] == color) {
                        contents[(i - 1)] = color;
                        topColor = color;
                        i--;
                        if (i == 0) {
                            this.isFull = true;
                            isFullWithSameColor = checkIfIsFullWithSameColor();
                        }
                        topIndex = i;
                    // }
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean popColor() {
        if (isEmpty) {
            return false;
        } else {
            this.contents[this.topIndex] = Color.RESET;
            if (topIndex == GlobalConfig.VOLUME - 1) {
                this.topColor = Color.RESET;
                this.isEmpty = true;
                return true;
            } else {
                this.topIndex++;
                this.topColor = contents[this.topIndex];
                this.isFull = false;
                this.isFullWithSameColor = false;
                return true;
            }
        }
    }

    private boolean checkIfIsFullWithSameColor() {
        for (Color color : contents) {
            if (color != topColor) {
                return false;
            }
        }

        return true;
    }

    public void setContents(Color[] contents) {
        this.contents = contents;
    }

    public Color getTopColor() {
        return this.topColor;
    }

    public void setTopColor(Color topColor) {
        this.topColor = topColor;
    }

    public int getTopIndex() {
        return this.topIndex;
    }

    public void setTopIndex(int topIndex) {
        this.topIndex = topIndex;
    }

    public boolean getIsFullWithSameColor() {
        return this.isFullWithSameColor;
    }

    public void setIsFullWithSameColor(boolean isFullWithSameColor) {
        this.isFullWithSameColor = isFullWithSameColor;
    }

    public boolean getIsEmpty() {
        return this.isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean getIsFull() {
        return this.isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }
}
