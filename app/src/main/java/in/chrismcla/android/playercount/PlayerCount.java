package in.chrismcla.android.playercount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris on 10/13/2016.
 */

public class PlayerCount {

    public static final String GAME = "Game";
    public static final String PLATFORM = "Platform";
    public static final String PLAYER_COUNT = "Player Count";
    public static final String PLAYER_COUNT_24 = "Player Count 24H";

    public PlayerCount() {

    }

    public List<Map<String, String>> getData() {
        List<Map<String, String>> data = new ArrayList<>();

        for (DataSet ds : DataSet.getDataSets()) {
            for (GameData gd : ds.datas) {
                Map<String, String> datum = new HashMap<>();
                datum.put(GAME, ds.game.name);
                datum.put(PLATFORM, gd.platform.name);
                datum.put(PLAYER_COUNT, gd.count + " Online Now");
                datum.put(PLAYER_COUNT_24, gd.peak24 + " (24h Peak)");
                data.add(datum);
            }
        }

        return data;
    }

    public String[] getLabels() {
        return new String[] {GAME, PLATFORM, PLAYER_COUNT, PLAYER_COUNT_24};
    }

    public int[] getIds() {
        return new int[] { R.id.text1, R.id.text2, R.id.textNumber, R.id.textNumber2 };
    }
}
