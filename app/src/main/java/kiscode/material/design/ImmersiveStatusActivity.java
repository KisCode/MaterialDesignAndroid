package kiscode.material.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class ImmersiveStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive_status);

        immersive();

        setHeightAndPadding(this, findViewById(R.id.toolbar));
    }

    //沉浸式状态栏
    private void immersive() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            //移除透明状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //绘制状态栏背景
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

            int visibility = window.getDecorView().getSystemUiVisibility();
            //布局全屏显示
            visibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            //隐藏软键盘（底部虚拟导航栏）
            visibility |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            //内容区域大小固定
            visibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            window.getDecorView().setSystemUiVisibility(visibility);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    private int getStatusBarHeight(Context context) {
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            return context.getResources().getDimensionPixelSize(resId);
        }
        return 0;
    }

    /***
     * 修改Toolbar高度，并设置paddingTop
     * @param context
     * @param view
     */
    private void setHeightAndPadding(Context context, View view) {
        int statusBarHeight = getStatusBarHeight(context);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height += statusBarHeight;
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + statusBarHeight, view.getPaddingRight(), view.getPaddingBottom());
    }
}