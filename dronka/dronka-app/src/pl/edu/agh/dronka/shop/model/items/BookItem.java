package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Item;

public class BookItem extends Item {
    private int pages;
    private boolean hardCover;

    public BookItem(Item item, int pages, boolean hardCover) {
        super(item.getName(), item.getCategory(), item.getQuantity(), item.getPrice());
        this.pages = pages;
        this.hardCover = hardCover;
    }

    public BookItem() {

    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public boolean isHardCover() {
        return hardCover;
    }
    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }
}
