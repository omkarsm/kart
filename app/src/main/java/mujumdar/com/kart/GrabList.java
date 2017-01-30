package mujumdar.com.kart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import mujumdar.com.kart.adapter.ItemDataModel;
import mujumdar.com.kart.adapter.ItemsAdapter;

public class GrabList extends AppCompatActivity {

    private String TAG = "GrabList";
    private Integer count = 0;
    ItemsAdapter m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setBackgroundColor(Color.WHITE);
        parentLayout.setGravity(Gravity.CENTER);
        parentLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        TableLayout computedLayout = new TableLayout(this);
        computedLayout.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.MATCH_PARENT));
        TableRow computeRow = new TableRow(this);
        Button addButton = new Button(this);
        computeRow.setEnabled(true);
        addButton.setText("ADD");
        if (!addButton.isEnabled()) {
            Log.d(TAG, "Not Enabled");
            addButton.setEnabled(true);
        }
        if (!addButton.isClickable()) {
            Log.d(TAG, "Not Clickable");
            addButton.setClickable(true);
        }
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
//        itemsView.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
        itemsView.setFillViewport(true);
        ListView itemsTable = new ListView(this);
        ArrayList<ItemDataModel> itemsList = new ArrayList<ItemDataModel>();
        for (int i=0;i<30;i++){
            itemsList.add(new ItemDataModel("Item "+i, ""+(i*2)));
        }
        m_adapter = new ItemsAdapter(itemsList,this);
        itemsTable.setAdapter(m_adapter);

        itemsView.addView(itemsTable);
        parentLayout.addView(itemsView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Add Clicked "+count);
/*                TableRow tr = new TableRow(GrabList.this);
                TextView field = new TextView(GrabList.this);
                field.setText("Item " + count);
                field.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
                tr.addView(field);
                TextView amt = new TextView(GrabList.this);
                amt.setText("Item " + count);
                amt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
                tr.addView(amt);
                TableLayout table = (TableLayout) findViewById(Integer.parseInt(getString(R.string.item_list_id)));
                table.addView(tr);
                count++;*/
            }
        });
        setContentView(parentLayout);

    }
}
