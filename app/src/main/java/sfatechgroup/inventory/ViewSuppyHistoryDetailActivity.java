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

public class ViewSuppyHistoryDetailActivity extends AppCompatActivity {

    private TextView btn_excel,txt_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_supply_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("View Supply History");
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
                    if(saveToExcel(v.getContext(),"inventory_"+format+".xls")){
                        Toast.makeText(ViewSuppyHistoryDetailActivity.this,"Exported to Excel Successfully.",Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(ViewSuppyHistoryDetailActivity.this, "Error in exporting file.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    requestPermission();
                }
            }
        });
    }
    private boolean requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(ViewSuppyHistoryDetailActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                && ActivityCompat.shouldShowRequestPermissionRationale(ViewSuppyHistoryDetailActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
        } else {
            ActivityCompat.requestPermissions(ViewSuppyHistoryDetailActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
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
                    if(saveToExcel(ViewSuppyHistoryDetailActivity.this,"inventory_"+format+".xls")){
                        Toast.makeText(ViewSuppyHistoryDetailActivity.this,"Exported to Excel Successfully.",Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(ViewSuppyHistoryDetailActivity.this, "Error in exporting file.", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ViewSuppyHistoryDetailActivity.this,"You don't have file permission.",Toast.LENGTH_SHORT).show();
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
        c.setCellValue("Drug Name");
        c.setCellStyle(cs);

        c = row.createCell(2);
        c.setCellValue("Batch No.");
        c.setCellStyle(cs);

        c = row.createCell(3);
        c.setCellValue("Quantity");
        c.setCellStyle(cs);

        c = row.createCell(4);
        c.setCellValue("Sending Date");
        c.setCellStyle(cs);

        c = row.createCell(5);
        c.setCellValue("Receiving Status");
        c.setCellStyle(cs);

        c = row.createCell(6);
        c.setCellValue("Receiving Date");
        c.setCellStyle(cs);

        Row row1 = sheet1.createRow(1);

        c = row1.createCell(0);
        c.setCellValue("1");

        c = row1.createCell(1);
        c.setCellValue("Abamectin 50 Mg + Clorsulon 1 Gm. | Bolus | 1");

        c = row1.createCell(2);
        c.setCellValue("123");

        c = row1.createCell(3);
        c.setCellValue("75.00");

        c = row1.createCell(4);
        c.setCellValue("25-07-2017");

        c = row1.createCell(5);
        c.setCellValue("Received");

        c = row1.createCell(6);
        c.setCellValue("25-07-2017");

        Row row2 = sheet1.createRow(2);

        c = row2.createCell(0);
        c.setCellValue("2");

        c = row2.createCell(1);
        c.setCellValue("Amitraz 12.5% | Liquid | 120ml");

        c = row2.createCell(2);
        c.setCellValue("123");

        c = row2.createCell(3);
        c.setCellValue("75.00");

        c = row2.createCell(4);
        c.setCellValue("25-07-2017");

        c = row2.createCell(5);
        c.setCellValue("Received");

        c = row2.createCell(6);
        c.setCellValue("25-07-2017");

        Row row3 = sheet1.createRow(3);

        c = row3.createCell(0);
        c.setCellValue("3");

        c = row3.createCell(1);
        c.setCellValue("Nimusilide BP 1% w/w | Cream | 250 gm");

        c = row3.createCell(2);
        c.setCellValue("123");

        c = row3.createCell(3);
        c.setCellValue("75.00");

        c = row3.createCell(4);
        c.setCellValue("25-07-2017");

        c = row3.createCell(5);
        c.setCellValue("Received");

        c = row3.createCell(6);
        c.setCellValue("25-07-2017");

        Row row4 = sheet1.createRow(4);

        c = row4.createCell(0);
        c.setCellValue("4");

        c = row4.createCell(1);
        c.setCellValue("Nimusilide BP 1% w/w | Cream | 250 gm");

        c = row4.createCell(2);
        c.setCellValue("123");

        c = row4.createCell(3);
        c.setCellValue("75.00");

        c = row4.createCell(4);
        c.setCellValue("25-07-2017");

        c = row4.createCell(5);
        c.setCellValue("Received");

        c = row4.createCell(6);
        c.setCellValue("25-07-2017");

        sheet1.setColumnWidth(0, (15 * 500));
        sheet1.setColumnWidth(1, (15 * 500));
        sheet1.setColumnWidth(2, (15 * 500));
        sheet1.setColumnWidth(3, (15 * 500));
        sheet1.setColumnWidth(4, (15 * 500));
        sheet1.setColumnWidth(5, (15 * 500));
        sheet1.setColumnWidth(6, (15 * 500));

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
