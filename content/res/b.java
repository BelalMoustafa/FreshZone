package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.microsoft.clarity.s1.g;
import com.microsoft.clarity.s1.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public final class b {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    private static final WeakHashMap<d, SparseArray<c>> b = new WeakHashMap<>(0);
    private static final Object c = new Object();

    static class a {
        static Drawable a(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }

        static Drawable b(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
    }

    /* renamed from: androidx.core.content.res.b$b  reason: collision with other inner class name */
    static class C0027b {
        static int a(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }

        @NonNull
        static ColorStateList b(@NonNull Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }
    }

    private static class c {
        final ColorStateList a;
        final Configuration b;
        final int c;

        c(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, Resources.Theme theme) {
            this.a = colorStateList;
            this.b = configuration;
            this.c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class d {
        final Resources a;
        final Resources.Theme b;

        d(@NonNull Resources resources, Resources.Theme theme) {
            this.a = resources;
            this.b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a.equals(dVar.a) && androidx.core.util.a.a(this.b, dVar.b);
        }

        public int hashCode() {
            return androidx.core.util.a.b(this.a, this.b);
        }
    }

    public static abstract class e {
        @NonNull
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(int i, Handler handler) {
            e(handler).post(new g(this, i));
        }

        public final void d(@NonNull Typeface typeface, Handler handler) {
            e(handler).post(new h(this, typeface));
        }

        /* renamed from: h */
        public abstract void f(int i);

        /* renamed from: i */
        public abstract void g(@NonNull Typeface typeface);
    }

    public static final class f {

        static class a {
            private static final Object a = new Object();
            private static Method b;
            private static boolean c;

            @SuppressLint({"BanUncheckedReflection"})
            static void a(@NonNull Resources.Theme theme) {
                synchronized (a) {
                    if (!c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                        }
                        c = true;
                    }
                    Method method = b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                            b = null;
                        }
                    }
                }
            }
        }

        /* renamed from: androidx.core.content.res.b$f$b  reason: collision with other inner class name */
        static class C0028b {
            static void a(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(@NonNull Resources.Theme theme) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                C0028b.a(theme);
            } else if (i >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(@NonNull d dVar, int i, @NonNull ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (c) {
            WeakHashMap<d, SparseArray<c>> weakHashMap = b;
            SparseArray sparseArray = weakHashMap.get(dVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(dVar, sparseArray);
            }
            sparseArray.append(i, new c(colorStateList, dVar.a.getConfiguration(), theme));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList b(@androidx.annotation.NonNull androidx.core.content.res.b.d r5, int r6) {
        /*
            java.lang.Object r0 = c
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.b$d, android.util.SparseArray<androidx.core.content.res.b$c>> r1 = b     // Catch:{ all -> 0x0045 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0045 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0042
            int r2 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r2 <= 0) goto L_0x0042
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0045 }
            androidx.core.content.res.b$c r2 = (androidx.core.content.res.b.c) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0042
            android.content.res.Configuration r3 = r2.b     // Catch:{ all -> 0x0045 }
            android.content.res.Resources r4 = r5.a     // Catch:{ all -> 0x0045 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003f
            android.content.res.Resources$Theme r5 = r5.b     // Catch:{ all -> 0x0045 }
            if (r5 != 0) goto L_0x0031
            int r3 = r2.c     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003b
        L_0x0031:
            if (r5 == 0) goto L_0x003f
            int r3 = r2.c     // Catch:{ all -> 0x0045 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0045 }
            if (r3 != r5) goto L_0x003f
        L_0x003b:
            android.content.res.ColorStateList r5 = r2.a     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r5
        L_0x003f:
            r1.remove(r6)     // Catch:{ all -> 0x0045 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            r5 = 0
            return r5
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.b.b(androidx.core.content.res.b$d, int):android.content.res.ColorStateList");
    }

    public static Typeface c(@NonNull Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i, new TypedValue(), 0, (e) null, (Handler) null, false, true);
    }

    public static int d(@NonNull Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 23 ? C0027b.a(resources, i, theme) : resources.getColor(i);
    }

    public static ColorStateList e(@NonNull Resources resources, int i, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList b2 = b(dVar, i);
        if (b2 != null) {
            return b2;
        }
        ColorStateList k = k(resources, i, theme);
        if (k == null) {
            return Build.VERSION.SDK_INT >= 23 ? C0027b.b(resources, i, theme) : resources.getColorStateList(i);
        }
        a(dVar, i, k, theme);
        return k;
    }

    public static Drawable f(@NonNull Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? a.a(resources, i, theme) : resources.getDrawable(i);
    }

    public static Typeface g(@NonNull Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i, new TypedValue(), 0, (e) null, (Handler) null, false, false);
    }

    public static Typeface h(@NonNull Context context, int i, @NonNull TypedValue typedValue, int i2, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i, typedValue, i2, eVar, (Handler) null, true, false);
    }

    public static void i(@NonNull Context context, int i, @NonNull e eVar, Handler handler) {
        com.microsoft.clarity.z1.e.f(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
            return;
        }
        m(context, i, new TypedValue(), 0, eVar, handler, false, false);
    }

    @NonNull
    private static TypedValue j() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList k(Resources resources, int i, Resources.Theme theme) {
        if (l(resources, i)) {
            return null;
        }
        try {
            return com.microsoft.clarity.s1.c.a(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean l(@NonNull Resources resources, int i) {
        TypedValue j = j();
        resources.getValue(i, j, true);
        int i2 = j.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static Typeface m(@NonNull Context context, int i, @NonNull TypedValue typedValue, int i2, e eVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        int i3 = i;
        resources.getValue(i, typedValue, true);
        Typeface n = n(context, resources, typedValue, i, i2, eVar, handler, z, z2);
        if (n != null || eVar != null || z2) {
            return n;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface n(@androidx.annotation.NonNull android.content.Context r17, android.content.res.Resources r18, @androidx.annotation.NonNull android.util.TypedValue r19, int r20, int r21, androidx.core.content.res.b.e r22, android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00ae
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L_0x0025
            if (r11 == 0) goto L_0x0024
            r11.c(r15, r12)
        L_0x0024:
            return r16
        L_0x0025:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = com.microsoft.clarity.t1.c.f(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L_0x0035
            if (r11 == 0) goto L_0x0034
            r11.d(r2, r12)
        L_0x0034:
            return r2
        L_0x0035:
            if (r25 == 0) goto L_0x0038
            return r16
        L_0x0038:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r2 == 0) goto L_0x006f
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            androidx.core.content.res.a$b r2 = androidx.core.content.res.a.b(r2, r0)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r2 != 0) goto L_0x0059
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0058
            r11.c(r15, r12)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
        L_0x0058:
            return r16
        L_0x0059:
            int r6 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = com.microsoft.clarity.t1.c.c(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            return r0
        L_0x006f:
            int r5 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = com.microsoft.clarity.t1.c.d(r1, r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0086
            r11.d(r0, r12)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
            goto L_0x0089
        L_0x0086:
            r11.c(r15, r12)     // Catch:{ XmlPullParserException -> 0x0093, IOException -> 0x008a }
        L_0x0089:
            return r0
        L_0x008a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            goto L_0x009b
        L_0x0093:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
        L_0x009b:
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            if (r11 == 0) goto L_0x00ad
            r11.c(r15, r12)
        L_0x00ad:
            return r16
        L_0x00ae:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r20)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.b.n(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.b$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
