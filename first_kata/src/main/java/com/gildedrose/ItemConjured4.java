package com.gildedrose;

public class ItemConjured4 extends Item4 {
    public ItemConjured4(String name, int sellIn, int quality, int price) {
        super(name, sellIn, quality, price);
    }

    public ItemConjured4(String name, int sellIn, int quality) {
        super(name, sellIn, quality, 400);
    }
    @Override
    public int getQualityDifference() {
        return super.getQualityDifference() * 2;
    }

    @Override
    public int getPriceDifference() {
        return 100;
    }
}
