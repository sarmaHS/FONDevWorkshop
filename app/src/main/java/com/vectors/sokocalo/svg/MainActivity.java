package com.vectors.sokocalo.svg;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import java.util.ArrayList;

public class MainActivity extends ListActivity implements View.OnClickListener{

    SimpleCursorAdapter mAdapter;

    String [] noteContent = {"FIRST", "SECOND","THIRD", "FOURTH"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyData myDataArray[]=new MyData[]{
                new MyData("item1",10),
                new MyData("item2",20),
                new MyData("item3",30)
        };
      /*  ArrayAdapter<String> myAdapter=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                noteContent);
        ListView myList=getListView();
        myList.setAdapter(myAdapter);*/

        MyAdapter myAdapter=new
                MyAdapter( this,
                R.layout.mylayout,
                myDataArray);
        ListView myList =
               getListView();
        myList.setAdapter(myAdapter);

        Button bNewNote = findViewById(R.id.bNewNote);
        // TODO alternativa od this
        bNewNote.setOnClickListener(this);

        // events when clicking an item
      /*  AdapterView.OnItemClickListener mMessageClickedHandler =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent,
                                            View v,
                                            int position,
                                            long id) {
                        ((TextView)v).setText("selected");
                    }
                };

        myList.setOnItemClickListener(
                mMessageClickedHandler);*/

        //n ************************ notifikacije Pormena Podataka *********************** \\
        /*noteContent[0]="newdata";

        ArrayAdapter myAdapt=
                (ArrayAdapter) myList.getAdapter();
        myAdapt.notifyDataSetChanged();*/

        // **************** Array List ***************** \\
        ArrayList<String> myArrayList=
                new ArrayList<String>();

        /*ArrayAdapter<String> myAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        myArrayList);
        myAdapt.add("new data");*/


        /*As long as you are using an ArrayList you are safe to use all of the adapter data modifying methods:
add(item)
addAll(item1,item2,item3...)
clear() //remove all data
insert(item,position)
remove(item)
You can also make use of
getCount() //get number of elements
getItem(position) // get item
getItemId(position) //get item id
and
getPosition(item)*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case  R.id.bNewNote:
                Intent intentNewNote = new Intent(this, NewNoteActivity.class);
                startActivity(intentNewNote);
                break;
            //about us dugme izbrisati nakon dodavanja list view-a
            /*case R.id.bAboutUs:

                Intent intentAboutUs = new Intent(this, AboutUsActivity.class);
                startActivity(intentAboutUs);
                break;*/

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuAboutUs:
                Intent intentAboutUs = new Intent(this, AboutUsActivity.class);
                startActivity(intentAboutUs);
                break;
            case R.id.menuSettings:
                Intent intentSettings = new Intent(this, SettingsActivity.class);
                startActivity(intentSettings);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }


}