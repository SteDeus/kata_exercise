package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest1 {

    @Nested
    @DisplayName("Standard Items")
    class StandardItems {
        @Test
        @DisplayName("Quality and sellIn decrease by 1 each day")
        void standardItemDecreasesInQualityAndSellIn() {
            Item2[] items = new Item2[]{new Item2("Standard Item 1", 10, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(9, app.items[0].sellIn);
            assertEquals(19, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality decreases double when sellIn date has passed")
        void standardItemQualityDecreasesDoubleAfterSellIn() {
            Item2[] items = new Item2[]{new Item2("Standard Item 2", 0, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(18, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality is never negative")
        void qualityNeverNegative() {
            Item2[] items = new Item2[]{new Item2("Standard Item 3", 10, 0)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("Aged Brie")
    class AgedBrie {
        private final String BRIE = "Aged Brie";

        @Test
        @DisplayName("Aged Brie increases in quality the older it gets")
        void agedBrieIncreasesInQuality() {
            Item2[] items = new Item2[]{new Item2(BRIE, 10, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality never exceeds 50")
        void qualityNeverMoreThanFifty() {
            Item2[] items = new Item2[]{new Item2(BRIE, 10, 50)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        @DisplayName("Aged Brie increases by 2 in quality after sellIn date")
        void agedBrieQualityIncreasesDoubleAfterSellIn() {
            Item2[] items = new Item2[]{new Item2(BRIE, 0, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("Aged Brie quality never exceeds 50 even after sellIn date")
        void agedBrieQualityNeverMoreThanFiftyEvenAfterSellIn() {
            Item2[] items = new Item2[]{new Item2(BRIE, 0, 49)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("Sulfuras")
    class Sulfuras {
        private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

        @Test
        @DisplayName("Sulfuras quality is 50 and never changes")
        void sulfurasQualityNeverChanges() {
            Item2[] items = new Item2[]{new Item2(SULFURAS, 10, 80)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(80, app.items[0].quality);
        }

        @Test
        @DisplayName("Sulfuras sellIn never changes")
        void sulfurasSellInNeverChanges() {
            Item2[] items = new Item2[]{new Item2(SULFURAS, 10, 80)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(10, app.items[0].sellIn);
        }

        @Test
        @DisplayName("Sulfuras quality and sellIn never change even after sellIn date")
        void sulfurasNeverChangesEvenAfterSellIn() {
            Item2[] items = new Item2[]{new Item2(SULFURAS, -1, 80)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(80, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("Backstage Passes")
    class BackstagePasses {
        private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

        @Test
        @DisplayName("Quality increases by 1 when there are more than 10 days left")
        void increasesByOneMoreThanTenDays() {
            Item2[] items = new Item2[]{new Item2(BACKSTAGE_PASSES, 11, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 2 when there are 10 days left")
        void increasesByTwoWithTenDaysLeft() {
            Item2[] items = new Item2[]{new Item2(BACKSTAGE_PASSES, 10, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 2 when there are 6 days left")
        void increasesByTwoWithSixDaysLeft() {
            Item2[] items = new Item2[]{new Item2(BACKSTAGE_PASSES, 6, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 3 when there are 5 days left")
        void increasesByThreeWithFiveDaysLeft() {
            Item2[] items = new Item2[]{new Item2(BACKSTAGE_PASSES, 5, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 3 when there are 1 day left")
        void increasesByThreeWithOneDayLeft() {
            Item2[] items = new Item2[]{new Item2(BACKSTAGE_PASSES, 1, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality drops to 0 after the concert")
        void qualityDropsToZeroAfterConcert() {
            Item2[] items = new Item2[]{new Item2(BACKSTAGE_PASSES, 0, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality never exceeds 50 (10 days)")
        void qualityNeverMoreThanFiftyNearConcert() {
            Item2[] items = new Item2[]{new Item2(BACKSTAGE_PASSES, 10, 49)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("Conjured Items")
    class ConjuredItems {
        private final String CONJURED = "Conjured Mana Cake";

        @Test
        @DisplayName("Conjured items degrade in quality twice as fast as normal items")
        void conjuredItemsDegradeTwiceAsFast() {
            Item2[] items = new Item2[]{new Item2(CONJURED, 10, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(18, app.items[0].quality);
            assertEquals(9,  app.items[0].sellIn);
        }

        @Test
        @DisplayName("Conjured items degrade in quality twice as fast as normal items after sellIn date")
        void conjuredItemsDegradeTwiceAsFastAfterSellIn() {
            Item2[] items = new Item2[]{new Item2(CONJURED, 0, 20)};
            GildedRose1 app = new GildedRose1(items);
            app.updateQuality();
            assertEquals(16, app.items[0].quality);
            assertEquals(-1, app.items[0].sellIn);
        }
    }
}
