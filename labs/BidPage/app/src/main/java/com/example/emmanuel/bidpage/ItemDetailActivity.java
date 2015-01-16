package com.example.emmanuel.bidpage;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Observable;
import java.util.Observer;

public class ItemDetailActivity extends ActionBarActivity implements View.OnClickListener {

    private ItemDetailModel model = new ItemDetailModel();
    private ItemDetailView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = (ItemDetailView) View.inflate(this, R.layout.main_view, null);
        setContentView(view);
        view.setButtonListener(this);

        model.setId(0);
        model.setName("Toaster");
        model.setShortDescription("toasty");
        model.setLongDescription("The most wickedly-awesome toaster in existence");
        model.setCurrentBid(0);
        model.addObserver(view);
    }

    public void onClick(View v) {
        model.setCurrentBid(model.getCurrentBid() + 1);
    }
}
