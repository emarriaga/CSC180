package com.example.emmanuel.bidpage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class ItemDetailView extends LinearLayout implements Observer {
    private TextView description, textPrice;
    private Button bidBtn;

    public ItemDetailView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    public void setButtonListener(OnClickListener listener) {
        bidBtn.setOnClickListener(listener);
    }

    public void setTextPrice(int price) {
        textPrice.setText("Current Price: $" + price);
    }

    public void setDescription(String desc) {
        description.setText(desc);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        description = (TextView) findViewById(R.id.text_desc);
        textPrice = (TextView) findViewById(R.id.current_price);
        bidBtn = (Button) findViewById(R.id.bidBtn);
    }

    @Override
    public void update(Observable observable, Object data) {
        setTextPrice( ((ItemDetailModel) observable).getCurrentBid());
        setDescription( ((ItemDetailModel)observable).getLongDescription());
    }
}
