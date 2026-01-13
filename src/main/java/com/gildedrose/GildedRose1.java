package com.gildedrose;

class GildedRose1 {
    Item2[] items;

    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String BRIE = "Aged Brie";
    private final String CONJURED = "Conjured Mana Cake";

    public GildedRose1(Item2[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item2 item : items) {

            if (item.name.equals(SULFURAS)) {
                continue;
            }

            final int degradation = getDegradation(item);

            item.quality = (item.quality < degradation) ? 0 : item.quality - degradation;
            if (item.quality > 50) {
                item.quality = 50;
            }
            item.sellIn = item.sellIn == -1 ? item.sellIn : item.sellIn - 1;

        }
    }

    private int getDegradation(Item2 item) {
        int degradation = 1;

        if (item.sellIn <= 0) {
            degradation *= 2;
        }

        if (item.name.equals(BRIE) || item.name.equals(BACKSTAGE_PASSES)) {
            degradation *= -1;
        }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.sellIn <= 0) {
                degradation = item.quality;
            } else if (item.sellIn <= 5) {
                degradation *= 3;
            } else if (item.sellIn <= 10) {
                degradation *= 2;
            }
        }

        if (item.name.equals(CONJURED)) {
            degradation *= 2;
        }
        return degradation;
    }
}
