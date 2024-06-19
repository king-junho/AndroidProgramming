package hansung.ac.kr.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import hansung.ac.kr.databinding.DialogLoadingBinding;

public class LoadingDialog extends Dialog{

    private DialogLoadingBinding binding;

    public LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DialogLoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setCancelable(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}