package com.livinglifetechway.example.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    LinearLayoutManager mLinearLayoutManager;

    TestAdapter mTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Recycler View by id from layout file
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Create Linear Layout Manager which defines how it will be shown on the screen
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // Set Layout Manager in the RecyclerView
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        // Create Adapter object from the data by calling default Constructor
        mTestAdapter = new TestAdapter(getTestListItems());

        // Set RecyclerView Adapter
        mRecyclerView.setAdapter(mTestAdapter);

        // Done! Hooray !!

    }

    private class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

        private ArrayList<String> myList;

        public TestAdapter(ArrayList<String> list) {
            this.myList = list;
        }

        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View itemView = LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.rcv_viewholder, parent, false);

            return new TestViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(TestViewHolder holder, int position) {
            String itemText = myList.get(position);
            holder.vText.setText(itemText);
        }

        @Override
        public int getItemCount() {
            return myList.size();
        }

        public class TestViewHolder extends RecyclerView.ViewHolder {
            protected TextView vText;

            public TestViewHolder(View itemView) {
                super(itemView);
                vText = (TextView) itemView.findViewById(R.id.text);
            }
        }
    }

    private ArrayList<String> getTestListItems() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("Item " + i);
        }
        return list;
    }
}
