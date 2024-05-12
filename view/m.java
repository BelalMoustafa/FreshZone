package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class m {
    @NonNull
    public static final m b = (Build.VERSION.SDK_INT >= 30 ? k.q : l.b);
    private final l a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    static class a {
        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static m a(@NonNull View view) {
            if (d && view.isAttachedToWindow()) {
                try {
                    Object obj = a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) b.get(obj);
                        Rect rect2 = (Rect) c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            m a2 = new b().b(androidx.core.graphics.a.c(rect)).c(androidx.core.graphics.a.c(rect2)).a();
                            a2.s(a2);
                            a2.d(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    public static final class b {
        private final f a;

        public b() {
            int i = Build.VERSION.SDK_INT;
            this.a = i >= 30 ? new e() : i >= 29 ? new d() : i >= 20 ? new c() : new f();
        }

        public b(@NonNull m mVar) {
            int i = Build.VERSION.SDK_INT;
            this.a = i >= 30 ? new e(mVar) : i >= 29 ? new d(mVar) : i >= 20 ? new c(mVar) : new f(mVar);
        }

        @NonNull
        public m a() {
            return this.a.b();
        }

        @NonNull
        @Deprecated
        public b b(@NonNull androidx.core.graphics.a aVar) {
            this.a.d(aVar);
            return this;
        }

        @NonNull
        @Deprecated
        public b c(@NonNull androidx.core.graphics.a aVar) {
            this.a.f(aVar);
            return this;
        }
    }

    private static class c extends f {
        private static Field e = null;
        private static boolean f = false;
        private static Constructor<WindowInsets> g = null;
        private static boolean h = false;
        private WindowInsets c;
        private androidx.core.graphics.a d;

        c() {
            this.c = h();
        }

        c(@NonNull m mVar) {
            super(mVar);
            this.c = mVar.u();
        }

        private static WindowInsets h() {
            if (!f) {
                try {
                    e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!h) {
                try {
                    g = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                h = true;
            }
            Constructor<WindowInsets> constructor = g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m b() {
            a();
            m v = m.v(this.c);
            v.q(this.b);
            v.t(this.d);
            return v;
        }

        /* access modifiers changed from: package-private */
        public void d(androidx.core.graphics.a aVar) {
            this.d = aVar;
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull androidx.core.graphics.a aVar) {
            WindowInsets windowInsets = this.c;
            if (windowInsets != null) {
                this.c = windowInsets.replaceSystemWindowInsets(aVar.a, aVar.b, aVar.c, aVar.d);
            }
        }
    }

    private static class d extends f {
        final WindowInsets.Builder c;

        d() {
            this.c = new WindowInsets.Builder();
        }

        d(@NonNull m mVar) {
            super(mVar);
            WindowInsets.Builder builder;
            WindowInsets u = mVar.u();
            if (u == null) {
                builder = new WindowInsets.Builder();
            }
            this.c = builder;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m b() {
            a();
            m v = m.v(this.c.build());
            v.q(this.b);
            return v;
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull androidx.core.graphics.a aVar) {
            this.c.setMandatorySystemGestureInsets(aVar.e());
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull androidx.core.graphics.a aVar) {
            this.c.setStableInsets(aVar.e());
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull androidx.core.graphics.a aVar) {
            this.c.setSystemGestureInsets(aVar.e());
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull androidx.core.graphics.a aVar) {
            this.c.setSystemWindowInsets(aVar.e());
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull androidx.core.graphics.a aVar) {
            this.c.setTappableElementInsets(aVar.e());
        }
    }

    private static class e extends d {
        e() {
        }

        e(@NonNull m mVar) {
            super(mVar);
        }
    }

    private static class f {
        private final m a;
        androidx.core.graphics.a[] b;

        f() {
            this(new m((m) null));
        }

        f(@NonNull m mVar) {
            this.a = mVar;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            androidx.core.graphics.a[] aVarArr = this.b;
            if (aVarArr != null) {
                androidx.core.graphics.a aVar = aVarArr[C0041m.a(1)];
                androidx.core.graphics.a aVar2 = this.b[C0041m.a(2)];
                if (aVar2 == null) {
                    aVar2 = this.a.f(2);
                }
                if (aVar == null) {
                    aVar = this.a.f(1);
                }
                f(androidx.core.graphics.a.a(aVar, aVar2));
                androidx.core.graphics.a aVar3 = this.b[C0041m.a(16)];
                if (aVar3 != null) {
                    e(aVar3);
                }
                androidx.core.graphics.a aVar4 = this.b[C0041m.a(32)];
                if (aVar4 != null) {
                    c(aVar4);
                }
                androidx.core.graphics.a aVar5 = this.b[C0041m.a(64)];
                if (aVar5 != null) {
                    g(aVar5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m b() {
            a();
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull androidx.core.graphics.a aVar) {
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull androidx.core.graphics.a aVar) {
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull androidx.core.graphics.a aVar) {
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull androidx.core.graphics.a aVar) {
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull androidx.core.graphics.a aVar) {
        }
    }

    private static class g extends l {
        private static boolean h = false;
        private static Method i;
        private static Class<?> j;
        private static Field k;
        private static Field l;
        @NonNull
        final WindowInsets c;
        private androidx.core.graphics.a[] d;
        private androidx.core.graphics.a e;
        private m f;
        androidx.core.graphics.a g;

        g(@NonNull m mVar, @NonNull WindowInsets windowInsets) {
            super(mVar);
            this.e = null;
            this.c = windowInsets;
        }

        g(@NonNull m mVar, @NonNull g gVar) {
            this(mVar, new WindowInsets(gVar.c));
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        private androidx.core.graphics.a t(int i2, boolean z) {
            androidx.core.graphics.a aVar = androidx.core.graphics.a.e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    aVar = androidx.core.graphics.a.a(aVar, u(i3, z));
                }
            }
            return aVar;
        }

        private androidx.core.graphics.a v() {
            m mVar = this.f;
            return mVar != null ? mVar.g() : androidx.core.graphics.a.e;
        }

        private androidx.core.graphics.a w(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!h) {
                    x();
                }
                Method method = i;
                if (!(method == null || j == null || k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) k.get(l.get(invoke));
                        if (rect != null) {
                            return androidx.core.graphics.a.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e2) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                j = cls;
                k = cls.getDeclaredField("mVisibleInsets");
                l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                k.setAccessible(true);
                l.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            h = true;
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull View view) {
            androidx.core.graphics.a w = w(view);
            if (w == null) {
                w = androidx.core.graphics.a.e;
            }
            q(w);
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull m mVar) {
            mVar.s(this.f);
            mVar.r(this.g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.g, ((g) obj).g);
        }

        @NonNull
        public androidx.core.graphics.a g(int i2) {
            return t(i2, false);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final androidx.core.graphics.a k() {
            if (this.e == null) {
                this.e = androidx.core.graphics.a.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m m(int i2, int i3, int i4, int i5) {
            b bVar = new b(m.v(this.c));
            bVar.c(m.n(k(), i2, i3, i4, i5));
            bVar.b(m.n(i(), i2, i3, i4, i5));
            return bVar.a();
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return this.c.isRound();
        }

        public void p(androidx.core.graphics.a[] aVarArr) {
            this.d = aVarArr;
        }

        /* access modifiers changed from: package-private */
        public void q(@NonNull androidx.core.graphics.a aVar) {
            this.g = aVar;
        }

        /* access modifiers changed from: package-private */
        public void r(m mVar) {
            this.f = mVar;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public androidx.core.graphics.a u(int i2, boolean z) {
            int i3;
            if (i2 == 1) {
                return z ? androidx.core.graphics.a.b(0, Math.max(v().b, k().b), 0, 0) : androidx.core.graphics.a.b(0, k().b, 0, 0);
            }
            androidx.core.graphics.a aVar = null;
            if (i2 != 2) {
                if (i2 == 8) {
                    androidx.core.graphics.a[] aVarArr = this.d;
                    if (aVarArr != null) {
                        aVar = aVarArr[C0041m.a(8)];
                    }
                    if (aVar != null) {
                        return aVar;
                    }
                    androidx.core.graphics.a k2 = k();
                    androidx.core.graphics.a v = v();
                    int i4 = k2.d;
                    if (i4 > v.d) {
                        return androidx.core.graphics.a.b(0, 0, 0, i4);
                    }
                    androidx.core.graphics.a aVar2 = this.g;
                    return (aVar2 == null || aVar2.equals(androidx.core.graphics.a.e) || (i3 = this.g.d) <= v.d) ? androidx.core.graphics.a.e : androidx.core.graphics.a.b(0, 0, 0, i3);
                } else if (i2 == 16) {
                    return j();
                } else {
                    if (i2 == 32) {
                        return h();
                    }
                    if (i2 == 64) {
                        return l();
                    }
                    if (i2 != 128) {
                        return androidx.core.graphics.a.e;
                    }
                    m mVar = this.f;
                    b e2 = mVar != null ? mVar.e() : f();
                    return e2 != null ? androidx.core.graphics.a.b(e2.b(), e2.d(), e2.c(), e2.a()) : androidx.core.graphics.a.e;
                }
            } else if (z) {
                androidx.core.graphics.a v2 = v();
                androidx.core.graphics.a i5 = i();
                return androidx.core.graphics.a.b(Math.max(v2.a, i5.a), 0, Math.max(v2.c, i5.c), Math.max(v2.d, i5.d));
            } else {
                androidx.core.graphics.a k3 = k();
                m mVar2 = this.f;
                if (mVar2 != null) {
                    aVar = mVar2.g();
                }
                int i6 = k3.d;
                if (aVar != null) {
                    i6 = Math.min(i6, aVar.d);
                }
                return androidx.core.graphics.a.b(k3.a, 0, k3.c, i6);
            }
        }
    }

    private static class h extends g {
        private androidx.core.graphics.a m = null;

        h(@NonNull m mVar, @NonNull WindowInsets windowInsets) {
            super(mVar, windowInsets);
        }

        h(@NonNull m mVar, @NonNull h hVar) {
            super(mVar, (g) hVar);
            this.m = hVar.m;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m b() {
            return m.v(this.c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m c() {
            return m.v(this.c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final androidx.core.graphics.a i() {
            if (this.m == null) {
                this.m = androidx.core.graphics.a.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return this.c.isConsumed();
        }

        public void s(androidx.core.graphics.a aVar) {
            this.m = aVar;
        }
    }

    private static class i extends h {
        i(@NonNull m mVar, @NonNull WindowInsets windowInsets) {
            super(mVar, windowInsets);
        }

        i(@NonNull m mVar, @NonNull i iVar) {
            super(mVar, (h) iVar);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m a() {
            return m.v(this.c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.c, iVar.c) && Objects.equals(this.g, iVar.g);
        }

        /* access modifiers changed from: package-private */
        public b f() {
            return b.e(this.c.getDisplayCutout());
        }

        public int hashCode() {
            return this.c.hashCode();
        }
    }

    private static class j extends i {
        private androidx.core.graphics.a n = null;
        private androidx.core.graphics.a o = null;
        private androidx.core.graphics.a p = null;

        j(@NonNull m mVar, @NonNull WindowInsets windowInsets) {
            super(mVar, windowInsets);
        }

        j(@NonNull m mVar, @NonNull j jVar) {
            super(mVar, (i) jVar);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a h() {
            if (this.o == null) {
                this.o = androidx.core.graphics.a.d(this.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a j() {
            if (this.n == null) {
                this.n = androidx.core.graphics.a.d(this.c.getSystemGestureInsets());
            }
            return this.n;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a l() {
            if (this.p == null) {
                this.p = androidx.core.graphics.a.d(this.c.getTappableElementInsets());
            }
            return this.p;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m m(int i, int i2, int i3, int i4) {
            return m.v(this.c.inset(i, i2, i3, i4));
        }

        public void s(androidx.core.graphics.a aVar) {
        }
    }

    private static class k extends j {
        @NonNull
        static final m q = m.v(WindowInsets.CONSUMED);

        k(@NonNull m mVar, @NonNull WindowInsets windowInsets) {
            super(mVar, windowInsets);
        }

        k(@NonNull m mVar, @NonNull k kVar) {
            super(mVar, (j) kVar);
        }

        /* access modifiers changed from: package-private */
        public final void d(@NonNull View view) {
        }

        @NonNull
        public androidx.core.graphics.a g(int i) {
            return androidx.core.graphics.a.d(this.c.getInsets(n.a(i)));
        }
    }

    private static class l {
        @NonNull
        static final m b = new b().a().a().b().c();
        final m a;

        l(@NonNull m mVar) {
            this.a = mVar;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m a() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m b() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m c() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull m mVar) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && androidx.core.util.a.a(k(), lVar.k()) && androidx.core.util.a.a(i(), lVar.i()) && androidx.core.util.a.a(f(), lVar.f());
        }

        /* access modifiers changed from: package-private */
        public b f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a g(int i) {
            return androidx.core.graphics.a.e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.a.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a i() {
            return androidx.core.graphics.a.e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a j() {
            return k();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a k() {
            return androidx.core.graphics.a.e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.a l() {
            return k();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public m m(int i, int i2, int i3, int i4) {
            return b;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.a[] aVarArr) {
        }

        /* access modifiers changed from: package-private */
        public void q(@NonNull androidx.core.graphics.a aVar) {
        }

        /* access modifiers changed from: package-private */
        public void r(m mVar) {
        }

        public void s(androidx.core.graphics.a aVar) {
        }
    }

    /* renamed from: androidx.core.view.m$m  reason: collision with other inner class name */
    public static final class C0041m {
        static int a(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        public static int b() {
            return 32;
        }

        public static int c() {
            return 2;
        }

        public static int d() {
            return 1;
        }

        public static int e() {
            return 7;
        }
    }

    private static final class n {
        static int a(int i) {
            int i2;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i & i4) != 0) {
                    if (i4 == 1) {
                        i2 = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        i2 = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        i2 = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        i2 = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        i2 = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        i2 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        i2 = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        i2 = WindowInsets.Type.displayCutout();
                    }
                    i3 |= i2;
                }
            }
            return i3;
        }
    }

    private m(@NonNull WindowInsets windowInsets) {
        l gVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            gVar = new k(this, windowInsets);
        } else if (i2 >= 29) {
            gVar = new j(this, windowInsets);
        } else if (i2 >= 28) {
            gVar = new i(this, windowInsets);
        } else if (i2 >= 21) {
            gVar = new h(this, windowInsets);
        } else if (i2 >= 20) {
            gVar = new g(this, windowInsets);
        } else {
            this.a = new l(this);
            return;
        }
        this.a = gVar;
    }

    public m(m mVar) {
        if (mVar != null) {
            l lVar = mVar.a;
            int i2 = Build.VERSION.SDK_INT;
            this.a = (i2 < 30 || !(lVar instanceof k)) ? (i2 < 29 || !(lVar instanceof j)) ? (i2 < 28 || !(lVar instanceof i)) ? (i2 < 21 || !(lVar instanceof h)) ? (i2 < 20 || !(lVar instanceof g)) ? new l(this) : new g(this, (g) lVar) : new h(this, (h) lVar) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
            lVar.e(this);
            return;
        }
        this.a = new l(this);
    }

    static androidx.core.graphics.a n(@NonNull androidx.core.graphics.a aVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, aVar.a - i2);
        int max2 = Math.max(0, aVar.b - i3);
        int max3 = Math.max(0, aVar.c - i4);
        int max4 = Math.max(0, aVar.d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? aVar : androidx.core.graphics.a.b(max, max2, max3, max4);
    }

    @NonNull
    public static m v(@NonNull WindowInsets windowInsets) {
        return w(windowInsets, (View) null);
    }

    @NonNull
    public static m w(@NonNull WindowInsets windowInsets, View view) {
        m mVar = new m((WindowInsets) com.microsoft.clarity.z1.e.f(windowInsets));
        if (view != null && g.W(view)) {
            mVar.s(g.L(view));
            mVar.d(view.getRootView());
        }
        return mVar;
    }

    @NonNull
    @Deprecated
    public m a() {
        return this.a.a();
    }

    @NonNull
    @Deprecated
    public m b() {
        return this.a.b();
    }

    @NonNull
    @Deprecated
    public m c() {
        return this.a.c();
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull View view) {
        this.a.d(view);
    }

    public b e() {
        return this.a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        return androidx.core.util.a.a(this.a, ((m) obj).a);
    }

    @NonNull
    public androidx.core.graphics.a f(int i2) {
        return this.a.g(i2);
    }

    @NonNull
    @Deprecated
    public androidx.core.graphics.a g() {
        return this.a.i();
    }

    @NonNull
    @Deprecated
    public androidx.core.graphics.a h() {
        return this.a.j();
    }

    public int hashCode() {
        l lVar = this.a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.a.k().d;
    }

    @Deprecated
    public int j() {
        return this.a.k().a;
    }

    @Deprecated
    public int k() {
        return this.a.k().c;
    }

    @Deprecated
    public int l() {
        return this.a.k().b;
    }

    @NonNull
    public m m(int i2, int i3, int i4, int i5) {
        return this.a.m(i2, i3, i4, i5);
    }

    public boolean o() {
        return this.a.n();
    }

    @NonNull
    @Deprecated
    public m p(int i2, int i3, int i4, int i5) {
        return new b(this).c(androidx.core.graphics.a.b(i2, i3, i4, i5)).a();
    }

    /* access modifiers changed from: package-private */
    public void q(androidx.core.graphics.a[] aVarArr) {
        this.a.p(aVarArr);
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull androidx.core.graphics.a aVar) {
        this.a.q(aVar);
    }

    /* access modifiers changed from: package-private */
    public void s(m mVar) {
        this.a.r(mVar);
    }

    /* access modifiers changed from: package-private */
    public void t(androidx.core.graphics.a aVar) {
        this.a.s(aVar);
    }

    public WindowInsets u() {
        l lVar = this.a;
        if (lVar instanceof g) {
            return ((g) lVar).c;
        }
        return null;
    }
}
