package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.core.view.a;
import androidx.core.view.m;
import com.microsoft.clarity.b2.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class g {
    private static final AtomicInteger a = new AtomicInteger(1);
    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static WeakHashMap<View, k> g = null;
    private static Field h;
    private static boolean i = false;
    private static ThreadLocal<Rect> j;
    private static final int[] k = {com.microsoft.clarity.p1.c.b, com.microsoft.clarity.p1.c.c, com.microsoft.clarity.p1.c.n, com.microsoft.clarity.p1.c.y, com.microsoft.clarity.p1.c.B, com.microsoft.clarity.p1.c.C, com.microsoft.clarity.p1.c.D, com.microsoft.clarity.p1.c.E, com.microsoft.clarity.p1.c.F, com.microsoft.clarity.p1.c.G, com.microsoft.clarity.p1.c.d, com.microsoft.clarity.p1.c.e, com.microsoft.clarity.p1.c.f, com.microsoft.clarity.p1.c.g, com.microsoft.clarity.p1.c.h, com.microsoft.clarity.p1.c.i, com.microsoft.clarity.p1.c.j, com.microsoft.clarity.p1.c.k, com.microsoft.clarity.p1.c.l, com.microsoft.clarity.p1.c.m, com.microsoft.clarity.p1.c.o, com.microsoft.clarity.p1.c.p, com.microsoft.clarity.p1.c.q, com.microsoft.clarity.p1.c.r, com.microsoft.clarity.p1.c.s, com.microsoft.clarity.p1.c.t, com.microsoft.clarity.p1.c.u, com.microsoft.clarity.p1.c.v, com.microsoft.clarity.p1.c.w, com.microsoft.clarity.p1.c.x, com.microsoft.clarity.p1.c.z, com.microsoft.clarity.p1.c.A};
    private static final com.microsoft.clarity.a2.r l = com.microsoft.clarity.a2.u.h;

    class a extends f<Boolean> {
        a(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(@NonNull View view) {
            return Boolean.valueOf(p.d(view));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(@NonNull View view, Boolean bool) {
            p.i(view, bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f<CharSequence> {
        b(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return p.b(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            p.h(view, charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f<CharSequence> {
        c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return r.a(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            r.b(view, charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f<Boolean> {
        d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(p.c(view));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            p.g(view, bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> h = new WeakHashMap<>();

        e() {
        }

        private void a(View view, boolean z) {
            boolean z2 = view.isShown() && view.getWindowVisibility() == 0;
            if (z != z2) {
                g.c0(view, z2 ? 16 : 32);
                this.h.put(view, Boolean.valueOf(z2));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.h.entrySet()) {
                    a((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {
        private final int a;
        private final Class<T> b;
        private final int c;
        private final int d;

        f(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        f(int i, Class<T> cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        /* access modifiers changed from: package-private */
        public abstract T d(View view);

        /* access modifiers changed from: package-private */
        public abstract void e(View view, T t);

        /* access modifiers changed from: package-private */
        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T tag = view.getTag(this.a);
            if (this.b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void g(View view, T t) {
            if (c()) {
                e(view, t);
            } else if (b() && h(f(view), t)) {
                g.l(view);
                view.setTag(this.a, t);
                g.c0(view, this.d);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean h(T t, T t2);
    }

    /* renamed from: androidx.core.view.g$g  reason: collision with other inner class name */
    static class C0040g {
        static boolean a(@NonNull View view) {
            return view.hasOnClickListeners();
        }
    }

    static class h {
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z) {
            view.setHasTransientState(z);
        }

        static void s(View view, int i) {
            view.setImportantForAccessibility(i);
        }
    }

    static class i {
        static int a() {
            return View.generateViewId();
        }

        static Display b(@NonNull View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i) {
            view.setLabelFor(i);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i) {
            view.setLayoutDirection(i);
        }

        static void k(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }
    }

    static class j {
        static Rect a(@NonNull View view) {
            return view.getClipBounds();
        }

        static boolean b(@NonNull View view) {
            return view.isInLayout();
        }

        static void c(@NonNull View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static class k {
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(@NonNull View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(@NonNull View view) {
            return view.isLaidOut();
        }

        static boolean d(@NonNull View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
        }

        static void f(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    static class l {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class m {

        class a implements View.OnApplyWindowInsetsListener {
            m a = null;
            final /* synthetic */ View b;
            final /* synthetic */ com.microsoft.clarity.a2.p c;

            a(View view, com.microsoft.clarity.a2.p pVar) {
                this.b = view;
                this.c = pVar;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                m w = m.w(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    m.a(windowInsets, this.b);
                    if (w.equals(this.a)) {
                        return this.c.a(view, w).u();
                    }
                }
                this.a = w;
                m a2 = this.c.a(view, w);
                if (i >= 30) {
                    return a2.u();
                }
                g.q0(view);
                return a2.u();
            }
        }

        static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(com.microsoft.clarity.p1.c.T);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static m b(@NonNull View view, @NonNull m mVar, @NonNull Rect rect) {
            WindowInsets u = mVar.u();
            if (u != null) {
                return m.w(view.computeSystemWindowInsets(u, rect), view);
            }
            rect.setEmpty();
            return mVar;
        }

        static boolean c(@NonNull View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        static boolean d(@NonNull View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        static boolean e(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        static boolean f(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static m j(@NonNull View view) {
            return m.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(@NonNull View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f) {
            view.setElevation(f);
        }

        static void t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        static void u(@NonNull View view, com.microsoft.clarity.a2.p pVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(com.microsoft.clarity.p1.c.L, pVar);
            }
            if (pVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(com.microsoft.clarity.p1.c.T));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, pVar));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f) {
            view.setTranslationZ(f);
        }

        static void x(@NonNull View view, float f) {
            view.setZ(f);
        }

        static boolean y(View view, int i) {
            return view.startNestedScroll(i);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class n {
        public static m a(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            m v = m.v(rootWindowInsets);
            v.s(v);
            v.d(view.getRootView());
            return v;
        }

        static int b(@NonNull View view) {
            return view.getScrollIndicators();
        }

        static void c(@NonNull View view, int i) {
            view.setScrollIndicators(i);
        }

        static void d(@NonNull View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    static class o {
        static void a(@NonNull View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        static int b(View view) {
            return view.getImportantForAutofill();
        }

        static int c(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        static boolean d(@NonNull View view) {
            return view.hasExplicitFocusable();
        }

        static boolean e(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        static boolean g(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View h(@NonNull View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        static boolean i(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        static void j(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void k(@NonNull View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        static void l(View view, int i) {
            view.setImportantForAutofill(i);
        }

        static void m(@NonNull View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        static void n(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        static void o(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class p {
        static void a(@NonNull View view, @NonNull u uVar) {
            int i = com.microsoft.clarity.p1.c.S;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(i);
            if (gVar == null) {
                gVar = new androidx.collection.g();
                view.setTag(i, gVar);
            }
            Objects.requireNonNull(uVar);
            com.microsoft.clarity.a2.v vVar = new com.microsoft.clarity.a2.v(uVar);
            gVar.put(uVar, vVar);
            view.addOnUnhandledKeyEventListener(vVar);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(@NonNull View view, @NonNull u uVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(com.microsoft.clarity.p1.c.S);
            if (gVar != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) gVar.get(uVar)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        static <T> T f(View view, int i) {
            return view.requireViewById(i);
        }

        static void g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    private static class q {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void c(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class r {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class s {
        public static String[] a(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static com.microsoft.clarity.a2.b b(@NonNull View view, @NonNull com.microsoft.clarity.a2.b bVar) {
            ContentInfo f = bVar.f();
            ContentInfo performReceiveContent = view.performReceiveContent(f);
            if (performReceiveContent == null) {
                return null;
            }
            return performReceiveContent == f ? bVar : com.microsoft.clarity.a2.b.g(performReceiveContent);
        }

        public static void c(@NonNull View view, String[] strArr, com.microsoft.clarity.a2.q qVar) {
            if (qVar == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new t(qVar));
            }
        }
    }

    private static final class t implements OnReceiveContentListener {
        @NonNull
        private final com.microsoft.clarity.a2.q a;

        t(@NonNull com.microsoft.clarity.a2.q qVar) {
            this.a = qVar;
        }

        public ContentInfo onReceiveContent(@NonNull View view, @NonNull ContentInfo contentInfo) {
            com.microsoft.clarity.a2.b g = com.microsoft.clarity.a2.b.g(contentInfo);
            com.microsoft.clarity.a2.b a2 = this.a.a(view, g);
            if (a2 == null) {
                return null;
            }
            return a2 == g ? contentInfo : a2.f();
        }
    }

    public interface u {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    static class v {
        private static final ArrayList<WeakReference<View>> d = new ArrayList<>();
        private WeakHashMap<View, Boolean> a = null;
        private SparseArray<WeakReference<View>> b = null;
        private WeakReference<KeyEvent> c = null;

        v() {
        }

        static v a(View view) {
            int i = com.microsoft.clarity.p1.c.R;
            v vVar = (v) view.getTag(i);
            if (vVar != null) {
                return vVar;
            }
            v vVar2 = new v();
            view.setTag(i, vVar2);
            return vVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c2 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.b == null) {
                this.b = new SparseArray<>();
            }
            return this.b;
        }

        private boolean e(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(com.microsoft.clarity.p1.c.S);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((u) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.a == null) {
                        this.a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = d;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c2 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c2));
                }
            }
            return c2 != null;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> d2 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d2.valueAt(indexOfKey);
                d2.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d2.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && g.W(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    static {
        new e();
    }

    private static com.microsoft.clarity.a2.r A(@NonNull View view) {
        return view instanceof com.microsoft.clarity.a2.r ? (com.microsoft.clarity.a2.r) view : l;
    }

    public static void A0(@NonNull View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.s(view, f2);
        }
    }

    public static boolean B(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.b(view);
        }
        return false;
    }

    public static void B0(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.r(view, z);
        }
    }

    public static int C(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.c(view);
        }
        return 0;
    }

    public static void C0(@NonNull View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 19) {
            if (i3 < 16) {
                return;
            }
            if (i2 == 4) {
                i2 = 2;
            }
        }
        h.s(view, i2);
    }

    @SuppressLint({"InlinedApi"})
    public static int D(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return o.b(view);
        }
        return 0;
    }

    public static void D0(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            o.l(view, i2);
        }
    }

    public static int E(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.d(view);
        }
        return 0;
    }

    public static void E0(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.t(view, z);
        } else if (view instanceof com.microsoft.clarity.a2.j) {
            ((com.microsoft.clarity.a2.j) view).setNestedScrollingEnabled(z);
        }
    }

    public static int F(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.d(view);
        }
        if (!e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            e = true;
        }
        Field field = d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void F0(@NonNull View view, com.microsoft.clarity.a2.p pVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.u(view, pVar);
        }
    }

    public static int G(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.e(view);
        }
        if (!c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            c = true;
        }
        Field field = b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void G0(@NonNull View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            i.k(view, i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static String[] H(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 31 ? s.a(view) : (String[]) view.getTag(com.microsoft.clarity.p1.c.N);
    }

    public static void H0(@NonNull View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            n.d(view, i2, i3);
        }
    }

    public static int I(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 17 ? i.e(view) : view.getPaddingRight();
    }

    public static void I0(@NonNull View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            M0().g(view, charSequence);
        }
    }

    public static int J(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 17 ? i.f(view) : view.getPaddingLeft();
    }

    public static void J0(@NonNull View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.v(view, str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, str);
    }

    public static ViewParent K(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 16 ? h.f(view) : view.getParent();
    }

    public static void K0(@NonNull View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.w(view, f2);
        }
    }

    public static m L(@NonNull View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return n.a(view);
        }
        if (i2 >= 21) {
            return m.j(view);
        }
        return null;
    }

    private static void L0(View view) {
        if (C(view) == 0) {
            C0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (C((View) parent) == 4) {
                C0(view, 2);
                return;
            }
        }
    }

    public static CharSequence M(@NonNull View view) {
        return M0().f(view);
    }

    private static f<CharSequence> M0() {
        return new c(com.microsoft.clarity.p1.c.P, CharSequence.class, 64, 30);
    }

    public static String N(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.k(view);
        }
        WeakHashMap<View, String> weakHashMap = f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static void N0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.z(view);
        } else if (view instanceof com.microsoft.clarity.a2.j) {
            ((com.microsoft.clarity.a2.j) view).stopNestedScroll();
        }
    }

    public static float O(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.l(view);
        }
        return 0.0f;
    }

    private static void O0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    @Deprecated
    public static int P(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.g(view);
        }
        return 0;
    }

    public static float Q(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.m(view);
        }
        return 0.0f;
    }

    public static boolean R(@NonNull View view) {
        return o(view) != null;
    }

    public static boolean S(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return C0040g.a(view);
        }
        return false;
    }

    public static boolean T(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.h(view);
        }
        return true;
    }

    public static boolean U(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.i(view);
        }
        return false;
    }

    public static boolean V(@NonNull View view) {
        Boolean f2 = b().f(view);
        return f2 != null && f2.booleanValue();
    }

    public static boolean W(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 19 ? k.b(view) : view.getWindowToken() != null;
    }

    public static boolean X(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 19 ? k.c(view) : view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean Y(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.p(view);
        }
        if (view instanceof com.microsoft.clarity.a2.j) {
            return ((com.microsoft.clarity.a2.j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean Z(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.g(view);
        }
        return false;
    }

    public static boolean a0(@NonNull View view) {
        Boolean f2 = s0().f(view);
        return f2 != null && f2.booleanValue();
    }

    private static f<Boolean> b() {
        return new d(com.microsoft.clarity.p1.c.J, Boolean.class, 28);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ com.microsoft.clarity.a2.b b0(com.microsoft.clarity.a2.b bVar) {
        return bVar;
    }

    public static int c(@NonNull View view, @NonNull CharSequence charSequence, @NonNull com.microsoft.clarity.b2.d dVar) {
        int t2 = t(view, charSequence);
        if (t2 != -1) {
            d(view, new b.a(t2, charSequence, dVar));
        }
        return t2;
    }

    static void c0(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = r(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            int i3 = 32;
            if (q(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i3 = 2048;
                }
                obtain.setEventType(i3);
                k.g(obtain, i2);
                if (z) {
                    obtain.getText().add(r(view));
                    L0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                k.g(obtain2, i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(r(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    private static void d(@NonNull View view, @NonNull b.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            l(view);
            o0(aVar.b(), view);
            s(view).add(aVar);
            c0(view, 0);
        }
    }

    public static void d0(@NonNull View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (i3 >= 21) {
            Rect z = z();
            boolean z2 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                z.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z2 = !z.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            f(view, i2);
            if (z2 && z.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(z);
            }
        } else {
            f(view, i2);
        }
    }

    @NonNull
    public static k e(@NonNull View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        k kVar = g.get(view);
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(view);
        g.put(view, kVar2);
        return kVar2;
    }

    public static void e0(@NonNull View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (i3 >= 21) {
            Rect z = z();
            boolean z2 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                z.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z2 = !z.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            g(view, i2);
            if (z2 && z.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(z);
            }
        } else {
            g(view, i2);
        }
    }

    private static void f(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            O0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                O0((View) parent);
            }
        }
    }

    @NonNull
    public static m f0(@NonNull View view, @NonNull m mVar) {
        WindowInsets u2;
        if (Build.VERSION.SDK_INT >= 21 && (u2 = mVar.u()) != null) {
            WindowInsets b2 = l.b(view, u2);
            if (!b2.equals(u2)) {
                return m.w(b2, view);
            }
        }
        return mVar;
    }

    private static void g(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            O0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                O0((View) parent);
            }
        }
    }

    public static void g0(@NonNull View view, @NonNull com.microsoft.clarity.b2.b bVar) {
        view.onInitializeAccessibilityNodeInfo(bVar.F0());
    }

    @NonNull
    public static m h(@NonNull View view, @NonNull m mVar, @NonNull Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? m.b(view, mVar, rect) : mVar;
    }

    private static f<CharSequence> h0() {
        return new b(com.microsoft.clarity.p1.c.K, CharSequence.class, 8, 28);
    }

    @NonNull
    public static m i(@NonNull View view, @NonNull m mVar) {
        WindowInsets u2;
        if (Build.VERSION.SDK_INT >= 21 && (u2 = mVar.u()) != null) {
            WindowInsets a2 = l.a(view, u2);
            if (!a2.equals(u2)) {
                return m.w(a2, view);
            }
        }
        return mVar;
    }

    public static boolean i0(@NonNull View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.j(view, i2, bundle);
        }
        return false;
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return v.a(view).b(view, keyEvent);
    }

    public static com.microsoft.clarity.a2.b j0(@NonNull View view, @NonNull com.microsoft.clarity.a2.b bVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + bVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return s.b(view, bVar);
        }
        com.microsoft.clarity.a2.q qVar = (com.microsoft.clarity.a2.q) view.getTag(com.microsoft.clarity.p1.c.M);
        if (qVar == null) {
            return A(view).a(bVar);
        }
        com.microsoft.clarity.a2.b a2 = qVar.a(view, bVar);
        if (a2 == null) {
            return null;
        }
        return A(view).a(a2);
    }

    static boolean k(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return v.a(view).f(keyEvent);
    }

    public static void k0(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.k(view);
        } else {
            view.postInvalidate();
        }
    }

    static void l(@NonNull View view) {
        a n2 = n(view);
        if (n2 == null) {
            n2 = new a();
        }
        t0(view, n2);
    }

    public static void l0(@NonNull View view, @NonNull Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.m(view, runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static int m() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return i.a();
        }
        do {
            atomicInteger = a;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    @SuppressLint({"LambdaLast"})
    public static void m0(@NonNull View view, @NonNull Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.n(view, runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static a n(@NonNull View view) {
        View.AccessibilityDelegate o2 = o(view);
        if (o2 == null) {
            return null;
        }
        return o2 instanceof a.C0037a ? ((a.C0037a) o2).a : new a(o2);
    }

    public static void n0(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            o0(i2, view);
            c0(view, 0);
        }
    }

    private static View.AccessibilityDelegate o(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 29 ? q.a(view) : p(view);
    }

    private static void o0(int i2, View view) {
        List<b.a> s2 = s(view);
        for (int i3 = 0; i3 < s2.size(); i3++) {
            if (s2.get(i3).b() == i2) {
                s2.remove(i3);
                return;
            }
        }
    }

    private static View.AccessibilityDelegate p(@NonNull View view) {
        if (i) {
            return null;
        }
        if (h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return null;
            }
        }
        try {
            Object obj = h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            i = true;
            return null;
        }
    }

    public static void p0(@NonNull View view, @NonNull b.a aVar, CharSequence charSequence, com.microsoft.clarity.b2.d dVar) {
        if (dVar == null && charSequence == null) {
            n0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, dVar));
        }
    }

    public static int q(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return k.a(view);
        }
        return 0;
    }

    public static void q0(@NonNull View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            l.c(view);
        } else if (i2 >= 16) {
            h.p(view);
        }
    }

    public static CharSequence r(@NonNull View view) {
        return h0().f(view);
    }

    public static void r0(@NonNull View view, @SuppressLint({"ContextFirst"}) @NonNull Context context, @NonNull int[] iArr, AttributeSet attributeSet, @NonNull TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            q.c(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    private static List<b.a> s(View view) {
        int i2 = com.microsoft.clarity.p1.c.H;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    private static f<Boolean> s0() {
        return new a(com.microsoft.clarity.p1.c.O, Boolean.class, 28);
    }

    private static int t(View view, @NonNull CharSequence charSequence) {
        List<b.a> s2 = s(view);
        for (int i2 = 0; i2 < s2.size(); i2++) {
            if (TextUtils.equals(charSequence, s2.get(i2).c())) {
                return s2.get(i2).b();
            }
        }
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[] iArr = k;
            if (i4 >= iArr.length || i3 != -1) {
                return i3;
            }
            int i5 = iArr[i4];
            boolean z = true;
            for (int i6 = 0; i6 < s2.size(); i6++) {
                z &= s2.get(i6).b() != i5;
            }
            if (z) {
                i3 = i5;
            }
            i4++;
        }
        return i3;
    }

    public static void t0(@NonNull View view, a aVar) {
        if (aVar == null && (o(view) instanceof a.C0037a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static ColorStateList u(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.g(view);
        }
        if (view instanceof com.microsoft.clarity.a2.t) {
            return ((com.microsoft.clarity.a2.t) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void u0(@NonNull View view, boolean z) {
        b().g(view, Boolean.valueOf(z));
    }

    public static PorterDuff.Mode v(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.h(view);
        }
        if (view instanceof com.microsoft.clarity.a2.t) {
            return ((com.microsoft.clarity.a2.t) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void v0(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            k.f(view, i2);
        }
    }

    public static Rect w(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return j.a(view);
        }
        return null;
    }

    public static void w0(@NonNull View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.q(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static Display x(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.b(view);
        }
        if (W(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void x0(@NonNull View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            m.q(view, colorStateList);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (m.g(view) == null && m.h(view) == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    h.q(view, background);
                }
            }
        } else if (view instanceof com.microsoft.clarity.a2.t) {
            ((com.microsoft.clarity.a2.t) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static float y(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.i(view);
        }
        return 0.0f;
    }

    public static void y0(@NonNull View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            m.r(view, mode);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (m.g(view) == null && m.h(view) == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    h.q(view, background);
                }
            }
        } else if (view instanceof com.microsoft.clarity.a2.t) {
            ((com.microsoft.clarity.a2.t) view).setSupportBackgroundTintMode(mode);
        }
    }

    private static Rect z() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void z0(@NonNull View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            j.c(view, rect);
        }
    }
}
