package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//add unambiguous imports on the fly
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private TextView quantityTV;
    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTV = (TextView)findViewById(R.id.quantity_text_view);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int quantity =Integer.parseInt(quantityTV.getText().toString());
        display(quantity);
        displayPrice(quantity*5);
    }

    /**
     * This method displays the given price on the screen.
     * see
     * https://gist.github.com/anonymous/fa134c55a4a43e8d6004
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number) + "\nThank You!");
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /*
     * increment or decrement the number of coffees
     * must be public !
     */
    public void increment(View view) {
        quantity++;
        quantityTV.setText(new Integer(quantity).toString());
    }

    public void decrement(View view) {
        quantity--;
        quantityTV.setText(new Integer(quantity).toString());
    }

    /**
     * From Udacity
     * This method displays the given text on the screen.
     * https://gist.github.com/anonymous/f5feae51009b9f8bc956
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}