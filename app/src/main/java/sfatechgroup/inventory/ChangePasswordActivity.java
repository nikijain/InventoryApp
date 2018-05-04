package sfatechgroup.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Change Password");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

      public boolean onOptionsItemSelected(android.view.MenuItem item) {
        finish();
        return true;

    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
