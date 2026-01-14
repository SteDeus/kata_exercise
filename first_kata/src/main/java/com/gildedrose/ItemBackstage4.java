package com.gildedrose;

public class ItemBackstage4 extends Item4 implements PercentageDiscount4 {
    public ItemBackstage4(String name, int sellIn, int quality, int price) {
        super(name, sellIn, quality, price);
    }

    public ItemBackstage4(String name, int sellIn, int quality) {
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

    @Override
    public double getDiscountedPrice() {
        return getPercentageDiscount(this.price);
    }

}
