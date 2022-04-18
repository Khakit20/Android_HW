package com.example.recyclerview;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mWordList = new LinkedList<>();
    private final LinkedList<String> mWordList1 = new LinkedList<>();
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private WordListAdapter mAdapter1;
    String[] title = {"月亮蝦餅","爆炒牛肉","番茄炒蛋","炒高麗菜","炒地瓜葉","水煮牛肉","小炒羊肉"};
    String[] recipe = {"油鍋倒入適量的油，加熱至160度左右，放入月亮蝦餅，以中火油炸到蝦餅浮起來後，再翻至另一面油炸，待兩面都炸到金黃酥脆後即可上桌","熱炒店經典好菜「爆炒牛肉」，滑嫩噴香的肉絲配上洋蔥的脆口，只要這一道就超級下飯"
    ,"番茄炒蛋的備料，建議食材比例「番茄：雞蛋=1:2～1：3」最剛好，喜歡蛋多一點的就用1：3。 用牛番茄的顏色會比台灣番茄更鮮豔紅潤。","炒高麗菜料理怎麼做？愛料理精選945篇簡易食譜做法與步驟，有最新的炒高麗菜","首先，先在炒鍋裡加入適量的油，等到達油溫之後，下薑片爆香，之後再下蒜頭，特別提醒，薑片和蒜頭不能同時下鍋，因為油溫高，會使蒜頭變黑變苦。 等蒜頭稍微變色後加入地瓜葉，並淋上「熱開水或熱高湯」拌炒，起鍋之前，再依個人口味酌加鹽調味。",
    "水煮牛是數一數二有名的川菜，作法其實不難，只要食材準備齊全，人人都可以做出嚇死大家的宴客菜！ 自己煮的好處就是，可以調整喜歡的辣度、鹹度","小炒羊肉的做法菜谱为您推荐大图正宗的小炒羊肉的家常做法，小炒羊肉的做法步骤图解，更多家常小炒羊肉怎么做好吃的窍门分享就来美食杰菜谱大全。"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                mRecyclerView.getAdapter().notifyItemChanged(wordListSize);
            }
        });
        for(int i = 0 ; i < 7 ; i ++){
            mWordList.addLast("\n\n"+title[i]);
            mWordList1.addLast(""+recipe[i]);
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, mWordList,mWordList1);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}