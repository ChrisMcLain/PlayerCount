package in.chrismcla.android.playercount;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static MainActivity context;
    PlayerCount playerCount;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        playerCount = new PlayerCount();
        progress = new ProgressDialog(this);

        //setup progress dialogue
        progress.setTitle("Refreshing");
        progress.setMessage("Getting new data, please wait...");

        doRefresh();
    }

    public void showData(final List<Map<String,String>> data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SimpleAdapter adapter = new SimpleAdapter(MainActivity.context,
                        data,
                        R.layout.list_item_number,
                        playerCount.getLabels(),
                        playerCount.getIds());

                ListView view = (ListView) findViewById(R.id.list_view);
                view.setAdapter(adapter);

                progress.dismiss();
            }
        });
    }

    public void doRefresh() {
        progress.show();

        ListView view = (ListView) findViewById(R.id.list_view);
        view.setAdapter(null);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                showData(playerCount.getData());
            }
        });
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hotbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_refresh) {
            doRefresh();
        }
        return true;
    }
}
