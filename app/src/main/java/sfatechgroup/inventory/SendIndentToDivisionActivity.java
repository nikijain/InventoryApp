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

import sfatechgroup.inventory.adapter.RateContractAdapter;
import sfatechgroup.inventory.model.DetailsModel;

public class SendIndentToDivisionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RateContractAdapter adapter;
    List<DetailsModel> detailsModels;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_contract);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Division Indent History");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initializeData1();
        initializeAdapter();
    }

    private void initializeAdapter() {
        adapter = new RateContractAdapter(detailsModels, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    private void initializeData1() {
        detailsModels = new ArrayList<>();
        detailsModels.add(new DetailsModel("Request Number: 20171220/5706/140729 | Request Date: 20-12-2017","Albendazole IP 25mg/ml", "Liquid", "1000ml / Bottle", "20 Bottle", "Division"));
        detailsModels.add(new DetailsModel("Request Number: 20171213/5706/145416 | Request Date: 13-12-2017","Acriflavin Powder BP 5 gm", "Powder", "25 gm / Pouch", "5 Pouch", "Division"));
        detailsModels.add(new DetailsModel("Request Number: 20171211/5706/152558 | Request Date: 11-12-2017","Albendazole IP 25mg/ml", "Liquid", "1000ml / Bottle", "20 Bottle", "Division"));
        detailsModels.add(new DetailsModel("Request Number: 20171211/5706/152520 | Request Date: 11-12-2017","Bezyle bezoate IP 5%+Salicylic acid IP 4%+sulphar IP 2%", "Tube", "120 gm / Tube", "120 Tube", "Division"));
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

