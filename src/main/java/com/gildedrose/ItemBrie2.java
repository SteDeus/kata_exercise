package com.gildedrose;

public class ItemBrie2 extends Item2 {
    public ItemBrie2(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public int getQualityDifference() {
        return super.getQualityDifference() * -1;
    }

}
