package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import com.microsoft.clarity.b2.b;
import com.microsoft.clarity.b2.c;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class a {
    private static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate a;
    private final View.AccessibilityDelegate b;

    /* renamed from: androidx.core.view.a$a  reason: collision with other inner class name */
    static final class C0037a extends View.AccessibilityDelegate {
        final a a;

        C0037a(a aVar) {
            this.a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            c b = this.a.b(view);
            if (b != null) {
                return (AccessibilityNodeProvider) b.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            com.microsoft.clarity.b2.b G0 = com.microsoft.clarity.b2.b.G0(accessibilityNodeInfo);
            G0.u0(g.a0(view));
            G0.k0(g.V(view));
            G0.p0(g.r(view));
            G0.A0(g.M(view));
            this.a.g(view, G0);
            G0.f(accessibilityNodeInfo.getText(), view);
            List<b.a> c = a.c(view);
            for (int i = 0; i < c.size(); i++) {
                G0.b(c.get(i));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.j(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.a.l(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.m(view, accessibilityEvent);
        }
    }

    static class b {
        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    public a() {
        this(c);
    }

    public a(@NonNull View.AccessibilityDelegate accessibilityDelegate) {
        this.a = accessibilityDelegate;
        this.b = new C0037a(this);
    }

    static List<b.a> c(View view) {
        List<b.a> list = (List) view.getTag(com.microsoft.clarity.p1.c.H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] q = com.microsoft.clarity.b2.b.q(view.createAccessibilityNodeInfo().getText());
            int i = 0;
            while (q != null && i < q.length) {
                if (clickableSpan.equals(q[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private boolean k(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(com.microsoft.clarity.p1.c.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public c b(@NonNull View view) {
        AccessibilityNodeProvider a2;
        if (Build.VERSION.SDK_INT < 16 || (a2 = b.a(this.a, view)) == null) {
            return null;
        }
        return new c(a2);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.b;
    }

    public void f(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(@NonNull View view, @NonNull com.microsoft.clarity.b2.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.F0());
    }

    public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(@NonNull View view, int i, Bundle bundle) {
        List<b.a> c2 = c(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= c2.size()) {
                break;
            }
            b.a aVar = c2.get(i2);
            if (aVar.b() == i) {
                z = aVar.d(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = b.b(this.a, view, i, bundle);
        }
        return (z || i != com.microsoft.clarity.p1.c.a || bundle == null) ? z : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(@NonNull View view, int i) {
        this.a.sendAccessibilityEvent(view, i);
    }

    public void m(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
