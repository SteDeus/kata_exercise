package com.gildedrose;

public interface PercentageDiscount4 {
    default double getPercentageDiscount(int price) {
        return price > 10 ? price * 0.7 : price;
    }
}
