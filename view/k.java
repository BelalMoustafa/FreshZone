package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import com.microsoft.clarity.a2.a0;
import com.microsoft.clarity.a2.x;
import com.microsoft.clarity.a2.y;
import java.lang.ref.WeakReference;

public final class k {
    private final WeakReference<View> a;
    Runnable b = null;
    Runnable c = null;
    int d = -1;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ y a;
        final /* synthetic */ View b;

        a(k kVar, y yVar, View view) {
            this.a = yVar;
            this.b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.a.a(this.b);
        }

        public void onAnimationEnd(Animator animator) {
            this.a.b(this.b);
        }

        public void onAnimationStart(Animator animator) {
            this.a.c(this.b);
        }
    }

    static class b {
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    static class c implements y {
        k a;
        boolean b;

        c(k kVar) {
            this.a = kVar;
        }

        public void a(@NonNull View view) {
            Object tag = view.getTag(2113929216);
            y yVar = tag instanceof y ? (y) tag : null;
            if (yVar != null) {
                yVar.a(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.microsoft.clarity.a2.y} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(@androidx.annotation.NonNull android.view.View r4) {
            /*
                r3 = this;
                androidx.core.view.k r0 = r3.a
                int r0 = r0.d
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r4.setLayerType(r0, r2)
                androidx.core.view.k r0 = r3.a
                r0.d = r1
            L_0x000f:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x0019
                boolean r0 = r3.b
                if (r0 != 0) goto L_0x0039
            L_0x0019:
                androidx.core.view.k r0 = r3.a
                java.lang.Runnable r1 = r0.c
                if (r1 == 0) goto L_0x0024
                r0.c = r2
                r1.run()
            L_0x0024:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof com.microsoft.clarity.a2.y
                if (r1 == 0) goto L_0x0031
                r2 = r0
                com.microsoft.clarity.a2.y r2 = (com.microsoft.clarity.a2.y) r2
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r2.b(r4)
            L_0x0036:
                r4 = 1
                r3.b = r4
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.k.c.b(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.microsoft.clarity.a2.y} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(@androidx.annotation.NonNull android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.b = r0
                androidx.core.view.k r0 = r3.a
                int r0 = r0.d
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.view.k r0 = r3.a
                java.lang.Runnable r2 = r0.b
                if (r2 == 0) goto L_0x001a
                r0.b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof com.microsoft.clarity.a2.y
                if (r2 == 0) goto L_0x0027
                r1 = r0
                com.microsoft.clarity.a2.y r1 = (com.microsoft.clarity.a2.y) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.c(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.k.c.c(android.view.View):void");
        }
    }

    k(View view) {
        this.a = new WeakReference<>(view);
    }

    private void i(View view, y yVar) {
        if (yVar != null) {
            view.animate().setListener(new a(this, yVar, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public k b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void c() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    @NonNull
    public k f(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    @NonNull
    public k g(Interpolator interpolator) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public k h(y yVar) {
        View view = (View) this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, yVar);
                yVar = new c(this);
            }
            i(view, yVar);
        }
        return this;
    }

    @NonNull
    public k j(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    @NonNull
    public k k(a0 a0Var) {
        View view = (View) this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            x xVar = null;
            if (a0Var != null) {
                xVar = new x(a0Var, view);
            }
            b.a(view.animate(), xVar);
        }
        return this;
    }

    public void l() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public k m(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
