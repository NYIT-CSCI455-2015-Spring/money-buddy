package edu.nyit.grella.moneybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Anthony Bertolino on 2/27/2015.
 */
public class Wishlist extends ActionBarActivity implements View.OnClickListener {

    TextView itemTextView;
    TextView costTextView;

    Button addButton;

    EditText itemEditText;
    EditText costEditText;

    ListView itemListView;
    ArrayAdapter iArrayAdapter;
    ArrayList iNameList = new ArrayList();

    ListView costListView;
    ArrayAdapter cArrayAdapter;
    ArrayList cNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        // 1. Access the TextViews defined in layout XML
        // and then set its text
        itemTextView = (TextView) findViewById(R.id.item_textView);
        itemTextView.setText("item");
        costTextView = (TextView) findViewById(R.id.cost_textView);
        costTextView.setText("cost");

        // 2. Access the Button defined in layout XML
        // and listen for it here
        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(this);

        // 3. Access the EditTexts defined in layout XML
        itemEditText = (EditText) findViewById(R.id.item_edittext);
        costEditText = (EditText) findViewById(R.id.cost_edittext);

        // 4. Access the ListViews
        itemListView = (ListView) findViewById(R.id.item_listView);
        costListView = (ListView) findViewById(R.id.cost_listView);

        // Create ArrayAdapters for the ListViews
        iArrayAdapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        iNameList);
        cArrayAdapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        cNameList);

        // Set the ListViews to use the ArrayAdapter
        itemListView.setAdapter(iArrayAdapter);
        costListView.setAdapter(cArrayAdapter);
    }

    public void homebtnOnClick(View v) {
        Button homebtn = (Button) v;
        startActivity(new Intent(getApplicationContext(), HomeScreen.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wishlist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // Take what was typed into the EditTexts
        // and use in the TextViews
        itemTextView.setText("Item");
        costTextView.setText("Cost");

        // Also add that value to the lists shown in the ListViews
        iNameList.add(itemEditText.getText().toString());
        iArrayAdapter.notifyDataSetChanged();
        cNameList.add("$" + costEditText.getText().toString());
        cArrayAdapter.notifyDataSetChanged();
    }
}
