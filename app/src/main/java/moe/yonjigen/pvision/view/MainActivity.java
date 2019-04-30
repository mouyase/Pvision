package moe.yonjigen.pvision.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import moe.yonjigen.pvision.R;
import moe.yonjigen.pvision.databinding.ActivityMainBinding;
import moe.yonjigen.pvision.model.MainCardModel;
import moe.yonjigen.pvision.model.MainModel;
import moe.yonjigen.pvision.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setMain(new MainModel());
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<MainCardModel> cardModelList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MainCardModel mainCardModel = new MainCardModel();
            mainCardModel.setTitle("啊啊啊啊啊" + i);
            cardModelList.add(mainCardModel);
        }
        recyclerView.setAdapter(new MainCardAdapter(this, cardModelList));
    }
}