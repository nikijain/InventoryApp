package sfatechgroup.inventory;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sfatechgroup.inventory.adapter.RateContractAdapter;
import sfatechgroup.inventory.model.DetailsModel;

public class RateContractActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RateContractAdapter adapter;
    List<DetailsModel> detailsModels;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_contract);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Rate Contract");
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

        detailsModels.add(new DetailsModel("Acriflavin Powder BP 5 gm","Acriflavin Powder BP 5 gm (Medicine Code MD-590)", "phormocopial", "Powder", "25 gm/Pouch", "115"));
        detailsModels.add(new DetailsModel("Albendazole IP 25mg/ml ","Albendazole IP 25mg/ml (Medicine Code MD-390)", "allopathy", "Liquid", "120ml/Bottle", "12.7"));
        detailsModels.add(new DetailsModel("Albendazole IP 25mg/ml ","Albendazole IP 25mg/ml (Medicine Code MD-391)", "allopathy", "Liquid", "1000ml/Bottle", "91.8"));
        detailsModels.add(new DetailsModel("Amikacin sulphate 250mg/ml ","Albendazole IP 25mg/ml (Medicine Code MD-390)", "allopathy", "Liquid", "120ml/Bottle", "12.7"));
        detailsModels.add(new DetailsModel("Amitraz 12.5% ","Amitraz 12.5% (Medicine Code MD-501)", "allopathy", "Liquid", "120ml/Bottle", "12.7"));
        detailsModels.add(new DetailsModel("Albendazole IP 25mg/ml ","Albendazole IP 25mg/ml (Medicine Code MD-390)", "allopathy", "Liquid", "120ml/Bottle", "12.7"));


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
