package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    public WordListAdapter(Context context, LinkedList<String> wordlist , LinkedList<String> recipe) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordlist;
        this.mWordList1 = recipe;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView =  mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        String mCurrenT = mWordList1.get(position);
        holder.wordItemView.setText(mCurrent);
        holder.wordItemView1.setText(mCurrenT);
    }
    private final LinkedList<String> mWordList1;
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public WordViewHolder(View itemView , WordListAdapter adapter) {
            super(itemView);
            wordItemView =  itemView.findViewById(R.id.title);
            wordItemView1 = itemView.findViewById(R.id.recipe);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
        public final TextView wordItemView;
        public final TextView wordItemView1;
        final WordListAdapter mAdapter;

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = mWordList.get(mPosition);
            // Change the word in the mWordList.
            if (mPosition == 0)
            {
                Intent intent = new Intent(view.getContext(),
                        Moon.class);
                view.getContext().startActivity(intent);
            }
            else if ( mPosition == 1)
            {
                Intent intent = new Intent(view.getContext(),
                        Cow.class);
                view.getContext().startActivity((intent));
            }
            else if ( mPosition == 2)
            {
                Intent intent = new Intent(view.getContext(),
                        Tomato.class);
                view.getContext().startActivity(intent);
            }
            else if ( mPosition == 3)
            {
                Intent intent = new Intent(view.getContext(),
                        High.class);
                view.getContext().startActivity(intent);
            }
            else if ( mPosition == 4)
            {
                Intent intent = new Intent(view.getContext(),
                        Ground.class);
                view.getContext().startActivity(intent);
            }
            else if ( mPosition == 5)
            {
                Intent intent = new Intent(view.getContext(),
                        Water.class);
                view.getContext().startActivity(intent);
            }
            else if ( mPosition == 6)
            {
                Intent intent = new Intent(view.getContext(),
                        Sheep.class);
                view.getContext().startActivity(intent);
            }
            // Notify the adapter that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}

