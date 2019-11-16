package lt.povilass.gildedrose.test;

import org.junit.Assert;
import org.junit.Test;

import lt.povilass.gildedrose.GildedRose;
import lt.povilass.gildedrose.Item;


public class GildedRoseTest {
	
	private int [] assertionValues = {19, 18, 1, 50, 2, 6, 5, 80, 80, 21, 47, 48, 0, 0, 8, 6};
 
    @Test
    public void testUpdate() {
    	Item[] items = new Item[] { 
    			new Item("+5 Dexterity Vest", 10, 20), //
    			new Item("+5 Dexterity Vest", 0, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Aged Brie", 2, 50), //
				new Item("Aged Brie", -1, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Elixir of the Mongoose", 0, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 45),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45),
				new Item("Backstage passes to a TAFKAL80ETC concert", 0, 42),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 0, 0),
				new Item("Conjured Mana Cake", 3, 10),
				new Item("Conjured Mana Cake", -1, 10)};

		GildedRose app = new GildedRose(items);
        app.updateQuality();
		
		for(int i = 0; i < items.length; i++) {
			Assert.assertEquals(assertionValues[i], items[i].quality);
			
		}
       
    }

}
