package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

public final class b {

    static class a {
        static void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    /* renamed from: androidx.core.widget.b$b  reason: collision with other inner class name */
    private static class C0043b {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f, float f2) {
            try {
                return edgeEffect.onPullDistance(f, f2);
            } catch (Throwable unused) {
                edgeEffect.onPull(f, f2);
                return 0.0f;
            }
        }
    }

    @NonNull
    public static EdgeEffect a(@NonNull Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? C0043b.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float b(@NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C0043b.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void c(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(edgeEffect, f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }

    public static float d(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C0043b.c(edgeEffect, f, f2);
        }
        c(edgeEffect, f, f2);
        return f;
    }
}
