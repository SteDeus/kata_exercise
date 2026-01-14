package com.gildedrose;

public class ItemConjured2 extends Item2 {
    public ItemConjured2(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public int getQualityDifference() {
        return super.getQualityDifference() * 2;
    }
}
