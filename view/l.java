package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;

public final class l {

    static class a {
        static void a(@NonNull Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & -1793 : systemUiVisibility | 1792);
        }
    }

    static class b {
        static void a(@NonNull Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    @NonNull
    public static o a(@NonNull Window window, @NonNull View view) {
        return new o(window, view);
    }

    public static void b(@NonNull Window window, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            b.a(window, z);
        } else if (i >= 16) {
            a.a(window, z);
        }
    }
}
