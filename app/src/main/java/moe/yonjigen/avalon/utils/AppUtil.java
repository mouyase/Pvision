package moe.yonjigen.avalon.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 获取APP信息的工具类
 */
public class AppUtil {
    private static PackageManager packageManager;
    private static PackageInfo packageInfo;
    private static WindowManager windowManager;

    /**
     * 获取应用的应用名
     *
     * @param context
     * @return
     */
    public static synchronized String getAppName(Context context) {
        try {
            packageManager = context.getPackageManager();
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return context.getResources().getString(packageInfo.applicationInfo.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取应用的版本名
     *
     * @param context
     * @return
     */
    public static synchronized String getVersionName(Context context) {
        try {
            packageManager = context.getPackageManager();
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取应用的版本号
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static synchronized String getVersionCode(Context context) {
        try {
            packageManager = context.getPackageManager();
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return String.valueOf(packageInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取显示DPI
     *
     * @param context
     * @return
     */
    public static synchronized float getDensity(Context context) {
        DisplayMetrics density = new DisplayMetrics();
        windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(density);
        return density.density;
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static synchronized float getWidth(Context context) {
        windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static synchronized float getHeight(Context context) {
        windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getHeight();
    }
}