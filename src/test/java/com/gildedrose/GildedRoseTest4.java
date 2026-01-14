package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest4 {

    @Nested
    @DisplayName("Standard Items")
    class StandardItems {
        @Test
        @DisplayName("Quality and sellIn decrease by 1 each day")
        void standardItemDecreasesInQualityAndSellIn() {
            Item4[] items = new Item4[]{new Item4("Standard Item 1", 10, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(9, app.items[0].sellIn);
            assertEquals(19, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality decreases double when sellIn date has passed")
        void standardItemQualityDecreasesDoubleAfterSellIn() {
            Item4[] items = new Item4[]{new Item4("Standard Item 2", 0, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(18, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality is never negative")
        void qualityNeverNegative() {
            Item4[] items = new Item4[]{new Item4("Standard Item 3", 10, 0)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        @DisplayName("Price is never zero")
        void priceNeverZero() {
            Item4[] items = new Item4[]{new Item4("Standard Item 1", 10, 20, 1)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            // Check lower bound even if standard logic doesn't reduce price
            assert(app.items[0].price > 0);
        }
    }

    @Nested
    @DisplayName("Aged Brie")
    class AgedBrie {
        private final String BRIE = "Aged Brie";

        @Test
        @DisplayName("Initial price is 50 and increases by 5 every 2 days")
        void agedBriePriceIncreasesByFiveEveryTwoDays() {
            ItemBrie4[] items = new ItemBrie4[]{new ItemBrie4(BRIE, 10, 20)};
            GildedRose4 app = new GildedRose4(items);

            assertEquals(50, app.items[0].price);

            app.updateQuality();
            assertEquals(50, app.items[0].price, "Price should stay 50 after 1 day");

            app.updateQuality();
            assertEquals(55, app.items[0].price, "Price should increase to 55 after 2 days");

            app.updateQuality();
            assertEquals(55, app.items[0].price, "Price should stay 55 after 3 days");

            app.updateQuality();
            assertEquals(60, app.items[0].price, "Price should increase to 60 after 4 days");
        }

        @Test
        @DisplayName("Aged Brie increases in quality the older it gets")
        void agedBrieIncreasesInQuality() {
            ItemBrie4[] items = new ItemBrie4[]{new ItemBrie4(BRIE, 10, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality never exceeds 50")
        void qualityNeverMoreThanFifty() {
            ItemBrie4[] items = new ItemBrie4[]{new ItemBrie4(BRIE, 10, 50)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        @DisplayName("Aged Brie increases by 2 in quality after sellIn date")
        void agedBrieQualityIncreasesDoubleAfterSellIn() {
            ItemBrie4[] items = new ItemBrie4[]{new ItemBrie4(BRIE, 0, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("Aged Brie quality never exceeds 50 even after sellIn date")
        void agedBrieQualityNeverMoreThanFiftyEvenAfterSellIn() {
            ItemBrie4[] items = new ItemBrie4[]{new ItemBrie4(BRIE, 0, 49)};
            GildedRose4 app = new GildedRose4(items);
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
            ItemSulfuras4[] items = new ItemSulfuras4[]{new ItemSulfuras4(SULFURAS, 10, 80)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(80, app.items[0].quality);
        }

        @Test
        @DisplayName("Sulfuras sellIn never changes")
        void sulfurasSellInNeverChanges() {
            ItemSulfuras4[] items = new ItemSulfuras4[]{new ItemSulfuras4(SULFURAS, 10, 80)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(10, app.items[0].sellIn);
        }

        @Test
        @DisplayName("Sulfuras quality and sellIn never change even after sellIn date")
        void sulfurasNeverChangesEvenAfterSellIn() {
            ItemSulfuras4[] items = new ItemSulfuras4[]{new ItemSulfuras4(SULFURAS, -1, 80)};
            GildedRose4 app = new GildedRose4(items);
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
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 11, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 2 when there are 10 days left")
        void increasesByTwoWithTenDaysLeft() {
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 10, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 2 when there are 6 days left")
        void increasesByTwoWithSixDaysLeft() {
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 6, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 3 when there are 5 days left")
        void increasesByThreeWithFiveDaysLeft() {
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 5, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality increases by 3 when there are 1 day left")
        void increasesByThreeWithOneDayLeft() {
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 1, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality drops to 0 after the concert")
        void qualityDropsToZeroAfterConcert() {
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 0, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        @DisplayName("Quality never exceeds 50 (10 days)")
        void qualityNeverMoreThanFiftyNearConcert() {
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 10, 49)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        @DisplayName("Initial price is 100 and increases by 20 daily, drops to 2 after concert")
        void backstagePassesPriceLogic() {
            ItemBackstage4[] items = new ItemBackstage4[]{new ItemBackstage4(BACKSTAGE_PASSES, 1, 20)};
            GildedRose4 app = new GildedRose4(items);

            assertEquals(100, app.items[0].price);

            app.updateQuality(); // sellIn becomes 0, price increase applied before expiration
            assertEquals(120, app.items[0].price);

            app.updateQuality(); // sellIn becomes -1 (concert passed)
            assertEquals(2, app.items[0].price);
        }
    }

    @Nested
    @DisplayName("Conjured Items")
    class ConjuredItems {
        private final String CONJURED = "Conjured Mana Cake";

        @Test
        @DisplayName("Conjured items degrade in quality twice as fast as normal items")
        void conjuredItemsDegradeTwiceAsFast() {
            ItemConjured4[] items = new ItemConjured4[]{new ItemConjured4(CONJURED, 10, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(18, app.items[0].quality);
            assertEquals(9,  app.items[0].sellIn);
        }

        @Test
        @DisplayName("Conjured items degrade in quality twice as fast as normal items after sellIn date")
        void conjuredItemsDegradeTwiceAsFastAfterSellIn() {
            ItemConjured4[] items = new ItemConjured4[]{new ItemConjured4(CONJURED, 0, 20)};
            GildedRose4 app = new GildedRose4(items);
            app.updateQuality();
            assertEquals(16, app.items[0].quality);
            assertEquals(-1, app.items[0].sellIn);
        }

        @Nested
        @DisplayName("Global Price Rules")
        class GlobalPriceRules {
            @Test
            @DisplayName("No item can have a price higher than Sulfuras (100,000)")
            void priceNeverHigherThanSulfuras() {
                ItemConjured4[] items = new ItemConjured4[]{new ItemConjured4("Expensive Cake", 10, 20, 99950)};
                GildedRose4 app = new GildedRose4(items);

                app.updateQuality();
                assertEquals(100000, app.items[0].price);
            }
        }
    }
}
