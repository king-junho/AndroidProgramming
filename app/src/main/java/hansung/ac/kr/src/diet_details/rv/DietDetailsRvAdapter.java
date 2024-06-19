package hansung.ac.kr.src.diet_details.rv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import hansung.ac.kr.databinding.ItemDietDetailsBinding;
import java.util.ArrayList;
public class DietDetailsRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DietDetailsDataClass> dataSet;
    private OnItemClickListener itemClickListener;

    public DietDetailsRvAdapter(ArrayList<DietDetailsDataClass> dataSet) {
        this.dataSet = dataSet;
    }

    public interface OnItemClickListener {
        void onClick(int position, int addAmount);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDietDetailsBinding binding = ItemDietDetailsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DietDetailsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DietDetailsViewHolder) {
            ((DietDetailsViewHolder) holder).bind(dataSet.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class DietDetailsViewHolder extends RecyclerView.ViewHolder {

        private ItemDietDetailsBinding binding;

        DietDetailsViewHolder(ItemDietDetailsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.itemDietDetailsChbBreakfastRice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), 7);
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -7);
                    }
                }
            });

            binding.itemDietDetailsChbBreakfast.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.d("weagwaegewag", getAdapterPosition() + " ," + b);
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), Integer.parseInt(dataSet.get(getAdapterPosition()).getBreakFast().split("\\?")[1]));
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -Integer.parseInt(dataSet.get(getAdapterPosition()).getBreakFast().split("\\?")[1]));
                    }
                }
            });

            binding.itemDietDetailsChbLunchRice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), 7);
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -7);
                    }
                }
            });

            binding.itemDietDetailsChbLunch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), Integer.parseInt(dataSet.get(getAdapterPosition()).getLunch().split("\\?")[1]));
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -Integer.parseInt(dataSet.get(getAdapterPosition()).getLunch().split("\\?")[1]));
                    }
                }
            });

            binding.itemDietDetailsChbDinnerRice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), 7);
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -7);
                    }
                }
            });

            binding.itemDietDetailsChbDinner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.d("weagwaegewag", getAdapterPosition() + " ," + b);
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), Integer.parseInt(dataSet.get(getAdapterPosition()).getDinner().split("\\?")[1]));
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -Integer.parseInt(dataSet.get(getAdapterPosition()).getDinner().split("\\?")[1]));
                    }
                }
            });

            binding.itemDietDetailsChbSnack1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.d("weagwaegewag", getAdapterPosition() + " ," + b);
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), Integer.parseInt(dataSet.get(getAdapterPosition()).getSnack_1().split("\\?")[1]));
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -Integer.parseInt(dataSet.get(getAdapterPosition()).getSnack_1().split("\\?")[1]));
                    }
                }
            });

            binding.itemDietDetailsChbSnack2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.d("weagwaegewag", getAdapterPosition() + " ," + b);
                    if (b) {
                        itemClickListener.onClick(getAdapterPosition(), Integer.parseInt(dataSet.get(getAdapterPosition()).getSnack_2().split("\\?")[1]));
                    } else {
                        itemClickListener.onClick(getAdapterPosition(), -Integer.parseInt(dataSet.get(getAdapterPosition()).getSnack_2().split("\\?")[1]));
                    }
                }
            });
        }

        void bind(DietDetailsDataClass item) {
            binding.itemDietDetailsTvMonth.setText(item.getMonth() + "." + item.getDay());
            binding.itemDietDetailsTvBreakfastContent.setText(item.getBreakFast().split("\\?")[0]);
            binding.itemDietDetailsTvLunchContent.setText(item.getLunch().split("\\?")[0]);
            binding.itemDietDetailsTvDinnerContent.setText(item.getDinner().split("\\?")[0]);

            if (item.getSnack_1().contains("?")) {
                binding.itemDietDetailsLayoutSnack1.setVisibility(View.VISIBLE);
                binding.itemDietDetailsTvSnack1Content.setText(item.getSnack_1().split("\\?")[0]);
            } else {
                binding.itemDietDetailsLayoutSnack1.setVisibility(View.GONE);
            }

            if (item.getSnack_2().contains("?")) {
                binding.itemDietDetailsLayoutSnack2.setVisibility(View.VISIBLE);
                binding.itemDietDetailsTvSnack2Content.setText(item.getSnack_2().split("\\?")[0]);
            } else {
                binding.itemDietDetailsLayoutSnack2.setVisibility(View.GONE);
            }
        }
    }
}