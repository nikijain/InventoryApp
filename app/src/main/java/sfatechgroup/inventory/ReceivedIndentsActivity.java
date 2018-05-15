package sfatechgroup.inventory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class ReceivedIndentsActivity extends AppCompatActivity {

    private Button btn_drug,btn_institute;
    TextView txt_btn_view,txt_btn_view1,txt_btn_view2;
    TextView txt_btn_instview,txt_btn_instview1,txt_btn_instview2;
    TableLayout instituteLayout;
    TableLayout drugLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_indent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Received Indents");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        instituteLayout =(TableLayout) findViewById(R.id.table_institutewise);
        drugLayout =(TableLayout) findViewById(R.id.table_drugwise);
        if(getIntent().getStringExtra("param").equalsIgnoreCase("InstituteWise")){
            drugLayout.setVisibility(View.GONE);
            instituteLayout.setVisibility(View.VISIBLE);
            txt_btn_instview =(TextView) findViewById(R.id.btn_instituteview);
            txt_btn_instview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReceivedIndentsActivity.this, ViewDrugWiseActivity.class);
                    startActivity(intent);
                }
            });
            txt_btn_instview1 =(TextView) findViewById(R.id.btn_instituteview1);
            txt_btn_instview1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReceivedIndentsActivity.this, ViewDrugWiseActivity.class);
                    startActivity(intent);
                }
            });
            txt_btn_instview2 =(TextView) findViewById(R.id.btn_instituteview2);
            txt_btn_instview2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReceivedIndentsActivity.this, ViewDrugWiseActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            drugLayout.setVisibility(View.VISIBLE);
            instituteLayout.setVisibility(View.GONE);
            txt_btn_view =(TextView) findViewById(R.id.btn_view);
            txt_btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReceivedIndentsActivity.this, ViewDrugWiseActivity.class);
                    startActivity(intent);
                }
            });
            txt_btn_view1 =(TextView) findViewById(R.id.btn_view1);
            txt_btn_view1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReceivedIndentsActivity.this, ViewDrugWiseActivity.class);
                    startActivity(intent);
                }
            });
            txt_btn_view2 =(TextView) findViewById(R.id.btn_view2);
            txt_btn_view2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReceivedIndentsActivity.this, ViewDrugWiseActivity.class);
                    startActivity(intent);
                }
            });
        }
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