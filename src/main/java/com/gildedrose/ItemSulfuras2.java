package com.gildedrose;

public class ItemSulfuras2 extends Item2 {
    public ItemSulfuras2(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public int getQualityDifference() {
        return 0;
    }

    @Override
    public int getSellInDifference() {
        return 0;
    }

    @Override
    public void updateQualityAndQuantity() {}
}
