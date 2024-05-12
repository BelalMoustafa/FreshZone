package androidx.core.util;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;

public class a {

    /* renamed from: androidx.core.util.a$a  reason: collision with other inner class name */
    static class C0036a {
        static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return Build.VERSION.SDK_INT >= 19 ? C0036a.a(obj, obj2) : obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Build.VERSION.SDK_INT >= 19 ? C0036a.b(objArr) : Arrays.hashCode(objArr);
    }

    @NonNull
    public static <T> T c(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    @NonNull
    public static <T> T d(T t, @NonNull String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static String e(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
