package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import com.google.android.material.C0387R;
import com.google.android.material.internal.ThemeEnforcement;

@RequiresApi(21)
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = {16843848};

    ViewUtilsLollipop() {
    }

    static void setBoundsViewOutlineProvider(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void setStateListAnimatorFromAttrs(View view, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        View view2 = view;
        Context context = view2.getContext();
        TypedArray a = ThemeEnforcement.obtainStyledAttributes(context, attrs, STATE_LIST_ANIM_ATTRS, defStyleAttr, defStyleRes, new int[0]);
        try {
            if (a.hasValue(0)) {
                view2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, a.getResourceId(0, 0)));
            }
            a.recycle();
        } catch (Throwable th) {
            Throwable th2 = th;
            a.recycle();
            throw th2;
        }
    }

    static void setDefaultAppBarLayoutStateListAnimator(View view, float elevation) {
        StateListAnimator stateListAnimator;
        View view2 = view;
        int dur = view2.getResources().getInteger(C0387R.integer.app_bar_elevation_anim_duration);
        new StateListAnimator();
        StateListAnimator sla = stateListAnimator;
        int[] iArr = new int[3];
        iArr[0] = 16842766;
        int[] iArr2 = iArr;
        iArr2[1] = C0387R.attr.state_liftable;
        int[] iArr3 = iArr2;
        iArr3[2] = -C0387R.attr.state_lifted;
        sla.addState(iArr3, ObjectAnimator.ofFloat(view2, "elevation", new float[]{0.0f}).setDuration((long) dur));
        int[] iArr4 = new int[1];
        iArr4[0] = 16842766;
        sla.addState(iArr4, ObjectAnimator.ofFloat(view2, "elevation", new float[]{elevation}).setDuration((long) dur));
        sla.addState(new int[0], ObjectAnimator.ofFloat(view2, "elevation", new float[]{0.0f}).setDuration(0));
        view2.setStateListAnimator(sla);
    }
}
