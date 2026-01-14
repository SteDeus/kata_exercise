package com.gildedrose;

public class ItemBrie3 extends Item3 {

    public Boolean increasePrice = true;

    public ItemBrie3(String name, int sellIn, int quality, int price) {
        super(name, sellIn, quality, price);
    }

    public ItemBrie3(String name, int sellIn, int quality) {
        super(name, sellIn, quality, 50);
    }

    @Override
    public int getPriceDifference() {
        this.increasePrice = !this.increasePrice;
        if (this.increasePrice) {
            return 5;
        }
        return 0;
    }

    @Override
    public int getQualityDifference() {
        return super.getQualityDifference() * -1;
    }

}
