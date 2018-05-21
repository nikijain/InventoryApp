package sfatechgroup.inventory.lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import sfatechgroup.inventory.R;

public class Lab_RequestSenderWiseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labrequest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Request Sender List");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView viewallrequest1 = (TextView) findViewById(R.id.viewallrequest1);
        viewallrequest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab_RequestSenderWiseActivity.this,Lab_ViewAllRequestsActivity.class);
                startActivity(intent);
            }
        });
        TextView viewallrequest2 = (TextView) findViewById(R.id.viewallrequest2);
        viewallrequest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab_RequestSenderWiseActivity.this,Lab_ViewAllRequestsActivity.class);
                startActivity(intent);
            }
        });
        TextView viewallrequest3 = (TextView) findViewById(R.id.viewallrequest3);
        viewallrequest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab_RequestSenderWiseActivity.this,Lab_ViewAllRequestsActivity.class);
                startActivity(intent);
            }
        });
        TextView viewallrequest4 = (TextView) findViewById(R.id.viewallrequest4);
        viewallrequest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab_RequestSenderWiseActivity.this,Lab_ViewAllRequestsActivity.class);
                startActivity(intent);
            }
        });
        TextView viewallrequest5 = (TextView) findViewById(R.id.viewallrequest5);
        viewallrequest5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab_RequestSenderWiseActivity.this,Lab_ViewAllRequestsActivity.class);
                startActivity(intent);
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
