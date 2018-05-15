package sfatechgroup.inventory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class SendIndentToDivisionActivity extends AppCompatActivity {

    private TextView btn_excel,txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_indent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Send Indent To Division");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        txt_view =(TextView) findViewById(R.id.btn_view);
//        txt_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SendIndentToDivisionActivity.this, LabTestViewActivity.class);
//                startActivity(intent);
//            }
//        });
//        btn_excel =(TextView) findViewById(R.id.btn_excel);
//        btn_excel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//// check if available and not read only
//
//            }
//        });
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
