package in.chrismcla.android.playercount;

/**
 * Created by Chris on 10/13/2016.
 */

public enum Platform {
    PC("PC"),
    XBOXONE("Xbox One"),
    XBOX360("Xbox 360"),
    PS4("PlayStation 4"),
    PS3("PlayStation 3");

    public String name;

    Platform(String name) {
        this.name = name;
    }
}

enum Game {
    BF1("Battlefield 1", "http://api.bf1stats.com/api/onlinePlayers"),
    BF4("Battlefield 4", "http://api.bf4stats.com/api/onlinePlayers"),
    SWB("Star Wars Battlefront", "http://api.swbstats.com/api/onlinePlayers"),
    BFH("Battlefield Hardline", "http://api.bfhstats.com/api/onlinePlayers");

    String url;
    String name;

    Game(String name, String url) {
        this.url = url;
        this.name = name;
    }
}