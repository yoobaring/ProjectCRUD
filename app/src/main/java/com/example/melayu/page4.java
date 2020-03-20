package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public  class page4 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Toast p1,p2,p3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
            {
                Intent p1 = new Intent(page4.this,StartingScreenActivity.class);
                startActivity(p1);
            }


            case R.id.item2:
            {
                Intent p2 = new Intent(page4.this,StartingScreenActivity2.class);
                startActivity(p2);
            }


            case R.id.item3:
            {
                Intent p3 = new Intent(page4.this,StartingScreenActivity3.class);
                startActivity(p3);
            }
            default:
                return false;
        }
    }
}
