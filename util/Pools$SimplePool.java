package androidx.core.util;

import androidx.annotation.NonNull;
import com.microsoft.clarity.z1.c;

public class Pools$SimplePool<T> implements c<T> {
    private final Object[] a;
    private int b;

    public Pools$SimplePool(int i) {
        if (i > 0) {
            this.a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(@NonNull T t) {
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == t) {
                return true;
            }
        }
        return false;
    }

    public boolean a(@NonNull T t) {
        if (!c(t)) {
            int i = this.b;
            Object[] objArr = this.a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    public T b() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        T[] tArr = this.a;
        T t = tArr[i2];
        tArr[i2] = null;
        this.b = i - 1;
        return t;
    }
}
