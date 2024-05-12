package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;
import androidx.annotation.NonNull;

public final class a {
    @NonNull
    public static final a e = new a(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: androidx.core.graphics.a$a  reason: collision with other inner class name */
    static class C0029a {
        static Insets a(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    private a(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @NonNull
    public static a a(@NonNull a aVar, @NonNull a aVar2) {
        return b(Math.max(aVar.a, aVar2.a), Math.max(aVar.b, aVar2.b), Math.max(aVar.c, aVar2.c), Math.max(aVar.d, aVar2.d));
    }

    @NonNull
    public static a b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new a(i, i2, i3, i4);
    }

    @NonNull
    public static a c(@NonNull Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NonNull
    public static a d(@NonNull Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    @NonNull
    public Insets e() {
        return C0029a.a(this.a, this.b, this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.d == aVar.d && this.a == aVar.a && this.c == aVar.c && this.b == aVar.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
