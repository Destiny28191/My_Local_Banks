package sg.edu.rp.c346.id20022098.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String longclick ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");

        if (v == tvDBS) {
            longclick = "DBS";
        } else if (v == tvOCBC) {
            longclick = "OCBC";
        } else if (v == tvUOB) {
            longclick = "UOB";
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;

        } else if (id == R.id.ChineseSelection) {
            Toast.makeText(MainActivity.this, "Chinese is chosen", Toast.LENGTH_SHORT).show();
            tvDBS.setText("星展銀行");
            tvOCBC.setText("華僑銀行");
            tvUOB.setText("大華銀行");
            return true;

        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item) {
            if(longclick.equalsIgnoreCase("DBS")){
                String phone = "18001111111";
                String url = "https://www.dbs.com.sg/personal/default.page";

                if (item.getItemId() == 0) {
                    Intent URL = new Intent(Intent.ACTION_VIEW);
                    URL.setData(Uri.parse(url));
                    startActivity(URL);

                    return true;

                }
                else if (item.getItemId() == 1) {
                    Intent Phone = new Intent(Intent.ACTION_DIAL);
                    Phone.setData(Uri.parse("tel: " + phone));
                    startActivity(Phone);

                    return true;

                }
            }

        if(longclick.equalsIgnoreCase("OCBC")){
            String phone = "18003633333";
            String url = "https://www.ocbc.com/personal-banking/home";

            if (item.getItemId() == 0) {
                Intent URL = new Intent(Intent.ACTION_VIEW);
                URL.setData(Uri.parse(url));
                startActivity(URL);

                return true;

            }
            else if (item.getItemId() == 1) {
                Intent Phone = new Intent(Intent.ACTION_DIAL);
                Phone.setData(Uri.parse("tel: " + phone));
                startActivity(Phone);

                return true;

            }
        }

        if(longclick.equalsIgnoreCase("UOB")){
            String phone = "18002222121";
            String url = "https://www.uob.com.sg/personal/index.page";

            if (item.getItemId() == 0) {
                Intent URL = new Intent(Intent.ACTION_VIEW);
                URL.setData(Uri.parse(url));
                startActivity(URL);

                return true;

            }
            else if (item.getItemId() == 1) {
                Intent Phone = new Intent(Intent.ACTION_DIAL);
                Phone.setData(Uri.parse("tel: " + phone));
                startActivity(Phone);

                return true;

            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

}