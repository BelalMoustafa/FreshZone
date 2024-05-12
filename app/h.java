package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.b;
import androidx.core.app.g;
import androidx.core.graphics.drawable.IconCompat;
import com.microsoft.clarity.q1.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class h implements e {
    private final Context a;
    private final Notification.Builder b;
    private final g.e c;
    private RemoteViews d;
    private RemoteViews e;
    private final List<Bundle> f = new ArrayList();
    private final Bundle g = new Bundle();
    private int h;
    private RemoteViews i;

    h(g.e eVar) {
        Notification.Builder builder;
        int i2;
        Icon icon;
        List<String> e2;
        String str;
        Bundle bundle;
        this.c = eVar;
        this.a = eVar.a;
        int i3 = Build.VERSION.SDK_INT;
        Context context = eVar.a;
        if (i3 >= 26) {
            String str2 = eVar.K;
        } else {
            builder = new Notification.Builder(context);
        }
        this.b = builder;
        Notification notification = eVar.S;
        this.b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.e).setContentText(eVar.f).setContentInfo(eVar.k).setContentIntent(eVar.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.h, (notification.flags & 128) != 0).setLargeIcon(eVar.j).setNumber(eVar.l).setProgress(eVar.t, eVar.u, eVar.v);
        if (i3 < 21) {
            this.b.setSound(notification.sound, notification.audioStreamType);
        }
        if (i3 >= 16) {
            this.b.setSubText(eVar.q).setUsesChronometer(eVar.o).setPriority(eVar.m);
            Iterator<g.a> it = eVar.b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle2 = eVar.D;
            if (bundle2 != null) {
                this.g.putAll(bundle2);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.z) {
                    this.g.putBoolean("android.support.localOnly", true);
                }
                String str3 = eVar.w;
                if (str3 != null) {
                    this.g.putString("android.support.groupKey", str3);
                    if (eVar.x) {
                        bundle = this.g;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.g;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                String str4 = eVar.y;
                if (str4 != null) {
                    this.g.putString("android.support.sortKey", str4);
                }
            }
            this.d = eVar.H;
            this.e = eVar.I;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 17) {
            this.b.setShowWhen(eVar.n);
        }
        if (i4 >= 19 && i4 < 21 && (e2 = e(g(eVar.c), eVar.V)) != null && !e2.isEmpty()) {
            this.g.putStringArray("android.people", (String[]) e2.toArray(new String[e2.size()]));
        }
        if (i4 >= 20) {
            this.b.setLocalOnly(eVar.z).setGroup(eVar.w).setGroupSummary(eVar.x).setSortKey(eVar.y);
            this.h = eVar.O;
        }
        if (i4 >= 21) {
            this.b.setCategory(eVar.C).setColor(eVar.E).setVisibility(eVar.F).setPublicVersion(eVar.G).setSound(notification.sound, notification.audioAttributes);
            List<String> e3 = i4 < 28 ? e(g(eVar.c), eVar.V) : eVar.V;
            if (e3 != null && !e3.isEmpty()) {
                for (String addPerson : e3) {
                    this.b.addPerson(addPerson);
                }
            }
            this.i = eVar.J;
            if (eVar.d.size() > 0) {
                Bundle bundle3 = eVar.d().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle(bundle3);
                Bundle bundle5 = new Bundle();
                for (int i5 = 0; i5 < eVar.d.size(); i5++) {
                    bundle5.putBundle(Integer.toString(i5), i.b(eVar.d.get(i5)));
                }
                bundle3.putBundle("invisible_actions", bundle5);
                bundle4.putBundle("invisible_actions", bundle5);
                eVar.d().putBundle("android.car.EXTENSIONS", bundle3);
                this.g.putBundle("android.car.EXTENSIONS", bundle4);
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23 && (icon = eVar.U) != null) {
            this.b.setSmallIcon(icon);
        }
        if (i6 >= 24) {
            this.b.setExtras(eVar.D).setRemoteInputHistory(eVar.s);
            RemoteViews remoteViews = eVar.H;
            if (remoteViews != null) {
                this.b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.I;
            if (remoteViews2 != null) {
                this.b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.J;
            if (remoteViews3 != null) {
                this.b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i6 >= 26) {
            this.b.setBadgeIconType(eVar.L).setSettingsText(eVar.r).setShortcutId(eVar.M).setTimeoutAfter(eVar.N).setGroupAlertBehavior(eVar.O);
            if (eVar.B) {
                this.b.setColorized(eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i6 >= 28) {
            Iterator<j> it2 = eVar.c.iterator();
            while (it2.hasNext()) {
                this.b.addPerson(it2.next().h());
            }
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            this.b.setAllowSystemGeneratedContextualActions(eVar.Q);
            this.b.setBubbleMetadata(g.d.a(eVar.R));
        }
        if (i7 >= 31 && (i2 = eVar.P) != 0) {
            this.b.setForegroundServiceBehavior(i2);
        }
        if (eVar.T) {
            if (this.c.x) {
                this.h = 2;
            } else {
                this.h = 1;
            }
            this.b.setVibrate((long[]) null);
            this.b.setSound((Uri) null);
            int i8 = notification.defaults & -2;
            notification.defaults = i8;
            int i9 = i8 & -3;
            notification.defaults = i9;
            this.b.setDefaults(i9);
            if (i7 >= 26) {
                if (TextUtils.isEmpty(this.c.w)) {
                    this.b.setGroup("silent");
                }
                this.b.setGroupAlertBehavior(this.h);
            }
        }
    }

    private void b(g.a aVar) {
        Notification.Action.Builder builder;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            IconCompat e2 = aVar.e();
            if (i2 >= 23) {
                builder = new Notification.Action.Builder(e2 != null ? e2.q() : null, aVar.i(), aVar.a());
            } else {
                builder = new Notification.Action.Builder(e2 != null ? e2.j() : 0, aVar.i(), aVar.a());
            }
            if (aVar.f() != null) {
                for (RemoteInput addRemoteInput : k.b(aVar.f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (i3 >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (i3 >= 29) {
                builder.setContextual(aVar.k());
            }
            if (i3 >= 31) {
                builder.setAuthenticationRequired(aVar.j());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
            builder.addExtras(bundle);
            this.b.addAction(builder.build());
        } else if (i2 >= 16) {
            this.f.add(i.f(this.b, aVar));
        }
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> g(List<j> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (j g2 : list) {
            arrayList.add(g2.g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i2 = notification.defaults & -2;
        notification.defaults = i2;
        notification.defaults = i2 & -3;
    }

    public Notification.Builder a() {
        return this.b;
    }

    public Notification c() {
        Bundle a2;
        RemoteViews f2;
        RemoteViews d2;
        g.h hVar = this.c.p;
        if (hVar != null) {
            hVar.b(this);
        }
        RemoteViews e2 = hVar != null ? hVar.e(this) : null;
        Notification d3 = d();
        if (!(e2 == null && (e2 = this.c.H) == null)) {
            d3.contentView = e2;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (!(i2 < 16 || hVar == null || (d2 = hVar.d(this)) == null)) {
            d3.bigContentView = d2;
        }
        if (!(i2 < 21 || hVar == null || (f2 = this.c.p.f(this)) == null)) {
            d3.headsUpContentView = f2;
        }
        if (!(i2 < 16 || hVar == null || (a2 = g.a(d3)) == null)) {
            hVar.a(a2);
        }
        return d3;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.b.build();
        }
        if (i2 >= 24) {
            Notification build = this.b.build();
            if (this.h != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.h != 2)) {
                    h(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.h == 1) {
                    h(build);
                }
            }
            return build;
        } else if (i2 >= 21) {
            this.b.setExtras(this.g);
            Notification build2 = this.b.build();
            RemoteViews remoteViews = this.d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.h != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.h != 2)) {
                    h(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.h == 1) {
                    h(build2);
                }
            }
            return build2;
        } else if (i2 >= 20) {
            this.b.setExtras(this.g);
            Notification build3 = this.b.build();
            RemoteViews remoteViews4 = this.d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.h != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.h != 2)) {
                    h(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.h == 1) {
                    h(build3);
                }
            }
            return build3;
        } else if (i2 >= 19) {
            SparseArray<Bundle> a2 = i.a(this.f);
            if (a2 != null) {
                this.g.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.b.setExtras(this.g);
            Notification build4 = this.b.build();
            RemoteViews remoteViews6 = this.d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i2 < 16) {
            return this.b.getNotification();
        } else {
            Notification build5 = this.b.build();
            Bundle a3 = g.a(build5);
            Bundle bundle = new Bundle(this.g);
            for (String str : this.g.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = i.a(this.f);
            if (a4 != null) {
                g.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.d;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.e;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.a;
    }
}
