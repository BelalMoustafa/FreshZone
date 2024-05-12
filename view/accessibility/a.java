package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;

public final class a {

    /* renamed from: androidx.core.view.accessibility.a$a  reason: collision with other inner class name */
    static class C0038a {
        static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        static void b(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    public static int a(@NonNull AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C0038a.a(accessibilityEvent);
        }
        return 0;
    }

    public static void b(@NonNull AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            C0038a.b(accessibilityEvent, i);
        }
    }
}
