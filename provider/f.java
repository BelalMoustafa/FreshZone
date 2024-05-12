package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.collection.g;
import androidx.core.provider.g;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class f {
    static final androidx.collection.e<String, Typeface> a = new androidx.collection.e<>(16);
    private static final ExecutorService b = h.a("fonts-androidx", 10, 10000);
    static final Object c = new Object();
    static final g<String, ArrayList<com.microsoft.clarity.z1.a<e>>> d = new g<>();

    class a implements Callable<e> {
        final /* synthetic */ String h;
        final /* synthetic */ Context i;
        final /* synthetic */ e j;
        final /* synthetic */ int k;

        a(String str, Context context, e eVar, int i2) {
            this.h = str;
            this.i = context;
            this.j = eVar;
            this.k = i2;
        }

        /* renamed from: a */
        public e call() {
            return f.c(this.h, this.i, this.j, this.k);
        }
    }

    class b implements com.microsoft.clarity.z1.a<e> {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        /* renamed from: a */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.a.b(eVar);
        }
    }

    class c implements Callable<e> {
        final /* synthetic */ String h;
        final /* synthetic */ Context i;
        final /* synthetic */ e j;
        final /* synthetic */ int k;

        c(String str, Context context, e eVar, int i2) {
            this.h = str;
            this.i = context;
            this.j = eVar;
            this.k = i2;
        }

        /* renamed from: a */
        public e call() {
            try {
                return f.c(this.h, this.i, this.j, this.k);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements com.microsoft.clarity.z1.a<e> {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r0 >= r2.size()) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            ((com.microsoft.clarity.z1.a) r2.get(r0)).accept(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0 = 0;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(androidx.core.provider.f.e r5) {
            /*
                r4 = this;
                java.lang.Object r0 = androidx.core.provider.f.c
                monitor-enter(r0)
                androidx.collection.g<java.lang.String, java.util.ArrayList<com.microsoft.clarity.z1.a<androidx.core.provider.f$e>>> r1 = androidx.core.provider.f.d     // Catch:{ all -> 0x002b }
                java.lang.String r2 = r4.a     // Catch:{ all -> 0x002b }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
                if (r2 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0011:
                java.lang.String r3 = r4.a     // Catch:{ all -> 0x002b }
                r1.remove(r3)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                r0 = 0
            L_0x0018:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002a
                java.lang.Object r1 = r2.get(r0)
                com.microsoft.clarity.z1.a r1 = (com.microsoft.clarity.z1.a) r1
                r1.accept(r5)
                int r0 = r0 + 1
                goto L_0x0018
            L_0x002a:
                return
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.f.d.accept(androidx.core.provider.f$e):void");
        }
    }

    static final class e {
        final Typeface a;
        final int b;

        e(int i) {
            this.a = null;
            this.b = i;
        }

        @SuppressLint({"WrongConstant"})
        e(@NonNull Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.b == 0;
        }
    }

    private static String a(@NonNull e eVar, int i) {
        return eVar.d() + "-" + i;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(@NonNull g.a aVar) {
        int i = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] b2 = aVar.b();
        if (!(b2 == null || b2.length == 0)) {
            int length = b2.length;
            i = 0;
            int i2 = 0;
            while (i2 < length) {
                int b3 = b2[i2].b();
                if (b3 == 0) {
                    i2++;
                } else if (b3 < 0) {
                    return -3;
                } else {
                    return b3;
                }
            }
        }
        return i;
    }

    @NonNull
    static e c(@NonNull String str, @NonNull Context context, @NonNull e eVar, int i) {
        androidx.collection.e<String, Typeface> eVar2 = a;
        Typeface typeface = eVar2.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a e2 = d.e(context, eVar, (CancellationSignal) null);
            int b2 = b(e2);
            if (b2 != 0) {
                return new e(b2);
            }
            Typeface b3 = com.microsoft.clarity.t1.c.b(context, (CancellationSignal) null, e2.b(), i);
            if (b3 == null) {
                return new e(-3);
            }
            eVar2.put(str, b3);
            return new e(b3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r9 = new androidx.core.provider.f.c(r0, r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r8 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r8 = b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        androidx.core.provider.h.b(r8, r9, new androidx.core.provider.f.d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Typeface d(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull androidx.core.provider.e r6, int r7, java.util.concurrent.Executor r8, @androidx.annotation.NonNull androidx.core.provider.a r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            androidx.collection.e<java.lang.String, android.graphics.Typeface> r1 = a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.f$e r5 = new androidx.core.provider.f$e
            r5.<init>((android.graphics.Typeface) r1)
            r9.b(r5)
            return r1
        L_0x0017:
            androidx.core.provider.f$b r1 = new androidx.core.provider.f$b
            r1.<init>(r9)
            java.lang.Object r9 = c
            monitor-enter(r9)
            androidx.collection.g<java.lang.String, java.util.ArrayList<com.microsoft.clarity.z1.a<androidx.core.provider.f$e>>> r2 = d     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x004d }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x004d }
            r4 = 0
            if (r3 == 0) goto L_0x002f
            r3.add(r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            return r4
        L_0x002f:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            r3.add(r1)     // Catch:{ all -> 0x004d }
            r2.put(r0, r3)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            androidx.core.provider.f$c r9 = new androidx.core.provider.f$c
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r8 = b
        L_0x0044:
            androidx.core.provider.f$d r5 = new androidx.core.provider.f$d
            r5.<init>(r0)
            androidx.core.provider.h.b(r8, r9, r5)
            return r4
        L_0x004d:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.f.d(android.content.Context, androidx.core.provider.e, int, java.util.concurrent.Executor, androidx.core.provider.a):android.graphics.Typeface");
    }

    static Typeface e(@NonNull Context context, @NonNull e eVar, @NonNull a aVar, int i, int i2) {
        String a2 = a(eVar, i);
        Typeface typeface = a.get(a2);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        } else if (i2 == -1) {
            e c2 = c(a2, context, eVar, i);
            aVar.b(c2);
            return c2.a;
        } else {
            try {
                e eVar2 = (e) h.c(b, new a(a2, context, eVar, i), i2);
                aVar.b(eVar2);
                return eVar2.a;
            } catch (InterruptedException unused) {
                aVar.b(new e(-3));
                return null;
            }
        }
    }
}
