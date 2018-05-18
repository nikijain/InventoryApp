package sfatechgroup.inventory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sfatechgroup.inventory.model.SpinnerModel;

public class LoginActivity extends AppCompatActivity {

    List<SpinnerModel> listLoginType;
    ArrayAdapter<SpinnerModel> adapterLoginType;
    String selected_id;
    Spinner spnLoginType;
    Context context;
    TextView txtLogin;
    Intent intent;
    public static String selectedLoginType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = LoginActivity.this;
        spnLoginType= (Spinner) findViewById(R.id.spnLoginType);

        listLoginType = new ArrayList<>();
        listLoginType.add(new SpinnerModel("0","Select Login Type"));
        listLoginType.add(new SpinnerModel("1","Admin"));
        listLoginType.add(new SpinnerModel("2","Dealer"));
        listLoginType.add(new SpinnerModel("3","district"));
        listLoginType.add(new SpinnerModel("4","Division"));
        listLoginType.add(new SpinnerModel("5","Farm"));
        listLoginType.add(new SpinnerModel("6","Institute"));
        listLoginType.add(new SpinnerModel("7","Lab"));
        listLoginType.add(new SpinnerModel("8","Polyclinic"));
        listLoginType.add(new SpinnerModel("9","State Hospital"));
        listLoginType.add(new SpinnerModel("10","Vendor"));

        adapterLoginType = new ArrayAdapter<SpinnerModel>(context, android.R.layout.simple_spinner_item, listLoginType) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setGravity(Gravity.LEFT);
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(ContextCompat.getColor(context, R.color.colorGrey));
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
                    tv.setTextColor(ContextCompat.getColor(context, R.color.colorGrey));
                    ;
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapterLoginType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnLoginType.setAdapter(adapterLoginType);
        spnLoginType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                SpinnerModel spinnerModel = (SpinnerModel) parent.getItemAtPosition(position);
                selected_id = spinnerModel.id;
                selectedLoginType = spinnerModel.name;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        txtLogin = (TextView) findViewById(R.id.login);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!selectedLoginType.equalsIgnoreCase("Select Login Type")) {
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(context,"Please Select Login Type",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
