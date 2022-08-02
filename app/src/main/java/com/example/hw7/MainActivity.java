package com.example.hw7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewCounty,imageViewFood;
    private int CountyId = R.id.taipei;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set ImageView id:
        //a ImageView to display the picture of county
        imageViewCounty=(ImageView) findViewById(R.id.imageView_county);
        //a ImageView to display the picture of food in different country
        imageViewFood=(ImageView) findViewById(R.id.imageView_food);

        //Set context menu:
//        registerForContextMenu(imageViewCounty);
        registerForContextMenu(imageViewFood);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.setup,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        CountyId =item.getItemId();
        switch (CountyId){
            case R.id.taipei:
                imageViewCounty.setImageResource(R.drawable.taipei);
                break;
            case R.id.hsinchu:
                imageViewCounty.setImageResource(R.drawable.hsinchu);
                break;
            case R.id.taoyuan:
                imageViewCounty.setImageResource(R.drawable.taoyuan);
                break;

        }
        imageViewFood.setImageResource(R.drawable.ic_launcher_background);
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        if(v.getId()==R.id.imageView_food){
           getMenuInflater().inflate(R.menu.textview_food,menu);
//            this.menu=menu;
            updateMenuTitle(menu);
//        }
    }

    private void updateMenuTitle(Menu menu){
        MenuItem item = menu.findItem(R.id.menu_food1);
        MenuItem item2 = menu.findItem(R.id.menu_food2);
        MenuItem item3 = menu.findItem(R.id.menu_food3);
        String[] foodArray = null;
        switch (CountyId){
            case R.id.taipei:
                foodArray=getResources().getStringArray(R.array.taipei_food);
                break;
            case R.id.taoyuan:
                foodArray=getResources().getStringArray(R.array.taoyuan_food);
                break;
            case R.id.hsinchu:
                foodArray=getResources().getStringArray(R.array.hsinchu_food);
                break;
        }
        Log.d("main","food1="+foodArray[0]);
        Log.d("main","food1="+foodArray[1]);
        Log.d("main","food1="+foodArray[2]);

        item.setTitle(foodArray[0]);
        item2.setTitle(foodArray[1]);
        item3.setTitle(foodArray[2]);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int FoodId=item.getItemId();
        setFoodPicture(CountyId,FoodId);
        return super.onContextItemSelected(item);
    }

    public void setFoodPicture(int countyName,int foodName){
        if(countyName==R.id.taipei){
            switch (foodName){
                case R.id.menu_food1:
                    imageViewFood.setImageResource(R.drawable.tp1);
                    break;
                case R.id.menu_food2:
                    imageViewFood.setImageResource(R.drawable.tp2);
                    break;
                case R.id.menu_food3:
                    imageViewFood.setImageResource(R.drawable.tp3);
                    break;
            }
        }else if(countyName==R.id.taoyuan){
            switch (foodName){
                case R.id.menu_food1:
                    imageViewFood.setImageResource(R.drawable.t1);
                    break;
                case R.id.menu_food2:
                    imageViewFood.setImageResource(R.drawable.t2);
                    break;
                case R.id.menu_food3:
                    imageViewFood.setImageResource(R.drawable.t3);
                    break;
            }
        }else {
            switch (foodName) {
                case R.id.menu_food1:
                    imageViewFood.setImageResource(R.drawable.h1);
                    break;
                case R.id.menu_food2:
                    imageViewFood.setImageResource(R.drawable.h2);
                    break;
                case R.id.menu_food3:
                    imageViewFood.setImageResource(R.drawable.h3);
                    break;
            }
        }
    }

}