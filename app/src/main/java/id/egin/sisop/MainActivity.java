package id.egin.sisop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Sisop> listOs = new ArrayList<Sisop>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        final CustomAdapter mAdapter = new CustomAdapter(this, listOs);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.notifyDataSetChanged();

        Button btnRefresh = findViewById(R.id.btn_refresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Refresh Data...", Toast.LENGTH_SHORT).show();
                listOs.clear();
                loadData();
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    void loadData() {
        // populasikan nama Sisop di sini
        listOs.add(new Sisop("Android", R.drawable.android_logo));
        listOs.add(new Sisop("iPhone", R.drawable.iphone_logo));
        listOs.add(new Sisop("windowsMobile", R.drawable.windowsmobile_logo));
        listOs.add(new Sisop("BlackBerry", R.drawable.blackberry_logo));
        listOs.add(new Sisop("WebOS", R.drawable.webos_logo));
        listOs.add(new Sisop("Ubuntu", R.drawable.ubuntu_logo));
        listOs.add(new Sisop("Windows7", R.drawable.windows7_logo));
        listOs.add(new Sisop("MacOS", R.drawable.macos_logo));
    }
}