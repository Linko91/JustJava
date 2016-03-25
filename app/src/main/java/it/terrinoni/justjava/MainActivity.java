package it.terrinoni.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    private int quantity = 0;
    private int priceWippedCream = 1;
    private int priceChocolate = 2;
    private int basePrice = 5;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder (View view) {
        // Retrieve the specified name
        EditText edtText = (EditText) findViewById(R.id.name_edit_text);
        String name = edtText.getText().toString();

        // Check if whipped cream is selected
        CheckBox chkBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        boolean hasWhippedCream = chkBox.isChecked();

        // Check if chocolate is selected
        chkBox = (CheckBox) findViewById(R.id.chocolate_check);
        boolean hasChocolate = chkBox.isChecked();

        int finalPrice = calculatePrice(hasWhippedCream, hasChocolate);

        // Show the message
        String msg = createOrderSummary(name, finalPrice, hasWhippedCream, hasChocolate);
        displayMessage(msg);
    }

    /**
     *
     * @param hasWhippedCream
     * @param hasChocolate
     * @return
     */
    private int calculatePrice (boolean hasWhippedCream, boolean hasChocolate) {
        int finalPrice = basePrice;
        if (hasWhippedCream) {
            finalPrice += priceWippedCream;
        }
        if (hasChocolate) {
            finalPrice += priceChocolate;
        }
        finalPrice *= quantity;

        return finalPrice;
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
     * @param finalPrice      of the order
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate    is whether or not the user wants whipped cream topping
     * @return text summary
     */
    private String createOrderSummary (String name, int finalPrice, boolean hasWhippedCream, boolean hasChocolate) {
        String msg = "Name: " + name + "\n" +
                "Add whipped cream? " + hasWhippedCream + "\n" +
                "Add chocolate? " + hasChocolate + "\n" +
                "Quantity: " + String.valueOf(quantity) + "\n" +
                "Total: " + String.valueOf(finalPrice) + " €\n" +
                "Thank you!";
        return msg;
    }
}
