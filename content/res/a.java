package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import com.adapty.internal.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class a {

    /* renamed from: androidx.core.content.res.a$a  reason: collision with other inner class name */
    static class C0026a {
        static int a(TypedArray typedArray, int i) {
            return typedArray.getType(i);
        }
    }

    public interface b {
    }

    public static final class c implements b {
        @NonNull
        private final d[] a;

        public c(@NonNull d[] dVarArr) {
            this.a = dVarArr;
        }

        @NonNull
        public d[] a() {
            return this.a;
        }
    }

    public static final class d {
        @NonNull
        private final String a;
        private final int b;
        private final boolean c;
        private final String d;
        private final int e;
        private final int f;

        public d(@NonNull String str, int i, boolean z, String str2, int i2, int i3) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        @NonNull
        public String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.b;
        }

        public boolean f() {
            return this.c;
        }
    }

    public static final class e implements b {
        @NonNull
        private final androidx.core.provider.e a;
        private final int b;
        private final int c;
        private final String d;

        public e(@NonNull androidx.core.provider.e eVar, int i, int i2, String str) {
            this.a = eVar;
            this.c = i;
            this.b = i2;
            this.d = str;
        }

        public int a() {
            return this.c;
        }

        @NonNull
        public androidx.core.provider.e b() {
            return this.a;
        }

        public String c() {
            return this.d;
        }

        public int d() {
            return this.b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0026a.a(typedArray, i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static androidx.core.content.res.a.b b(@androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r3, @androidx.annotation.NonNull android.content.res.Resources r4) {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.res.a$b r3 = d(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.a.b(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.res.a$b");
    }

    @NonNull
    public static List<List<byte[]>> c(@NonNull Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), com.microsoft.clarity.p1.d.g);
        String string = obtainAttributes.getString(com.microsoft.clarity.p1.d.h);
        String string2 = obtainAttributes.getString(com.microsoft.clarity.p1.d.l);
        String string3 = obtainAttributes.getString(com.microsoft.clarity.p1.d.m);
        int resourceId = obtainAttributes.getResourceId(com.microsoft.clarity.p1.d.i, 0);
        int integer = obtainAttributes.getInteger(com.microsoft.clarity.p1.d.j, 1);
        int integer2 = obtainAttributes.getInteger(com.microsoft.clarity.p1.d.k, UtilsKt.PAYWALL_TIMEOUT_MILLIS_SHIFT);
        String string4 = obtainAttributes.getString(com.microsoft.clarity.p1.d.n);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new c((d[]) arrayList.toArray(new d[0]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), com.microsoft.clarity.p1.d.o);
        int i = com.microsoft.clarity.p1.d.x;
        if (!obtainAttributes.hasValue(i)) {
            i = com.microsoft.clarity.p1.d.q;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        int i3 = com.microsoft.clarity.p1.d.v;
        if (!obtainAttributes.hasValue(i3)) {
            i3 = com.microsoft.clarity.p1.d.r;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        int i4 = com.microsoft.clarity.p1.d.y;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = com.microsoft.clarity.p1.d.s;
        }
        int i5 = com.microsoft.clarity.p1.d.w;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = com.microsoft.clarity.p1.d.t;
        }
        String string = obtainAttributes.getString(i5);
        int i6 = obtainAttributes.getInt(i4, 0);
        int i7 = com.microsoft.clarity.p1.d.u;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = com.microsoft.clarity.p1.d.p;
        }
        int resourceId = obtainAttributes.getResourceId(i7, 0);
        String string2 = obtainAttributes.getString(i7);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i2, z, string, i6, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }
}
