package com.gildedrose;

public class Item4 {

    public String name;

    public int sellIn;

    public int quality;

    public int price;

    public Item4(String name, int sellIn, int quality, int price) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.price = price;
    }

    public Item4(String name, int sellIn, int quality) {
        this(name, sellIn, quality, 1);
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

    public int getPriceDifference() {
        return 0;
    }

    public void updateAll() {

        this.quality += this.getQualityDifference();
        if (this.quality > 50) {
            this.quality = 50;
        }
        if (this.quality < 0) {
            this.quality = 0;
        }

        this.price += getPriceDifference();
        if (this.price < 0) {
            this.price = 0;
        }
        if (this.price > 100000) {
            this.price = 100000;
        }

        this.sellIn += getSellInDifference();
        if (this.sellIn < 0) {
            this.sellIn = -1;
        }



    }
}
