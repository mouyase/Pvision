package moe.yonjigen.pvision.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import moe.yonjigen.pvision.R;
import moe.yonjigen.pvision.databinding.CardMainBinding;
import moe.yonjigen.pvision.model.MainCardModel;

public class MainCardAdapter extends RecyclerView.Adapter<MainCardAdapter.ViewHolder> {
    private List<MainCardModel> cardModelList;
    private Context context;

    public MainCardAdapter(Context context, List<MainCardModel> cardModelList) {
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setCard(cardModelList.get(position));
        holder.binding.executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return cardModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardMainBinding binding;

        public ViewHolder(CardMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}