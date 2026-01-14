package com.gildedrose;

public class ItemBackstage2 extends Item2 {
    public ItemBackstage2(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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

}
