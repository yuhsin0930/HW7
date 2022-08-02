package com.example.hw7;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewCounty,imageViewFood;
    private MenuItem menuFood1,menuFood2,menuFood3;
    private int county=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewCounty = (ImageView)findViewById(R.id.imageView_county);
        imageViewFood = (ImageView)findViewById(R.id.imageView_food);

        registerForContextMenu(imageViewFood);
        ActionBar actBar = getSupportActionBar();
        actBar.setBackgroundDrawable(new ColorDrawable(0xFF808080));

    }
//////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.setup,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        county=item.getItemId();
        switch (county){
            case R.id.taipei:
                imageViewCounty.setImageResource(R.drawable.taipei);
                break;

            case R.id.taoyuan:
                imageViewCounty.setImageResource(R.drawable.taoyuan);
                break;

            case R.id.hsinchu:
                imageViewCounty.setImageResource(R.drawable.hsinchu);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.imageView_food){
            switch(county){
                case R.id.taipei:
                    getMenuInflater().inflate(R.menu.textview_food,menu);
                    break;

                case R.id.taoyuan:
                    getMenuInflater().inflate(R.menu.textview_food2,menu);
                    break;

                case R.id.hsinchu:
                    getMenuInflater().inflate(R.menu.textview_food3,menu);
                    break;

            }

        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (county){
            case R.id.taipei:
                switch(item.getItemId()) {
                    case R.id.menu_food1:
                        imageViewFood.setImageResource(R.drawable.taipei_food1);
                        break;
                    case R.id.menu_food2:
                        imageViewFood.setImageResource(R.drawable.taipei_food2);
                        break;
                    case R.id.menu_food3:
                        imageViewFood.setImageResource(R.drawable.taipei_food3);
                        break;
                }
                break;

            case R.id.taoyuan:
                switch(item.getItemId()) {
                    case R.id.menu_food1:
                        imageViewFood.setImageResource(R.drawable.taoyuanfood1);
                        break;
                    case R.id.menu_food2:
                        imageViewFood.setImageResource(R.drawable.taoyuanfood2);
                        break;
                    case R.id.menu_food3:
                        imageViewFood.setImageResource(R.drawable.taoyuanfood3);
                        break;
                }
                break;

            case R.id.hsinchu:
                switch(item.getItemId()) {
                    case R.id.menu_food1:
                        imageViewFood.setImageResource(R.drawable.hsinchufood1);
                        break;
                    case R.id.menu_food2:
                        imageViewFood.setImageResource(R.drawable.hsinchufood2);
                        break;
                    case R.id.menu_food3:
                        imageViewFood.setImageResource(R.drawable.hsinchufood3);
                        break;
                }
                break;

        }
        return super.onContextItemSelected(item);
    }
}
