package in.chrismcla.android.playercount;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 10/13/2016.
 */

public class DataSet {

    Game game;
    List<GameData> datas;

    public DataSet(RawData raw, Game game) {
        this.game = game;
        datas = new ArrayList<>();
        if(raw.pc != null) datas.add(raw.pc);
        if(raw.xbox != null) datas.add(raw.xbox);
        if(raw.xone != null) datas.add(raw.xone);
        if(raw.ps3 != null) datas.add(raw.ps3);
        if(raw.ps4 != null) datas.add(raw.ps4);
    }

    public static DataSet getDataSet(Game game) {
        return new DataSet(JsonReader.readGameData(game.url), game);
    }

    public static List<DataSet> getDataSets() {
        List<DataSet> sets = new ArrayList<>();
        for (Game g :
                Game.values()) {
            sets.add(getDataSet(g));
        }
        return sets;
    }
}

class RawData {

    @SerializedName("pc")
    @Expose
    public GameData pc;
    @SerializedName("ps3")
    @Expose
    public GameData ps3;
    @SerializedName("xbox")
    @Expose
    public GameData xbox;
    @SerializedName("xone")
    @Expose
    public GameData xone;
    @SerializedName("ps4")
    @Expose
    public GameData ps4;
}

class GameData {

    @SerializedName("label")
    @Expose
    public Platform platform;
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("peak24")
    @Expose
    public Integer peak24;

}