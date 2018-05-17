package sfatechgroup.inventory;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import sfatechgroup.inventory.adapter.SendIndentHistoryAdapter;
import sfatechgroup.inventory.model.DetailsModel;

public class SentIndentHistory extends AppCompatActivity {

    RecyclerView recyclerView;
    SendIndentHistoryAdapter adapter;
    List<DetailsModel> detailsModels;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_indent_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Indent History");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initializeData1();
        initializeAdapter();
    }

    private void initializeAdapter() {
        adapter = new SendIndentHistoryAdapter(getApplicationContext(),detailsModels);
        recyclerView.setAdapter(adapter);
    }

    private void initializeData1() {
        detailsModels = new ArrayList<>();

        detailsModels.add(new DetailsModel("Request Number: 20171220/5706/140729 - Date: 20-12-2017","Acriflavin Powder BP 5 gm (Medicine Code MD-590)", "phormocopial", "Powder", "25 gm/Pouch", "115"));
        detailsModels.add(new DetailsModel("Request Number: 20171213/5706/145416 - Date: 13-12-2017 ","Albendazole IP 25mg/ml (Medicine Code MD-390)", "allopathy", "Liquid", "120ml/Bottle", "12.7"));
        detailsModels.add(new DetailsModel("Request Number: 20171211/5706/152558 - Date: 11-12-2017","Albendazole IP 25mg/ml (Medicine Code MD-391)", "allopathy", "Liquid", "1000ml/Bottle", "91.8"));
        detailsModels.add(new DetailsModel("Request Number: 20171211/5706/152520 - Date: 11-12-2017","Albendazole IP 25mg/ml (Medicine Code MD-390)", "allopathy", "Liquid", "120ml/Bottle", "12.7"));

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;

    }

    public void onBackPressed() {

        super.onBackPressed();
        finish();

    }
}
