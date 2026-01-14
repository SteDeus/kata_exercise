package com.gildedrose;

class GildedRose3 {
    Item3[] items;

    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String BRIE = "Aged Brie";
    private final String CONJURED = "Conjured Mana Cake";

    public GildedRose3(Item3[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item3 item : items) {

            item.updateAll();

        }
    }
}
