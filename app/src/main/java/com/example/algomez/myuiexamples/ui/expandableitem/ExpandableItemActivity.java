package com.example.algomez.myuiexamples.ui.expandableitem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;

import com.example.algomez.myuiexamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aldajo92 on 14/03/17.
 */
public class ExpandableItemActivity extends AppCompatActivity {

    static String TAG = ExpandableItemActivity.class.getName();

    @BindView(R.id.expand_button)
    View expandButton;

    @BindView(R.id.item_container)
    RecyclerView itemContainer;

    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_item);
        ButterKnife.bind(this);

        itemContainer.setVisibility(View.GONE);
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, ExpandableItemActivity.class);
        return intent;
    }

    void expandItems(){
//        itemContainer.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        if(isExpanded){
            expand(itemContainer);
        } else {
            collapse(itemContainer);
        }

        Animation rotation = new RotateAnimation(
                isExpanded ? 0 : 180,
                isExpanded ? 180 : 0,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);

        rotation.setFillAfter(true);
        rotation.setFillAfter(true);

        TransitionManager.beginDelayedTransition(itemContainer);

        rotation.setDuration(500);
        expandButton.startAnimation(rotation);

    }

    @OnClick(R.id.expand_button)
    void onExpandItemsClicked(){
        isExpanded = !isExpanded;
        expandItems();
    }

    public static void expand(final View v) {
        v.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

}
