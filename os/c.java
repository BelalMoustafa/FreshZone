package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import java.util.Locale;

public final class c {
    private final e a;

    static class a {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    static {
        a(new Locale[0]);
    }

    private c(e eVar) {
        this.a = eVar;
    }

    @NonNull
    public static c a(@NonNull Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? d(a.a(localeArr)) : new c(new d(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static c d(@NonNull LocaleList localeList) {
        return new c(new f(localeList));
    }

    public Locale c(int i) {
        return this.a.get(i);
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a.equals(((c) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NonNull
    public String toString() {
        return this.a.toString();
    }
}
