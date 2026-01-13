package com.gildedrose;

public class ItemSulfuras3 extends Item3 {
    public ItemSulfuras3(String name, int sellIn, int quality) {
        super(name, sellIn, quality, 100000);
    }

    @Override
    public int getQualityDifference() {
        return 0;
    }

    @Override
    public int getSellInDifference() {
        return 0;
    }

    /**
     * I have to implement this because some property limits do not apply to Sulfuras
     */
    @Override
    public void updateAll() {
        if (this.quality < 0) {
            this.quality = 0;
        }
        if (this.price < 0) {
            this.price = 100000;
        }
        if (this.price < 100000) {
            this.price = 100000;
        }
        if (this.sellIn < 0) {
            this.sellIn = -1;
        }
    }
}
