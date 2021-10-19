package model;

import config.Color;
import config.GlobalConfig;

public class Bottle {
    private Color[] contents;
    private boolean isFullWithSameColor;
    private boolean isEmpty;

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

    public void setContents(Color[] contents) {
        this.contents = contents;
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
}
