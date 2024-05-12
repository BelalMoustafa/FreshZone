package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.microsoft.clarity.p1.c;

public final class i {

    static class a {
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }
    }

    public static boolean a(@NonNull ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.b(viewGroup);
        }
        Boolean bool = (Boolean) viewGroup.getTag(c.Q);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && g.N(viewGroup) == null) ? false : true;
    }
}
