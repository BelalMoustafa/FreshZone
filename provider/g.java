package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.microsoft.clarity.z1.e;
import java.util.concurrent.Executor;

public class g {

    public static class a {
        private final int a;
        private final b[] b;

        @Deprecated
        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = bVarArr;
        }

        static a a(int i, b[] bVarArr) {
            return new a(i, bVarArr);
        }

        public b[] b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        @Deprecated
        public b(@NonNull Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) e.f(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        static b a(@NonNull Uri uri, int i, int i2, boolean z, int i3) {
            return new b(uri, i, i2, z, i3);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        @NonNull
        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    public static class c {
        public void a(int i) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(@NonNull Context context, @NonNull e eVar, int i, boolean z, int i2, @NonNull Handler handler, @NonNull c cVar) {
        a aVar = new a(cVar, handler);
        return z ? f.e(context, eVar, aVar, i, i2) : f.d(context, eVar, i, (Executor) null, aVar);
    }
}
