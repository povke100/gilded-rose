package lt.povilass.gildedrose;

public class Main {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 20) };

		GildedRose app = new GildedRose(items);

		int days = 7;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}
		
		System.out.println("-------- day 0 --------");
		System.out.println("name, sellIn, quality");
		for (Item item : items) {
			System.out.println(item);
		}
		System.out.println();
		
		for (int i = 0; i < days; i++) {
			app.updateQuality();
			System.out.println("-------- day " + (i+1) + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			
		}

	}

}
