package com.gildedrose;

class GildedRose4 {
    Item4[] items;

    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String BRIE = "Aged Brie";
    private final String CONJURED = "Conjured Mana Cake";

    public GildedRose4(Item4[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item4 item : items) {

            item.updateAll();

        }
    }
}
