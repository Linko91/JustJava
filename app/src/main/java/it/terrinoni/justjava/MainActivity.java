package it.terrinoni.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    private int quantity = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder (View view) {
        String msg = createOrderSummary(5);
        displayMessage(msg);
    }

    /**
     * Increments the quantity value.
     *
     * @param view
     */
    public void increment (View view) {
        display(++quantity);
    }

    /**
     * Decrements the quantity value.
     *
     * @param view
     */
    public void decrement (View view) {
        display(--quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage (String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Creates and order summary.
     *
     * @param price
     * @return
     */
    private String createOrderSummary (int price) {
        CheckBox chkBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        String msg = "Name: Captain Terry\nAdd whipped cream? " +
                String.valueOf(chkBox.isChecked()) + "\nQuantity: " + String.valueOf(quantity) +
                "\nTotal: " + (quantity * price) + " €\nThank you";
        return msg;
    }
}
