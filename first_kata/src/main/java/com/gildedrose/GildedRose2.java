package com.gildedrose;

class GildedRose2 {
    Item2[] items;

    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String BRIE = "Aged Brie";
    private final String CONJURED = "Conjured Mana Cake";

    public GildedRose2(Item2[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item2 item : items) {

            item.updateQualityAndQuantity();

        }
    }
}
