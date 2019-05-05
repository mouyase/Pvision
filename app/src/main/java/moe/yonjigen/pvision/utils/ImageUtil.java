package moe.yonjigen.pvision.utils;

import android.content.Context;
import android.view.WindowManager;
import android.widget.ImageView;

public class ImageUtil {
    private static WindowManager mWindowManager;

    public static int getImageWidth(ImageView imageView) {
        mWindowManager = (WindowManager) imageView.getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        return mWindowManager.getDefaultDisplay().getWidth();
    }

    public static int getImageHeight(ImageView imageView) {
        mWindowManager = (WindowManager) imageView.getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        return mWindowManager.getDefaultDisplay().getWidth() * 381 / 238;
    }
}
