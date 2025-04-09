package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.MusicGenre;

public class MusicItem extends Item {
    private MusicGenre genre;
    private boolean hasVideo;

    public MusicItem(Item item, MusicGenre genre, boolean hasVideo) {
        super(item.getName(), item.getCategory(), item.getQuantity(), item.getPrice());
        this.genre = genre;
        this.hasVideo = hasVideo;
    }

    public MusicItem() {

    }

    public MusicGenre getGenre() {
        return genre;
    }

    public boolean hasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }
}