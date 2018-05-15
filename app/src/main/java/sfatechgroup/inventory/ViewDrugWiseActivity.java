package sfatechgroup.inventory;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewDrugWiseActivity extends AppCompatActivity {

    private TextView btn_excel,txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drug_wise);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("View Request Indent");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_excel =(TextView) findViewById(R.id.btn_excel);
        btn_excel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// check if available and not read only
                boolean isPermission = checkPermission();
                if (isPermission == true) {
                    SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
                    String format = s.format(new Date());
                    if(saveToExcel(v.getContext(),"requestindent"+format+".xls")){
                        Toast.makeText(ViewDrugWiseActivity.this,"Exported to Excel Successfully.",Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(ViewDrugWiseActivity.this, "Error in exporting file.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    requestPermission();
                }
            }
        });
    }
    private boolean requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(ViewDrugWiseActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                && ActivityCompat.shouldShowRequestPermissionRationale(ViewDrugWiseActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
        } else {
            ActivityCompat.requestPermissions(ViewDrugWiseActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
                    String format = s.format(new Date());
                    if(saveToExcel(ViewDrugWiseActivity.this,"labtest"+format+".xls")){
                        Toast.makeText(ViewDrugWiseActivity.this,"Exported to Excel Successfully.",Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(ViewDrugWiseActivity.this, "Error in exporting file.", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ViewDrugWiseActivity.this,"You don't have file permission.",Toast.LENGTH_SHORT).show();
                }
        }
    }
    private boolean checkPermission() {
        //int result = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }else {
            return false;
        }
    }
    private static boolean saveToExcel(Context context, String fileName) {
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            Log.e("Inventory", "Storage not available or read only");
            return false;
        }

        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();

        Cell c = null;

        //Cell style for header row
        CellStyle cs = wb.createCellStyle();
        cs.setFillForegroundColor(HSSFColor.LIME.index);
        cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        //New Sheet
        Sheet sheet1 = null;
        sheet1 = wb.createSheet("history");

        // Generate column headings
        Row row = sheet1.createRow(0);

        c = row.createCell(0);
        c.setCellValue("S.No.");
        c.setCellStyle(cs);

        c = row.createCell(1);
        c.setCellValue("Test No.");
        c.setCellStyle(cs);

        c = row.createCell(2);
        c.setCellValue("Drug");
        c.setCellStyle(cs);

        c = row.createCell(3);
        c.setCellValue("Batch No.");
        c.setCellStyle(cs);

        c = row.createCell(4);
        c.setCellValue("Lab Name");
        c.setCellStyle(cs);

        c = row.createCell(5);
        c.setCellValue("Quantity");
        c.setCellStyle(cs);

        c = row.createCell(6);
        c.setCellValue("Sending Date");
        c.setCellStyle(cs);

        c = row.createCell(7);
        c.setCellValue("Result");
        c.setCellStyle(cs);

        c = row.createCell(8);
        c.setCellValue("Result Date");
        c.setCellStyle(cs);

        c = row.createCell(9);
        c.setCellValue("Report");
        c.setCellStyle(cs);

        sheet1.setColumnWidth(0, (15 * 500));
        sheet1.setColumnWidth(1, (15 * 500));
        sheet1.setColumnWidth(2, (15 * 500));
        sheet1.setColumnWidth(3, (15 * 500));
        sheet1.setColumnWidth(4, (15 * 500));
        sheet1.setColumnWidth(5, (15 * 500));
        sheet1.setColumnWidth(6, (15 * 500));
        sheet1.setColumnWidth(7, (15 * 500));
        sheet1.setColumnWidth(8, (15 * 500));
        sheet1.setColumnWidth(9, (15 * 500));

        // Create a path where we will place our List of objects on external storage
        File file = new File(context.getExternalFilesDir(null), fileName);
        FileOutputStream os = null;

        try {
            os = new FileOutputStream(file);
            wb.write(os);
            Log.w("FileUtils", "Writing file" + file);
            success = true;
        } catch (IOException e) {
            Log.w("FileUtils", "Error writing " + file, e);
        } catch (Exception e) {
            Log.w("FileUtils", "Failed to save file", e);
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception ex) {
            }
        }
        return success;
    }

    public static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
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
