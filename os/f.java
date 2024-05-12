package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class f implements e {
    private final LocaleList a;

    f(Object obj) {
        this.a = (LocaleList) obj;
    }

    public Object a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this.a.equals(((e) obj).a());
    }

    public Locale get(int i) {
        return this.a.get(i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
