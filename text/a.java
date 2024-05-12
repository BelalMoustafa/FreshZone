package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a {
    private static Method a;
    private static Method b;

    /* renamed from: androidx.core.text.a$a  reason: collision with other inner class name */
    static class C0035a {
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    static class b {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        Class<String> cls = String.class;
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            try {
                Class<?> cls2 = Class.forName("libcore.icu.ICU");
                a = cls2.getMethod("getScript", new Class[]{cls});
                b = cls2.getMethod("addLikelySubtags", new Class[]{cls});
            } catch (Exception e) {
                a = null;
                b = null;
                Log.w("ICUCompat", e);
            }
        } else if (i < 24) {
            try {
                b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = b;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.w("ICUCompat", e);
        }
        return locale2;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String b(String str) {
        try {
            Method method = a;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.w("ICUCompat", e);
        }
        return null;
    }

    public static String c(@NonNull Locale locale) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        if (i >= 21) {
            try {
                return C0035a.a((Locale) b.invoke((Object) null, new Object[]{locale}));
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.w("ICUCompat", e);
                return C0035a.a(locale);
            }
        } else {
            String a2 = a(locale);
            if (a2 != null) {
                return b(a2);
            }
            return null;
        }
    }
}
