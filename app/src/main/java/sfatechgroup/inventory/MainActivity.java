package sfatechgroup.inventory;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sfatechgroup.inventory.adapter.NotificationAdapter;
import sfatechgroup.inventory.model.DetailsModel;

public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    Context context;
    Intent intent;
    TextView userNotification;
    RecyclerView recyclerView;
    NotificationAdapter adapter;
    List<DetailsModel> detailsModels = new ArrayList<>();
    Menu nav_Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        mNavigationView.setItemIconTintList(null);
        nav_Menu = mNavigationView.getMenu();

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(LoginActivity.selectedLoginType.equalsIgnoreCase("Dealer")) {
            mFragmentTransaction.replace(R.id.containerView, new sfatechgroup.inventory.dealer.HomeFragment_Dealer()).commit();

            nav_Menu.findItem(R.id.nav_item_home).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_dealer_orders).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_change_pass).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_update_profile).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_logout).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_rate_contract).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_notification).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_local_purchase).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_avail_stock).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_supply_history).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_purchase_orders).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_lab_test).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_vendor_list).setVisible(false);
            nav_Menu.findItem(R.id.nav_drugwise_request).setVisible(false);
            nav_Menu.findItem(R.id.nav_institutewise_request).setVisible(false);
            nav_Menu.findItem(R.id.nav_indent_history).setVisible(false);
        }
        else {
            mFragmentTransaction.replace(R.id.containerView, new sfatechgroup.inventory.fragment.HomeFragment()).commit();

            nav_Menu.findItem(R.id.nav_item_home).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_dealer_orders).setVisible(false);
            nav_Menu.findItem(R.id.nav_item_change_pass).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_update_profile).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_logout).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_rate_contract).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_notification).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_local_purchase).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_avail_stock).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_supply_history).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_purchase_orders).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_lab_test).setVisible(true);
            nav_Menu.findItem(R.id.nav_item_vendor_list).setVisible(true);
            nav_Menu.findItem(R.id.nav_drugwise_request).setVisible(true);
            nav_Menu.findItem(R.id.nav_institutewise_request).setVisible(true);
            nav_Menu.findItem(R.id.nav_indent_history).setVisible(true);
        }
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.nav_item_home) {
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView, new sfatechgroup.inventory.fragment.HomeFragment()).commit();
                } else if (menuItem.getItemId() == R.id.nav_item_rate_contract) {
                    intent = new Intent(context, RateContractActivity.class);
                    startActivity(intent);
                } else if (menuItem.getItemId() == R.id.nav_item_local_purchase) {
                    intent = new Intent(context, LocalPurchaseActivity.class);
                    startActivity(intent);
                }else if (menuItem.getItemId() == R.id.nav_drugwise_request) {
                    intent = new Intent(context, ReceivedIndentsActivity.class);
                    intent.putExtra("param","DrugWise");
                    startActivity(intent);
                }else if (menuItem.getItemId() == R.id.nav_institutewise_request) {
                    intent = new Intent(context, ReceivedIndentsActivity.class);
                    intent.putExtra("param","InstituteWise");
                    startActivity(intent);
                }else if (menuItem.getItemId() == R.id.nav_item_update_profile) {
                    intent = new Intent(context, UpdateProfileActivity.class);
                    startActivity(intent);
                }
               /* else if (menuItem.getItemId() == R.id.nav_sendto_division) {
                    intent = new Intent(context, SendIndentToDivisionActivity.class);
                    intent.putExtra("param","SendToDivision");
                    startActivity(intent);
                } */
               /* else if (menuItem.getItemId() == R.id.nav_indent_history) {
                    intent = new Intent(context, SendIndentToDivisionActivity.class);
                    intent.putExtra("param","IndentHistory");
                    startActivity(intent);
                }*/
               else if (menuItem.getItemId() == R.id.nav_item_lab_test) {
                    intent = new Intent(context, LabTestActivity.class);
                    startActivity(intent);
                }else if (menuItem.getItemId() == R.id.nav_item_purchase_orders) {
                    intent = new Intent(context, PurchaseOrdersActivity.class);
                    startActivity(intent);
                } else if (menuItem.getItemId() == R.id.nav_item_change_pass) {
                    intent = new Intent(context, ChangePasswordActivity.class);
                    startActivity(intent);
                } else if (menuItem.getItemId() == R.id.nav_item_avail_stock) {
                    intent = new Intent(context, AvailableStockActivity.class);
                    startActivity(intent);
                } else if (menuItem.getItemId() == R.id.nav_item_supply_history) {
                    intent = new Intent(context, SupplyHistoryActivity.class);
                    startActivity(intent);
                } else if (menuItem.getItemId() == R.id.nav_item_notification) {
                    showCustomView();
                }
                else if (menuItem.getItemId() == R.id.nav_indent_history) {
                    intent = new Intent(context, SentIndentHistory.class);
                    startActivity(intent);
                }
                else if (menuItem.getItemId() == R.id.nav_item_update_profile) {
                    intent = new Intent(context, UpdateProfileActivity.class);
                    startActivity(intent);
                }
                return false;
            }

        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome User");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        userNotification = (TextView) findViewById(R.id.userNotification);
        userNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomView();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
    }


    public void showCustomView() {
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_notification);
        // Custom Android Allert Dialog Title
        detailsModels = new ArrayList<>();
        recyclerView = (RecyclerView) dialog.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NotificationAdapter(detailsModels, getApplicationContext());
        recyclerView.setAdapter(adapter);

        detailsModels.add(new DetailsModel("Acriflavin Powder BP 5 gm","Acriflavin Powder BP 5 gm - Order dispatched. Your package has been shipped. ", "phormocopial", "Powder", "25 gm/Pouch", "115"));
        detailsModels.add(new DetailsModel("Albendazole IP 25mg/ml ","Cefoperazone Sodium I.P. 3 gm + Sulbactam Sodium USP 1.5 gm/ Vial with distil water (Medicine Code MD-53) are out of stock", "allopathy", "Liquid", "120ml/Bottle", "12.7"));

        Button btnClose = dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
