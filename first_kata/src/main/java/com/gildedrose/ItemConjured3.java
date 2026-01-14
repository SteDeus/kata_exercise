package com.gildedrose;

public class ItemConjured3 extends Item3 {
    public ItemConjured3(String name, int sellIn, int quality, int price) {
        super(name, sellIn, quality, price);
    }

    public ItemConjured3(String name, int sellIn, int quality) {
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
