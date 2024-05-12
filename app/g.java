package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

public class g {

    public static class a {
        final Bundle a;
        private IconCompat b;
        private final k[] c;
        private final k[] d;
        private boolean e;
        boolean f;
        private final int g;
        private final boolean h;
        @Deprecated
        public int i;
        public CharSequence j;
        public PendingIntent k;
        private boolean l;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.h((Resources) null, "", i2) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (k[]) null, (k[]) null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, k[] kVarArr, k[] kVarArr2, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
            this.f = true;
            this.b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.i = iconCompat.j();
            }
            this.j = e.e(charSequence);
            this.k = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.c = kVarArr;
            this.d = kVarArr2;
            this.e = z;
            this.g = i2;
            this.f = z2;
            this.h = z3;
            this.l = z4;
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public k[] c() {
            return this.d;
        }

        @NonNull
        public Bundle d() {
            return this.a;
        }

        public IconCompat e() {
            int i2;
            if (this.b == null && (i2 = this.i) != 0) {
                this.b = IconCompat.h((Resources) null, "", i2);
            }
            return this.b;
        }

        public k[] f() {
            return this.c;
        }

        public int g() {
            return this.g;
        }

        public boolean h() {
            return this.f;
        }

        public CharSequence i() {
            return this.j;
        }

        public boolean j() {
            return this.l;
        }

        public boolean k() {
            return this.h;
        }
    }

    public static class b extends h {
        private IconCompat e;
        private IconCompat f;
        private boolean g;
        private CharSequence h;
        private boolean i;

        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* renamed from: androidx.core.app.g$b$b  reason: collision with other inner class name */
        private static class C0020b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        private static class c {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z) {
                bigPictureStyle.showBigPictureWhenCollapsed(z);
            }
        }

        public void b(com.microsoft.clarity.q1.e eVar) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 16) {
                Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(eVar.a()).setBigContentTitle(this.b);
                IconCompat iconCompat = this.e;
                Context context = null;
                if (iconCompat != null) {
                    if (i2 >= 31) {
                        c.a(bigContentTitle, this.e.r(eVar instanceof h ? ((h) eVar).f() : null));
                    } else if (iconCompat.l() == 1) {
                        bigContentTitle = bigContentTitle.bigPicture(this.e.i());
                    }
                }
                if (this.g) {
                    IconCompat iconCompat2 = this.f;
                    if (iconCompat2 != null) {
                        if (i2 >= 23) {
                            if (eVar instanceof h) {
                                context = ((h) eVar).f();
                            }
                            C0020b.a(bigContentTitle, this.f.r(context));
                        } else if (iconCompat2.l() == 1) {
                            a.a(bigContentTitle, this.f.i());
                        }
                    }
                    a.a(bigContentTitle, (Bitmap) null);
                }
                if (this.d) {
                    a.b(bigContentTitle, this.c);
                }
                if (i2 >= 31) {
                    c.c(bigContentTitle, this.i);
                    c.b(bigContentTitle, this.h);
                }
            }
        }

        /* access modifiers changed from: protected */
        @NonNull
        public String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @NonNull
        public b h(Bitmap bitmap) {
            this.f = bitmap == null ? null : IconCompat.e(bitmap);
            this.g = true;
            return this;
        }

        @NonNull
        public b i(Bitmap bitmap) {
            this.e = bitmap == null ? null : IconCompat.e(bitmap);
            return this;
        }

        @NonNull
        public b j(CharSequence charSequence) {
            this.c = e.e(charSequence);
            this.d = true;
            return this;
        }
    }

    public static class c extends h {
        private CharSequence e;

        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.e);
            }
        }

        public void b(com.microsoft.clarity.q1.e eVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(eVar.a()).setBigContentTitle(this.b).bigText(this.e);
                if (this.d) {
                    bigText.setSummaryText(this.c);
                }
            }
        }

        /* access modifiers changed from: protected */
        @NonNull
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @NonNull
        public c h(CharSequence charSequence) {
            this.e = e.e(charSequence);
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static class e {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        d R;
        Notification S;
        boolean T;
        Icon U;
        @Deprecated
        public ArrayList<String> V;
        public Context a;
        public ArrayList<a> b;
        @NonNull
        public ArrayList<j> c;
        ArrayList<a> d;
        CharSequence e;
        CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        Bitmap j;
        CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        h p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        @Deprecated
        public e(@NonNull Context context) {
            this(context, (String) null);
        }

        public e(@NonNull Context context, @NonNull String str) {
            this.b = new ArrayList<>();
            this.c = new ArrayList<>();
            this.d = new ArrayList<>();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private Bitmap f(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(com.microsoft.clarity.p1.b.b);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(com.microsoft.clarity.p1.b.a);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
        }

        private void p(int i2, boolean z2) {
            Notification notification;
            int i3;
            if (z2) {
                notification = this.S;
                i3 = i2 | notification.flags;
            } else {
                notification = this.S;
                i3 = (~i2) & notification.flags;
            }
            notification.flags = i3;
        }

        @NonNull
        public e A(int i2) {
            this.S.icon = i2;
            return this;
        }

        @NonNull
        public e B(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        @NonNull
        public e C(h hVar) {
            if (this.p != hVar) {
                this.p = hVar;
                if (hVar != null) {
                    hVar.g(this);
                }
            }
            return this;
        }

        @NonNull
        public e D(CharSequence charSequence) {
            this.S.tickerText = e(charSequence);
            return this;
        }

        @NonNull
        public e E(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        @NonNull
        public e F(int i2) {
            this.F = i2;
            return this;
        }

        @NonNull
        public e G(long j2) {
            this.S.when = j2;
            return this;
        }

        @NonNull
        public e a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Notification b() {
            return new h(this).c();
        }

        @NonNull
        public e c(@NonNull f fVar) {
            fVar.a(this);
            return this;
        }

        @NonNull
        public Bundle d() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        @NonNull
        public e g(boolean z2) {
            p(16, z2);
            return this;
        }

        @NonNull
        public e h(@NonNull String str) {
            this.K = str;
            return this;
        }

        @NonNull
        public e i(int i2) {
            this.E = i2;
            return this;
        }

        @NonNull
        public e j(RemoteViews remoteViews) {
            this.S.contentView = remoteViews;
            return this;
        }

        @NonNull
        public e k(PendingIntent pendingIntent) {
            this.g = pendingIntent;
            return this;
        }

        @NonNull
        public e l(CharSequence charSequence) {
            this.f = e(charSequence);
            return this;
        }

        @NonNull
        public e m(CharSequence charSequence) {
            this.e = e(charSequence);
            return this;
        }

        @NonNull
        public e n(int i2) {
            Notification notification = this.S;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public e o(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public e q(String str) {
            this.w = str;
            return this;
        }

        @NonNull
        public e r(int i2) {
            this.O = i2;
            return this;
        }

        @NonNull
        public e s(boolean z2) {
            this.x = z2;
            return this;
        }

        @NonNull
        public e t(Bitmap bitmap) {
            this.j = f(bitmap);
            return this;
        }

        @NonNull
        public e u(int i2, int i3, int i4) {
            Notification notification = this.S;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        @NonNull
        public e v(boolean z2) {
            this.z = z2;
            return this;
        }

        @NonNull
        public e w(int i2) {
            this.l = i2;
            return this;
        }

        @NonNull
        public e x(boolean z2) {
            p(8, z2);
            return this;
        }

        @NonNull
        public e y(int i2) {
            this.m = i2;
            return this;
        }

        @NonNull
        public e z(boolean z2) {
            this.n = z2;
            return this;
        }
    }

    public interface f {
        @NonNull
        e a(@NonNull e eVar);
    }

    /* renamed from: androidx.core.app.g$g  reason: collision with other inner class name */
    public static class C0021g extends h {
        private ArrayList<CharSequence> e = new ArrayList<>();

        public void b(com.microsoft.clarity.q1.e eVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(eVar.a()).setBigContentTitle(this.b);
                if (this.d) {
                    bigContentTitle.setSummaryText(this.c);
                }
                Iterator<CharSequence> it = this.e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }

        /* access modifiers changed from: protected */
        @NonNull
        public String c() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @NonNull
        public C0021g h(CharSequence charSequence) {
            if (charSequence != null) {
                this.e.add(e.e(charSequence));
            }
            return this;
        }

        @NonNull
        public C0021g i(CharSequence charSequence) {
            this.b = e.e(charSequence);
            return this;
        }
    }

    public static abstract class h {
        protected e a;
        CharSequence b;
        CharSequence c;
        boolean d = false;

        public void a(@NonNull Bundle bundle) {
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.c);
            }
            CharSequence charSequence = this.b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c2 = c();
            if (c2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c2);
            }
        }

        public abstract void b(com.microsoft.clarity.q1.e eVar);

        /* access modifiers changed from: protected */
        public abstract String c();

        public RemoteViews d(com.microsoft.clarity.q1.e eVar) {
            return null;
        }

        public RemoteViews e(com.microsoft.clarity.q1.e eVar) {
            return null;
        }

        public RemoteViews f(com.microsoft.clarity.q1.e eVar) {
            return null;
        }

        public void g(e eVar) {
            if (this.a != eVar) {
                this.a = eVar;
                if (eVar != null) {
                    eVar.C(this);
                }
            }
        }
    }

    public static Bundle a(@NonNull Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return i.c(notification);
        }
        return null;
    }

    public static boolean b(@NonNull Notification notification) {
        Bundle c2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return (notification.flags & 512) != 0;
        }
        if (i >= 19) {
            c2 = notification.extras;
        } else if (i < 16) {
            return false;
        } else {
            c2 = i.c(notification);
        }
        return c2.getBoolean("android.support.isGroupSummary");
    }
}
