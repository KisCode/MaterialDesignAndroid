package kiscode.material.design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import kiscode.material.design.adapter.ItemNumAdapter;

public class NestRecycleViewActivity extends AppCompatActivity {
    private TextView tvNum;
    private LinearLayout llHead;

    private int mCurrentPos;
    private int mHeadHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_recycle_view);

        initViews();
        initRecyclerView();
    }

    private void initViews() {
        llHead = findViewById(R.id.ll_head);
        tvNum = findViewById(R.id.tv_num);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ItemNumAdapter());

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //获取悬浮头部高度
                mHeadHeight = llHead.getHeight();
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //监听RecyclerView滚动 对悬浮头部位置进行调整

                //下一个ItemView
                View view = layoutManager.findViewByPosition(mCurrentPos + 1);
                if (view != null) {
                    if (view.getTop() <= mHeadHeight) {
                        //对悬浮头部移动 保持在顶部
                        llHead.setY(-(mHeadHeight - view.getTop()));
                    } else {
                        llHead.setY(0);
                    }
                }

                if (mCurrentPos != layoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPos = layoutManager.findFirstVisibleItemPosition();
                    updateHeadView();
                }

            }
        });

        updateHeadView();
    }

    private void updateHeadView() {
        tvNum.setText(String.valueOf(mCurrentPos + 1));
    }
}