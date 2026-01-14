package com.gildedrose;

public class Item2 {

    public String name;

    public int sellIn;

    public int quality;

    public Item2(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public int getQualityDifference() {
        int difference = -1;
        if (this.sellIn <= 0) {
            difference --;
        }
        return difference;
    }

    public int getSellInDifference() {
        return -1;
    }

    public void updateQualityAndQuantity() {

        this.quality += this.getQualityDifference();
        if (this.quality > 50) {
            this.quality = 50;
        }
        if (this.quality < 0) {
            this.quality = 0;
        }

        this.sellIn += getSellInDifference();
        if (this.sellIn < 0) {
            this.sellIn = -1;
        }

    }
}
