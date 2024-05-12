package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;

public final class b {

    static class a {
        static PathInterpolator a(float f, float f2) {
            return new PathInterpolator(f, f2);
        }

        static PathInterpolator b(float f, float f2, float f3, float f4) {
            return new PathInterpolator(f, f2, f3, f4);
        }

        static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    @NonNull
    public static Interpolator a(float f, float f2, float f3, float f4) {
        return Build.VERSION.SDK_INT >= 21 ? a.b(f, f2, f3, f4) : new a(f, f2, f3, f4);
    }

    @NonNull
    public static Interpolator b(@NonNull Path path) {
        return Build.VERSION.SDK_INT >= 21 ? a.c(path) : new a(path);
    }
}
