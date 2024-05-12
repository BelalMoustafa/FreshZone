package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.f;
import androidx.core.provider.g;

class a {
    @NonNull
    private final g.c a;
    @NonNull
    private final Handler b;

    /* renamed from: androidx.core.provider.a$a  reason: collision with other inner class name */
    class C0033a implements Runnable {
        final /* synthetic */ g.c h;
        final /* synthetic */ Typeface i;

        C0033a(a aVar, g.c cVar, Typeface typeface) {
            this.h = cVar;
            this.i = typeface;
        }

        public void run() {
            this.h.b(this.i);
        }
    }

    class b implements Runnable {
        final /* synthetic */ g.c h;
        final /* synthetic */ int i;

        b(a aVar, g.c cVar, int i2) {
            this.h = cVar;
            this.i = i2;
        }

        public void run() {
            this.h.a(this.i);
        }
    }

    a(@NonNull g.c cVar, @NonNull Handler handler) {
        this.a = cVar;
        this.b = handler;
    }

    private void a(int i) {
        this.b.post(new b(this, this.a, i));
    }

    private void c(@NonNull Typeface typeface) {
        this.b.post(new C0033a(this, this.a, typeface));
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull f.e eVar) {
        if (eVar.a()) {
            c(eVar.a);
        } else {
            a(eVar.b);
        }
    }
}
