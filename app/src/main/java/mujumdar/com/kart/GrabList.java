package mujumdar.com.kart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class GrabList extends AppCompatActivity {

    private Integer count;

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
        Button addButton = new Button(this);
        addButton.setText("ADD");
        addButton.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.1f));
        computeRow.addView(addButton);
        TextView totalLabel = new TextView(this);
        totalLabel.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.6f));
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
        final TableLayout itemsTable = new TableLayout(this);
        itemsTable.setId(Integer.parseInt(getString(R.string.item_list_id)));
        itemsView.addView(itemsTable);
        parentLayout.addView(itemsView);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow tr = new TableRow(GrabList.this);
                TextView field = new TextView(GrabList.this);
                field.setText("Item " + count);
                field.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
                tr.addView(field);
                TextView amt = new TextView(GrabList.this);
                amt.setText("Item " + count);
                amt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
                tr.addView(amt);
                itemsTable.addView(tr);
                count++;
            }
        });
        /*parentLayout.addView(webView);
        setContentView(parentLayout);*/
    }
}
