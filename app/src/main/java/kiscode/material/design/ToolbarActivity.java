package kiscode.material.design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class ToolbarActivity extends AppCompatActivity {
    private Toolbar toolbarHead;
    private Toolbar toolbarMenu;

    public static void start(Context context) {
        Intent starter = new Intent(context, ToolbarActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbarHead = findViewById(R.id.toolbar_head);
        toolbarMenu = findViewById(R.id.toolbar_menu);

        setSupportActionBar(toolbarHead);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //显示向上返回
        getSupportActionBar().setDisplayShowHomeEnabled(true);      //显示返回按钮

        toolbarMenu.inflateMenu(R.menu.menu_toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //点击返回按钮监听
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}