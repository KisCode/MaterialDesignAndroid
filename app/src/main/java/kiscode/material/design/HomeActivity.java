package kiscode.material.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void startToolbar(View view) {
        startDemoActivity(ToolbarActivity.class);
    }

    public void startDrawerLayout(View view) {
        startDemoActivity(DrawerLayoutActivity.class);
    }

    public void startBottomNavigationView(View view) {
    }

    public void startFloatingActionBar(View view) {
    }

    public void startImmersiveStatus(View view) {
        startDemoActivity(ImmersiveStatusActivity.class);
    }

    private void startDemoActivity(Class targetActivity) {
        startActivity(new Intent(this, targetActivity));
    }

}