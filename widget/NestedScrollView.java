package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.g;
import com.microsoft.clarity.a2.j;
import com.microsoft.clarity.a2.k;
import com.microsoft.clarity.a2.m;
import com.microsoft.clarity.a2.o;
import com.microsoft.clarity.b2.b;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements m, j {
    private static final float I = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final a J = new a();
    private static final int[] K = {16843130};
    private final int[] A;
    private int B;
    private int C;
    private d D;
    private final o E;
    private final k F;
    private float G;
    private c H;
    private final float h;
    private long i;
    private final Rect j;
    private OverScroller k;
    @NonNull
    public EdgeEffect l;
    @NonNull
    public EdgeEffect m;
    private int n;
    private boolean o;
    private boolean p;
    private View q;
    private boolean r;
    private VelocityTracker s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private final int[] z;

    static class a extends androidx.core.view.a {
        a() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            androidx.core.view.accessibility.b.a(accessibilityEvent, nestedScrollView.getScrollX());
            androidx.core.view.accessibility.b.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void g(View view, com.microsoft.clarity.b2.b bVar) {
            int scrollRange;
            super.g(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.b0(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                bVar.v0(true);
                if (nestedScrollView.getScrollY() > 0) {
                    bVar.b(b.a.j);
                    bVar.b(b.a.n);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    bVar.b(b.a.i);
                    bVar.b(b.a.o);
                }
            }
        }

        public boolean j(View view, int i, Bundle bundle) {
            if (super.j(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.T(0, max, true);
                    return true;
                } else if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.T(0, min, true);
            return true;
        }
    }

    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public interface c {
        void a(@NonNull NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public int h;

        class a implements Parcelable.Creator<d> {
            a() {
            }

            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* renamed from: b */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        d(Parcel parcel) {
            super(parcel);
            this.h = parcel.readInt();
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.h + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h);
        }
    }

    public NestedScrollView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.microsoft.clarity.p1.a.c);
    }

    public NestedScrollView(@NonNull Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new Rect();
        this.o = true;
        this.p = false;
        this.q = null;
        this.r = false;
        this.u = true;
        this.y = -1;
        this.z = new int[2];
        this.A = new int[2];
        this.l = b.a(context, attributeSet);
        this.m = b.a(context, attributeSet);
        this.h = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        A();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.E = new o(this);
        this.F = new k(this);
        setNestedScrollingEnabled(true);
        g.t0(this, J);
    }

    private void A() {
        this.k = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.v = viewConfiguration.getScaledTouchSlop();
        this.w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.x = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void B() {
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
    }

    private boolean C(View view) {
        return !E(view, 0, getHeight());
    }

    private static boolean D(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && D((View) parent, view2);
    }

    private boolean E(View view, int i2, int i3) {
        view.getDrawingRect(this.j);
        offsetDescendantRectToMyCoords(view, this.j);
        return this.j.bottom + i2 >= getScrollY() && this.j.top - i2 <= getScrollY() + i3;
    }

    private void F(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.F.e(0, scrollY2, 0, i2 - scrollY2, (int[]) null, i3, iArr);
    }

    private void G(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.y) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.n = (int) motionEvent.getY(i2);
            this.y = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.s;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void J() {
        VelocityTracker velocityTracker = this.s;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.s = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int K(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.l
            float r0 = androidx.core.widget.b.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            android.widget.EdgeEffect r0 = r3.l
            float r4 = -r4
            float r4 = androidx.core.widget.b.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.l
            float r5 = androidx.core.widget.b.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.l
        L_0x002c:
            r5.onRelease()
        L_0x002f:
            r1 = r4
            goto L_0x0051
        L_0x0031:
            android.widget.EdgeEffect r0 = r3.m
            float r0 = androidx.core.widget.b.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0051
            android.widget.EdgeEffect r0 = r3.m
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.b.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.m
            float r5 = androidx.core.widget.b.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.m
            goto L_0x002c
        L_0x0051:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L_0x0060
            r3.invalidate()
        L_0x0060:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.K(int, float):int");
    }

    private void L(boolean z2) {
        if (z2) {
            U(2, 1);
        } else {
            W(1);
        }
        this.C = getScrollY();
        g.k0(this);
    }

    private boolean M(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i2 == 33;
        View t2 = t(z3, i3, i4);
        if (t2 == null) {
            t2 = this;
        }
        if (i3 < scrollY || i4 > i5) {
            p(z3 ? i3 - scrollY : i4 - i5);
            z2 = true;
        }
        if (t2 != findFocus()) {
            t2.requestFocus(i2);
        }
        return z2;
    }

    private void N(View view) {
        view.getDrawingRect(this.j);
        offsetDescendantRectToMyCoords(view, this.j);
        int f = f(this.j);
        if (f != 0) {
            scrollBy(0, f);
        }
    }

    private boolean O(Rect rect, boolean z2) {
        int f = f(rect);
        boolean z3 = f != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, f);
            } else {
                Q(0, f);
            }
        }
        return z3;
    }

    private boolean P(@NonNull EdgeEffect edgeEffect, int i2) {
        if (i2 > 0) {
            return true;
        }
        return w(-i2) < b.b(edgeEffect) * ((float) getHeight());
    }

    private void R(int i2, int i3, int i4, boolean z2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.i > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.k;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i4);
                L(z2);
            } else {
                if (!this.k.isFinished()) {
                    a();
                }
                scrollBy(i2, i3);
            }
            this.i = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private boolean V(MotionEvent motionEvent) {
        boolean z2;
        if (b.b(this.l) != 0.0f) {
            b.d(this.l, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z2 = true;
        } else {
            z2 = false;
        }
        if (b.b(this.m) == 0.0f) {
            return z2;
        }
        b.d(this.m, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void a() {
        this.k.abortAnimation();
        W(1);
    }

    private boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int e(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.G == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.G = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.G;
    }

    private void p(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.u) {
            Q(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    private boolean q(int i2) {
        EdgeEffect edgeEffect;
        if (b.b(this.l) != 0.0f) {
            if (P(this.l, i2)) {
                edgeEffect = this.l;
            } else {
                i2 = -i2;
                u(i2);
                return true;
            }
        } else if (b.b(this.m) == 0.0f) {
            return false;
        } else {
            i2 = -i2;
            if (P(this.m, i2)) {
                edgeEffect = this.m;
            }
            u(i2);
            return true;
        }
        edgeEffect.onAbsorb(i2);
        return true;
    }

    private void r() {
        this.r = false;
        J();
        W(0);
        this.l.onRelease();
        this.m.onRelease();
    }

    private View t(boolean z2, int i2, int i3) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (!z5) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private float w(int i2) {
        double log = Math.log((double) ((((float) Math.abs(i2)) * 0.35f) / (this.h * 0.015f)));
        float f = I;
        return (float) (((double) (this.h * 0.015f)) * Math.exp((((double) f) / (((double) f) - 1.0d)) * log));
    }

    private boolean y(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i3 >= childAt.getTop() - scrollY && i3 < childAt.getBottom() - scrollY && i2 >= childAt.getLeft() && i2 < childAt.getRight();
    }

    private void z() {
        VelocityTracker velocityTracker = this.s;
        if (velocityTracker == null) {
            this.s = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean H(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        boolean z3;
        boolean z4;
        int overScrollMode = getOverScrollMode();
        boolean z5 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z6 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && z6);
        int i10 = i4 + i2;
        int i11 = !z7 ? 0 : i8;
        int i12 = i5 + i3;
        int i13 = !z8 ? 0 : i9;
        int i14 = -i11;
        int i15 = i11 + i6;
        int i16 = -i13;
        int i17 = i13 + i7;
        if (i10 > i15) {
            i10 = i15;
            z3 = true;
        } else if (i10 < i14) {
            z3 = true;
            i10 = i14;
        } else {
            z3 = false;
        }
        if (i12 > i17) {
            i12 = i17;
            z4 = true;
        } else if (i12 < i16) {
            z4 = true;
            i12 = i16;
        } else {
            z4 = false;
        }
        if (z4 && !x(1)) {
            this.k.springBack(i10, i12, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i10, i12, z3, z4);
        return z3 || z4;
    }

    public boolean I(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        if (z2) {
            this.j.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.j;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.j.top = getScrollY() - height;
            Rect rect2 = this.j;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.j;
        int i3 = rect3.top;
        int i4 = height + i3;
        rect3.bottom = i4;
        return M(i2, i3, i4);
    }

    public final void Q(int i2, int i3) {
        R(i2, i3, 250, false);
    }

    /* access modifiers changed from: package-private */
    public void S(int i2, int i3, int i4, boolean z2) {
        R(i2 - getScrollX(), i3 - getScrollY(), i4, z2);
    }

    /* access modifiers changed from: package-private */
    public void T(int i2, int i3, boolean z2) {
        S(i2, i3, 250, z2);
    }

    public boolean U(int i2, int i3) {
        return this.F.p(i2, i3);
    }

    public void W(int i2) {
        this.F.r(i2);
    }

    public void addView(@NonNull View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !E(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            p(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.j);
            offsetDescendantRectToMyCoords(findNextFocus, this.j);
            p(f(this.j));
            findNextFocus.requestFocus(i2);
        }
        if (findFocus == null || !findFocus.isFocused() || !C(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.k.isFinished()) {
            this.k.computeScrollOffset();
            int currY = this.k.getCurrY();
            int g = g(currY - this.C);
            this.C = currY;
            int[] iArr = this.A;
            boolean z2 = false;
            iArr[1] = 0;
            h(0, g, iArr, (int[]) null, 1);
            int i2 = g - this.A[1];
            int scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                H(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i2 - scrollY2;
                int[] iArr2 = this.A;
                iArr2[1] = 0;
                i(0, scrollY2, 0, i3, this.z, 1, iArr2);
                i2 = i3 - this.A[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z2 = true;
                }
                if (z2) {
                    if (i2 < 0) {
                        if (this.l.isFinished()) {
                            edgeEffect = this.l;
                        }
                    } else if (this.m.isFinished()) {
                        edgeEffect = this.m;
                    }
                    edgeEffect.onAbsorb((int) this.k.getCurrVelocity());
                }
                a();
            }
            if (!this.k.isFinished()) {
                g.k0(this);
            } else {
                W(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z2) {
        return this.F.a(f, f2, z2);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.F.b(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return h(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.F.f(i2, i3, i4, i5, iArr);
    }

    public void draw(@NonNull Canvas canvas) {
        int i2;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i3 = 0;
        if (!this.l.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 21 || b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i2 = getPaddingLeft() + 0;
            } else {
                i2 = 0;
            }
            if (i4 >= 21 && b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate((float) i2, (float) min);
            this.l.setSize(width, height);
            if (this.l.draw(canvas)) {
                g.k0(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.m.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            int i5 = Build.VERSION.SDK_INT;
            if (i5 < 21 || b.a(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i3 = 0 + getPaddingLeft();
            }
            if (i5 >= 21 && b.a(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i3 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            this.m.setSize(width2, height2);
            if (this.m.draw(canvas)) {
                g.k0(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* access modifiers changed from: protected */
    public int f(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i3 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i4 = rect.bottom;
        if (i4 > i3 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i3) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        } else if (rect.top >= scrollY || i4 >= i3) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i3 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    /* access modifiers changed from: package-private */
    public int g(int i2) {
        int height = getHeight();
        if (i2 > 0 && b.b(this.l) != 0.0f) {
            int round = Math.round((((float) (-height)) / 4.0f) * b.d(this.l, (((float) (-i2)) * 4.0f) / ((float) height), 0.5f));
            if (round != i2) {
                this.l.finish();
            }
            return i2 - round;
        } else if (i2 >= 0 || b.b(this.m) == 0.0f) {
            return i2;
        } else {
            float f = (float) height;
            int round2 = Math.round((f / 4.0f) * b.d(this.m, (((float) i2) * 4.0f) / f, 0.5f));
            if (round2 != i2) {
                this.m.finish();
            }
            return i2 - round2;
        }
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.E.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean h(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.F.d(i2, i3, iArr, iArr2, i4);
    }

    public boolean hasNestedScrollingParent() {
        return x(0);
    }

    public void i(int i2, int i3, int i4, int i5, int[] iArr, int i6, @NonNull int[] iArr2) {
        this.F.e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean isNestedScrollingEnabled() {
        return this.F.l();
    }

    public void j(@NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        F(i5, i6, iArr);
    }

    public void k(@NonNull View view, int i2, int i3, int i4, int i5, int i6) {
        F(i5, i6, (int[]) null);
    }

    public boolean l(@NonNull View view, @NonNull View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public void m(@NonNull View view, @NonNull View view2, int i2, int i3) {
        this.E.c(view, view2, i2, i3);
        U(2, i3);
    }

    /* access modifiers changed from: protected */
    public void measureChild(@NonNull View view, int i2, int i3) {
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(@NonNull View view, int i2) {
        this.E.e(view, i2);
        W(i2);
    }

    public void o(@NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        h(i2, i3, iArr, (int[]) null, i4);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onGenericMotionEvent(@androidx.annotation.NonNull android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            r1 = 0
            r2 = 8
            if (r0 != r2) goto L_0x00a6
            boolean r0 = r8.r
            if (r0 != 0) goto L_0x00a6
            r0 = 2
            boolean r0 = com.microsoft.clarity.a2.i.a(r9, r0)
            r2 = 0
            if (r0 == 0) goto L_0x001c
            r0 = 9
        L_0x0017:
            float r0 = r9.getAxisValue(r0)
            goto L_0x0028
        L_0x001c:
            r0 = 4194304(0x400000, float:5.877472E-39)
            boolean r0 = com.microsoft.clarity.a2.i.a(r9, r0)
            if (r0 == 0) goto L_0x0027
            r0 = 26
            goto L_0x0017
        L_0x0027:
            r0 = r2
        L_0x0028:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00a6
            float r2 = r8.getVerticalScrollFactorCompat()
            float r0 = r0 * r2
            int r0 = (int) r0
            int r2 = r8.getScrollRange()
            int r3 = r8.getScrollY()
            int r0 = r3 - r0
            r4 = 1056964608(0x3f000000, float:0.5)
            r5 = 8194(0x2002, float:1.1482E-41)
            r6 = 1
            if (r0 >= 0) goto L_0x006d
            boolean r2 = r8.c()
            if (r2 == 0) goto L_0x0051
            boolean r9 = com.microsoft.clarity.a2.i.a(r9, r5)
            if (r9 != 0) goto L_0x0051
            r9 = r6
            goto L_0x0052
        L_0x0051:
            r9 = r1
        L_0x0052:
            if (r9 == 0) goto L_0x006b
            android.widget.EdgeEffect r9 = r8.l
            float r0 = (float) r0
            float r0 = -r0
            int r2 = r8.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            androidx.core.widget.b.d(r9, r0, r4)
            android.widget.EdgeEffect r9 = r8.l
            r9.onRelease()
            r8.invalidate()
            r9 = r6
            goto L_0x009b
        L_0x006b:
            r9 = r1
            goto L_0x009b
        L_0x006d:
            if (r0 <= r2) goto L_0x0099
            boolean r7 = r8.c()
            if (r7 == 0) goto L_0x007d
            boolean r9 = com.microsoft.clarity.a2.i.a(r9, r5)
            if (r9 != 0) goto L_0x007d
            r9 = r6
            goto L_0x007e
        L_0x007d:
            r9 = r1
        L_0x007e:
            if (r9 == 0) goto L_0x0096
            android.widget.EdgeEffect r9 = r8.m
            int r0 = r0 - r2
            float r0 = (float) r0
            int r1 = r8.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            androidx.core.widget.b.d(r9, r0, r4)
            android.widget.EdgeEffect r9 = r8.m
            r9.onRelease()
            r8.invalidate()
            r1 = r6
        L_0x0096:
            r9 = r1
            r1 = r2
            goto L_0x009b
        L_0x0099:
            r9 = r1
            r1 = r0
        L_0x009b:
            if (r1 == r3) goto L_0x00a5
            int r9 = r8.getScrollX()
            super.scrollTo(r9, r1)
            return r6
        L_0x00a5:
            return r9
        L_0x00a6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action == 2 && this.r) {
            return true;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.y;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.n) > this.v && (2 & getNestedScrollAxes()) == 0) {
                                this.r = true;
                                this.n = y2;
                                B();
                                this.s.addMovement(motionEvent);
                                this.B = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 6) {
                        G(motionEvent);
                    }
                }
            }
            this.r = false;
            this.y = -1;
            J();
            if (this.k.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                g.k0(this);
            }
            W(0);
        } else {
            int y3 = (int) motionEvent.getY();
            if (!y((int) motionEvent.getX(), y3)) {
                if (!V(motionEvent) && this.k.isFinished()) {
                    z2 = false;
                }
                this.r = z2;
                J();
            } else {
                this.n = y3;
                this.y = motionEvent.getPointerId(0);
                z();
                this.s.addMovement(motionEvent);
                this.k.computeScrollOffset();
                if (!V(motionEvent) && this.k.isFinished()) {
                    z2 = false;
                }
                this.r = z2;
                U(2, 0);
            }
        }
        return this.r;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.o = false;
        View view = this.q;
        if (view != null && D(view, this)) {
            N(this.q);
        }
        this.q = null;
        if (!this.p) {
            if (this.D != null) {
                scrollTo(getScrollX(), this.D.h);
                this.D = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e = e(scrollY, paddingTop, i6);
            if (e != scrollY) {
                scrollTo(getScrollX(), e);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.p = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.t && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        u((int) f2);
        return true;
    }

    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        o(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        F(i5, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        m(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        View findNextFocus = rect == null ? instance.findNextFocus(this, (View) null, i2) : instance.findNextFocusFromRect(this, rect, i2);
        if (findNextFocus != null && !C(findNextFocus)) {
            return findNextFocus.requestFocus(i2, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.D = dVar;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.h = getScrollY();
        return dVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        c cVar = this.H;
        if (cVar != null) {
            cVar.a(this, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && E(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.j);
            offsetDescendantRectToMyCoords(findFocus, this.j);
            p(f(this.j));
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return l(view, view2, i2, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        n(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        if (r10.k.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0222, code lost:
        if (r10.k.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r24) {
        /*
            r23 = this;
            r10 = r23
            r11 = r24
            r23.B()
            int r0 = r24.getActionMasked()
            r12 = 0
            if (r0 != 0) goto L_0x0010
            r10.B = r12
        L_0x0010:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r24)
            int r1 = r10.B
            float r1 = (float) r1
            r2 = 0
            r13.offsetLocation(r2, r1)
            r1 = 2
            r14 = 1
            if (r0 == 0) goto L_0x0226
            r3 = -1
            if (r0 == r14) goto L_0x01db
            if (r0 == r1) goto L_0x0082
            r1 = 3
            if (r0 == r1) goto L_0x0054
            r1 = 5
            if (r0 == r1) goto L_0x0041
            r1 = 6
            if (r0 == r1) goto L_0x002f
            goto L_0x0255
        L_0x002f:
            r23.G(r24)
            int r0 = r10.y
            int r0 = r11.findPointerIndex(r0)
            float r0 = r11.getY(r0)
            int r0 = (int) r0
            r10.n = r0
            goto L_0x0255
        L_0x0041:
            int r0 = r24.getActionIndex()
            float r1 = r11.getY(r0)
            int r1 = (int) r1
            r10.n = r1
            int r0 = r11.getPointerId(r0)
            r10.y = r0
            goto L_0x0255
        L_0x0054:
            boolean r0 = r10.r
            if (r0 == 0) goto L_0x007b
            int r0 = r23.getChildCount()
            if (r0 <= 0) goto L_0x007b
            android.widget.OverScroller r15 = r10.k
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x007b
        L_0x0078:
            androidx.core.view.g.k0(r23)
        L_0x007b:
            r10.y = r3
            r23.r()
            goto L_0x0255
        L_0x0082:
            int r0 = r10.y
            int r15 = r11.findPointerIndex(r0)
            if (r15 != r3) goto L_0x00a9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid pointerId="
            r0.append(r1)
            int r1 = r10.y
            r0.append(r1)
            java.lang.String r1 = " in onTouchEvent"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NestedScrollView"
            android.util.Log.e(r1, r0)
            goto L_0x0255
        L_0x00a9:
            float r0 = r11.getY(r15)
            int r6 = (int) r0
            int r0 = r10.n
            int r0 = r0 - r6
            float r1 = r11.getX(r15)
            int r1 = r10.K(r0, r1)
            int r0 = r0 - r1
            boolean r1 = r10.r
            if (r1 != 0) goto L_0x00d8
            int r1 = java.lang.Math.abs(r0)
            int r2 = r10.v
            if (r1 <= r2) goto L_0x00d8
            android.view.ViewParent r1 = r23.getParent()
            if (r1 == 0) goto L_0x00cf
            r1.requestDisallowInterceptTouchEvent(r14)
        L_0x00cf:
            r10.r = r14
            int r1 = r10.v
            if (r0 <= 0) goto L_0x00d7
            int r0 = r0 - r1
            goto L_0x00d8
        L_0x00d7:
            int r0 = r0 + r1
        L_0x00d8:
            r7 = r0
            boolean r0 = r10.r
            if (r0 == 0) goto L_0x0255
            r1 = 0
            int[] r3 = r10.A
            int[] r4 = r10.z
            r5 = 0
            r0 = r23
            r2 = r7
            boolean r0 = r0.h(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00fa
            int[] r0 = r10.A
            r0 = r0[r14]
            int r7 = r7 - r0
            int r0 = r10.B
            int[] r1 = r10.z
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.B = r0
        L_0x00fa:
            r16 = r7
            int[] r0 = r10.z
            r0 = r0[r14]
            int r6 = r6 - r0
            r10.n = r6
            int r17 = r23.getScrollY()
            int r9 = r23.getScrollRange()
            int r0 = r23.getOverScrollMode()
            if (r0 == 0) goto L_0x0119
            if (r0 != r14) goto L_0x0116
            if (r9 <= 0) goto L_0x0116
            goto L_0x0119
        L_0x0116:
            r18 = r12
            goto L_0x011b
        L_0x0119:
            r18 = r14
        L_0x011b:
            r1 = 0
            r3 = 0
            int r4 = r23.getScrollY()
            r5 = 0
            r7 = 0
            r8 = 0
            r19 = 1
            r0 = r23
            r2 = r16
            r6 = r9
            r22 = r9
            r9 = r19
            boolean r0 = r0.H(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x013d
            boolean r0 = r10.x(r12)
            if (r0 != 0) goto L_0x013d
            r8 = r14
            goto L_0x013e
        L_0x013d:
            r8 = r12
        L_0x013e:
            int r0 = r23.getScrollY()
            int r2 = r0 - r17
            int r4 = r16 - r2
            int[] r7 = r10.A
            r7[r14] = r12
            r1 = 0
            r3 = 0
            int[] r5 = r10.z
            r6 = 0
            r0 = r23
            r0.i(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r10.n
            int[] r1 = r10.z
            r2 = r1[r14]
            int r0 = r0 - r2
            r10.n = r0
            int r0 = r10.B
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.B = r0
            if (r18 == 0) goto L_0x01d1
            int[] r0 = r10.A
            r0 = r0[r14]
            int r0 = r16 - r0
            int r1 = r17 + r0
            if (r1 >= 0) goto L_0x0195
            android.widget.EdgeEffect r1 = r10.l
            int r0 = -r0
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            float r2 = r11.getX(r15)
            int r3 = r23.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.b.d(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.m
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01bd
            android.widget.EdgeEffect r0 = r10.m
        L_0x0191:
            r0.onRelease()
            goto L_0x01bd
        L_0x0195:
            r2 = r22
            if (r1 <= r2) goto L_0x01bd
            android.widget.EdgeEffect r1 = r10.m
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r11.getX(r15)
            int r4 = r23.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            float r2 = r2 - r3
            androidx.core.widget.b.d(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.l
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01bd
            android.widget.EdgeEffect r0 = r10.l
            goto L_0x0191
        L_0x01bd:
            android.widget.EdgeEffect r0 = r10.l
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x01cd
            android.widget.EdgeEffect r0 = r10.m
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01d1
        L_0x01cd:
            androidx.core.view.g.k0(r23)
            goto L_0x01d2
        L_0x01d1:
            r12 = r8
        L_0x01d2:
            if (r12 == 0) goto L_0x0255
            android.view.VelocityTracker r0 = r10.s
            r0.clear()
            goto L_0x0255
        L_0x01db:
            android.view.VelocityTracker r0 = r10.s
            r1 = 1000(0x3e8, float:1.401E-42)
            int r4 = r10.x
            float r4 = (float) r4
            r0.computeCurrentVelocity(r1, r4)
            int r1 = r10.y
            float r0 = r0.getYVelocity(r1)
            int r0 = (int) r0
            int r1 = java.lang.Math.abs(r0)
            int r4 = r10.w
            if (r1 < r4) goto L_0x020a
            boolean r1 = r10.q(r0)
            if (r1 != 0) goto L_0x007b
            int r0 = -r0
            float r1 = (float) r0
            boolean r4 = r10.dispatchNestedPreFling(r2, r1)
            if (r4 != 0) goto L_0x007b
            r10.dispatchNestedFling(r2, r1, r14)
            r10.u(r0)
            goto L_0x007b
        L_0x020a:
            android.widget.OverScroller r15 = r10.k
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x007b
            goto L_0x0078
        L_0x0226:
            int r0 = r23.getChildCount()
            if (r0 != 0) goto L_0x022d
            return r12
        L_0x022d:
            boolean r0 = r10.r
            if (r0 == 0) goto L_0x023a
            android.view.ViewParent r0 = r23.getParent()
            if (r0 == 0) goto L_0x023a
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x023a:
            android.widget.OverScroller r0 = r10.k
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x0245
            r23.a()
        L_0x0245:
            float r0 = r24.getY()
            int r0 = (int) r0
            r10.n = r0
            int r0 = r11.getPointerId(r12)
            r10.y = r0
            r10.U(r1, r12)
        L_0x0255:
            android.view.VelocityTracker r0 = r10.s
            if (r0 == 0) goto L_0x025c
            r0.addMovement(r13)
        L_0x025c:
            r13.recycle()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.o) {
            N(view2);
        } else {
            this.q = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return O(rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            J();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.o = true;
        super.requestLayout();
    }

    public boolean s(@NonNull KeyEvent keyEvent) {
        this.j.setEmpty();
        int i2 = 130;
        if (!d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return !keyEvent.isAltPressed() ? b(33) : v(33);
            }
            if (keyCode == 20) {
                return !keyEvent.isAltPressed() ? b(130) : v(130);
            }
            if (keyCode != 62) {
                return false;
            }
            if (keyEvent.isShiftPressed()) {
                i2 = 33;
            }
            I(i2);
            return false;
        }
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int e = e(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int e2 = e(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (e != getScrollX() || e2 != getScrollY()) {
                super.scrollTo(e, e2);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.t) {
            this.t = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.F.m(z2);
    }

    public void setOnScrollChangeListener(c cVar) {
        this.H = cVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.u = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i2) {
        return U(i2, 0);
    }

    public void stopNestedScroll() {
        W(0);
    }

    public void u(int i2) {
        if (getChildCount() > 0) {
            this.k.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            L(true);
        }
    }

    public boolean v(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.j;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.j.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.j;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.j;
        return M(i2, rect3.top, rect3.bottom);
    }

    public boolean x(int i2) {
        return this.F.k(i2);
    }
}
