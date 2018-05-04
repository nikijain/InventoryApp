package sfatechgroup.inventory;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sfatechgroup.inventory.model.MonthSpinnerModel;
import sfatechgroup.inventory.model.YearSpinnerModel;

public class SupplyHistoryActivity extends AppCompatActivity {
    List<MonthSpinnerModel> list_month;
    List <YearSpinnerModel> list_year;
    Spinner spinnerYear, spinnerMonth;
    ArrayAdapter<YearSpinnerModel> year_adapter;
    ArrayAdapter<MonthSpinnerModel> month_adapter;
    int year;
    String month;
    private TextView btn_viewHistory,btn_viewHistory1,btn_viewHistory2,btn_viewHistory3;
    LinearLayout detailLV,monthLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supply_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Supply History");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list_year = new ArrayList<YearSpinnerModel>();
        list_year.add(new YearSpinnerModel(1, "Please Select"));

        Calendar calendar = Calendar.getInstance();
        int current_year = calendar.get(Calendar.YEAR);
        int next_year;

        Log.d("Testing", "Test year" + current_year);

        for(int i= 0; i <= 1; i++){
            list_year.add(new YearSpinnerModel(current_year, String.valueOf(current_year)));
            current_year--;
        }
        detailLV = (LinearLayout) findViewById(R.id.detailLV);
        monthLV = (LinearLayout) findViewById(R.id.monthLV);
        spinnerYear = (Spinner) findViewById(R.id.year_spinner);
        year_adapter = new ArrayAdapter<YearSpinnerModel>(SupplyHistoryActivity.this, R.layout.spinner_item_details, list_year){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setGravity(Gravity.LEFT);
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
                //tv.setTextColor(Color.RED);
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setGravity(Gravity.LEFT);
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                    ;
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(year_adapter);
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                YearSpinnerModel selectedYear = (YearSpinnerModel) parent.getItemAtPosition(position);
                year = selectedYear.year;
                Log.d("Testing", "Spinner value Divison :" + year);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        list_month = new ArrayList<MonthSpinnerModel>();
        list_month.add(new MonthSpinnerModel("20","Please Select"));
        list_month.add(new MonthSpinnerModel("01","January"));
        list_month.add(new MonthSpinnerModel("02","February"));
        list_month.add(new MonthSpinnerModel("03","March"));
        list_month.add(new MonthSpinnerModel("04","April"));
        list_month.add(new MonthSpinnerModel("05","May"));
        list_month.add(new MonthSpinnerModel("06","June"));
        list_month.add(new MonthSpinnerModel("07","July"));
        list_month.add(new MonthSpinnerModel("08","August"));
        list_month.add(new MonthSpinnerModel("09","September"));
        list_month.add(new MonthSpinnerModel("10","October"));
        list_month.add(new MonthSpinnerModel("11","November"));
        list_month.add(new MonthSpinnerModel("12","December"));

        spinnerMonth = (Spinner) findViewById(R.id.month_spinner);
        month_adapter = new ArrayAdapter<MonthSpinnerModel>(SupplyHistoryActivity.this, R.layout.spinner_item_details, list_month){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setGravity(Gravity.LEFT);
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
                //tv.setTextColor(Color.RED);
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setGravity(Gravity.LEFT);
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                    ;
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(month_adapter);

        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MonthSpinnerModel selectedMonth= (MonthSpinnerModel) parent.getItemAtPosition(position);
                month = selectedMonth.month;
                Log.d("Testing", "Spinner value Divison :" + month);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_viewHistory =(TextView) findViewById(R.id.btn_viewHistory);
        btn_viewHistory1 =(TextView) findViewById(R.id.viewHistory1);
        btn_viewHistory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewSuppyHistoryDetailActivity.class);
                startActivity(intent);
            }
        });
        btn_viewHistory2 =(TextView) findViewById(R.id.viewHistory2);
        btn_viewHistory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewSuppyHistoryDetailActivity.class);
                startActivity(intent);
            }
        });
        btn_viewHistory3 =(TextView) findViewById(R.id.viewHistory3);
        btn_viewHistory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewSuppyHistoryDetailActivity.class);
                startActivity(intent);
            }
        });
        btn_viewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(year==1){
                    monthLV.setVisibility(View.VISIBLE);
                    detailLV.setVisibility(View.GONE);
                    Toast.makeText(SupplyHistoryActivity.this,"Please Select Year",Toast.LENGTH_SHORT).show();
                }
                else if(month.equalsIgnoreCase("20")){
                    monthLV.setVisibility(View.VISIBLE);
                    detailLV.setVisibility(View.GONE);
                    Toast.makeText(SupplyHistoryActivity.this,"Please Select Year",Toast.LENGTH_SHORT).show();
                }
                else {
                    monthLV.setVisibility(View.GONE);
                    detailLV.setVisibility(View.VISIBLE);
                }
            }
        });
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
