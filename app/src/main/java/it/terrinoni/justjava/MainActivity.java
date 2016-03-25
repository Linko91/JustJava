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
        CheckBox chkBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        boolean hasWhippedCream = chkBox.isChecked();
        chkBox = (CheckBox) findViewById(R.id.choccolate_check);
        boolean hasChocolate = chkBox.isChecked();
        String msg = createOrderSummary(5, hasWhippedCream, hasChocolate);
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
     * @param price of the order
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants whipped cream topping
     * @return text summary
     */
    private String createOrderSummary (int price, boolean hasWhippedCream, boolean hasChocolate) {
        String msg = "Name: Captain Terry\n";
        msg += "Add whipped cream? " + hasWhippedCream + "\n";
        msg += "Add chocolate? " + hasChocolate + "\n";
        msg += "Quantity: " + String.valueOf(quantity) + "\n";
        msg += "Total: " + (quantity * price) + " €\n";
        msg += "Thank you!";
        return msg;
    }
}
