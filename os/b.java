package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;

public final class b {

    static class a {
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    @NonNull
    public static c a(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return c.d(a.a(configuration));
        }
        return c.a(configuration.locale);
    }
}
