package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Shop;
import pl.edu.agh.dronka.shop.model.User;
import pl.edu.agh.dronka.shop.model.items.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));
				Item item = new Item(name, category, price, quantity);
				item.setPolish(isPolish);
				item.setSecondhand(isSecondhand);

				Item finalItem = switch (item.getCategory()) {
					case BOOKS -> new BookItem(
							item,
							Integer.parseInt(reader.getValue(dataLine, "Liczba stron")),
							Boolean.parseBoolean(reader.getValue(dataLine, "Twarda oprawa"))
					);
					case ELECTRONICS -> new ElectronicsItem(
							item,
							Boolean.parseBoolean(reader.getValue(dataLine, "Mobilny")),
							Boolean.parseBoolean(reader.getValue(dataLine, "Gwarancja"))
					);
					case FOOD -> new FoodItem(
							item,
							LocalDate.parse(reader.getValue(dataLine, "Data spożycia").trim(),
									DateTimeFormatter.ofPattern("dd-MM-yyyy")));
					case MUSIC -> new MusicItem(
							item,
							MusicGenre.fromString(reader.getValue(dataLine, "Gatunek muzyczny")),
							Boolean.parseBoolean(reader.getValue(dataLine, "Dołączone wideo"))
					);

					default -> item;
				};

				items.add(finalItem);



			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
