package com.example.viewgroups_sharedpref_appbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(this.<Toolbar>findViewById(R.id.my_toolbar));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open_notes:
                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent);
                break;
            case R.id.action_open_addresses:
                 intent = new Intent(MainActivity.this, AddressesActivity.class);
                startActivity(intent);
                break;
            case R.id.action_open_jellyfish:
                intent = new Intent(MainActivity.this, SplashScreenActivity.class);
                startActivity(intent);
                break;
            case R.id.action_open_payment:
                intent = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(intent);
                break;
            case R.id.action_open_subscription:
                intent = new Intent(MainActivity.this, SubscriptionActivity.class);
                startActivity(intent);
                break;
            case R.id.action_open_tasks:
                intent = new Intent(MainActivity.this, TasksActivity.class);
                startActivity(intent);
                break;
            case R.id.action_open_view:
                intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Settings activity", Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }


}
