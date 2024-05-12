package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.HashSet;

public class a extends androidx.core.content.b {
    private static e a;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    class C0018a implements Runnable {
        final /* synthetic */ String[] h;
        final /* synthetic */ Activity i;
        final /* synthetic */ int j;

        C0018a(String[] strArr, Activity activity, int i2) {
            this.h = strArr;
            this.i = activity;
            this.j = i2;
        }

        public void run() {
            int[] iArr = new int[this.h.length];
            PackageManager packageManager = this.i.getPackageManager();
            String packageName = this.i.getPackageName();
            int length = this.h.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.h[i2], packageName);
            }
            ((d) this.i).onRequestPermissionsResult(this.j, this.h, iArr);
        }
    }

    static class b {
        static void a(Activity activity) {
            activity.finishAffinity();
        }

        static void b(Activity activity, Intent intent, int i, Bundle bundle) {
            activity.startActivityForResult(intent, i, bundle);
        }

        static void c(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    static class c {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface d {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public interface e {
        boolean a(@NonNull Activity activity, @NonNull String[] strArr, int i);
    }

    public interface f {
        void a(int i);
    }

    public static void b(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.a(activity);
        } else {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(Activity activity) {
        if (!activity.isFinishing() && !b.i(activity)) {
            activity.recreate();
        }
    }

    public static void d(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new com.microsoft.clarity.q1.a(activity));
        }
    }

    public static void e(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        e eVar = a;
        if (eVar == null || !eVar.a(activity, strArr, i)) {
            HashSet hashSet = new HashSet();
            int i2 = 0;
            while (i2 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i2])) {
                    if (!com.microsoft.clarity.x1.a.c() && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i2));
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[(strArr.length - size)] : strArr;
            if (size > 0) {
                if (size != strArr.length) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < strArr.length; i4++) {
                        if (!hashSet.contains(Integer.valueOf(i4))) {
                            strArr2[i3] = strArr[i4];
                            i3++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof f) {
                    ((f) activity).a(i);
                }
                c.b(activity, strArr, i);
            } else if (activity instanceof d) {
                new Handler(Looper.getMainLooper()).post(new C0018a(strArr2, activity, i));
            }
        }
    }

    public static boolean f(@NonNull Activity activity, @NonNull String str) {
        if ((com.microsoft.clarity.x1.a.c() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) && Build.VERSION.SDK_INT >= 23) {
            return c.c(activity, str);
        }
        return false;
    }

    public static void g(@NonNull Activity activity, @NonNull Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.b(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void h(@NonNull Activity activity, @NonNull IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.c(activity, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }
}
