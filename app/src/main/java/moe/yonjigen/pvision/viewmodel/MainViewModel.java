package moe.yonjigen.pvision.viewmodel;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import moe.yonjigen.pvision.PvisionData;
import moe.yonjigen.pvision.model.MainCardModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<List<MainCardModel>> mliveCardModelList = new MutableLiveData<>();
    Application mApplication;
    Handler mHandler = new Handler();

    public MainViewModel(@NonNull Application application) {
        super(application);
        mApplication = application;
        getCardListData();
    }

    public MutableLiveData<List<MainCardModel>> getLiveCardModelList() {
        return mliveCardModelList;
    }

    private void getCardListData() {
        String url = "https://www.pixivision.net/zh/";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .removeHeader("User-Agent")
                .addHeader("User-Agent", PvisionData.USER_AGENT)
                .addHeader("Accept-Language", PvisionData.ACCEPT_LANGUAGE)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) {
                mHandler.post(() -> {
                    try {
                        String html = response.body().string();
                        Elements elements = Jsoup.parse(html).body().select("article._article-card.spotlight");
                        List<MainCardModel> cardModelList = new ArrayList<>();
                        for (Element element : elements) {
                            MainCardModel mainCardModel = new MainCardModel();
                            mainCardModel.setTitle(element.selectFirst("a.gtm__act-ClickTitle").text());
                            mainCardModel.setCategory(element.selectFirst("span.arcsp__thumbnail-label._category-label.large.spotlight").text());
                            mainCardModel.setImageUrl(element.selectFirst("img.thm__image.lazyload").attr("data-src"));
                            cardModelList.add(mainCardModel);
                        }
                        mliveCardModelList.setValue(cardModelList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }
}
