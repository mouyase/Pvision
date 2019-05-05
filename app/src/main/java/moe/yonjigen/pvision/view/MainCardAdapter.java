package moe.yonjigen.pvision.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import moe.yonjigen.pvision.PvisionData;
import moe.yonjigen.pvision.R;
import moe.yonjigen.pvision.databinding.CardMainBinding;
import moe.yonjigen.pvision.model.MainCardModel;
import moe.yonjigen.pvision.utils.ImageUtil;

public class MainCardAdapter extends RecyclerView.Adapter<MainCardAdapter.ViewHolder> {
    private List<MainCardModel> cardModelList;
    private Context context;
    private static LazyHeaders lazyHeaders = new LazyHeaders.Builder()
            .setHeader("Referer", PvisionData.REFERER)
            .setHeader("User-Agent", PvisionData.USER_AGENT)
            .build();

    /**
     * @param context       上下文
     * @param cardModelList 数据源
     */
    MainCardAdapter(Context context, List<MainCardModel> cardModelList) {
        this.cardModelList = cardModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardMainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.card_main, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setCard(cardModelList.get(position));
        holder.binding.executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return cardModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardMainBinding binding;

        ViewHolder(CardMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        GlideUrl glideUrl = new GlideUrl(url, lazyHeaders);
        Glide.with(imageView.getContext())
                .load(glideUrl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .override(Target.SIZE_ORIGINAL)
                .override(ImageUtil.getImageWidth(imageView), ImageUtil.getImageHeight(imageView))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }
}