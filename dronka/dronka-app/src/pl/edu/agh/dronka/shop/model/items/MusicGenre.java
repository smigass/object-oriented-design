package pl.edu.agh.dronka.shop.model.items;

public enum MusicGenre {
    ROCK("Rock"),
    POP("Pop"),
    JAZZ("Jazz"),
    CLASSICAL("Classical");

    private final String displayName;

    MusicGenre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static MusicGenre fromString(String string) {
        for (MusicGenre musicGenre : MusicGenre.values()) {
            System.out.println(musicGenre.getDisplayName());
            System.out.println(string);
            if (musicGenre.getDisplayName().equalsIgnoreCase(string)) {
                return musicGenre;
            }
        }
        return null;
    }
}