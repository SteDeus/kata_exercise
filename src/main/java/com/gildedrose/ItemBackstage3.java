package com.gildedrose;

public class ItemBackstage3 extends Item3 {
    public ItemBackstage3(String name, int sellIn, int quality, int price) {
        super(name, sellIn, quality, price);
    }

    public ItemBackstage3(String name, int sellIn, int quality) {
        this(name, sellIn, quality, 100);
    }

    @Override
    public int getQualityDifference() {
        int difference = 1;
        if (this.sellIn <= 0) {
            difference = -this.quality;
        } else if (this.sellIn <= 5) {
            difference *= 3;
        } else if (this.sellIn <= 10) {
            difference *= 2;
        }
        return difference;
    }

    @Override
    public int getPriceDifference() {
        if (this.sellIn <= 0) {
            return 2 - this.price;
        }
        return 20;
    }

}
