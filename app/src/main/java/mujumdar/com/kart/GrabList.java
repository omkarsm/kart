package mujumdar.com.kart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class GrabList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout parentLayout = new RelativeLayout(this);
        parentLayout.setBackgroundColor(Color.WHITE);
        parentLayout.setGravity(Gravity.CENTER);
        parentLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        TableLayout computedLayout = new TableLayout(this);
        computedLayout.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.MATCH_PARENT));
        TableRow computeRow = new TableRow(this);
        TextView totalLabel = new TextView(this);
        totalLabel.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        totalLabel.setText("Total");
        computeRow.addView(totalLabel);
        TextView totalValue = new TextView(this);
        totalValue.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.3f));
        totalValue.setText("0");
        totalValue.setId(Integer.parseInt(getString(R.string.compute_id)));
        computeRow.addView(totalValue);
        computedLayout.addView(computeRow);
        parentLayout.addView(computedLayout);

        ScrollView itemsView = new ScrollView(this);
        itemsView.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
        itemsView.setFillViewport(true);
        TableLayout itemsTable = new TableLayout(this);
        itemsTable.setId(Integer.parseInt(getString(R.string.item_list_id)));
        itemsView.addView(itemsTable);
        parentLayout.addView(itemsView);

        /*parentLayout.addView(webView);
        setContentView(parentLayout);*/
    }
}
