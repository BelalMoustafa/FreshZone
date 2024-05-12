package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;

final class d extends Drawable.ConstantState {
    int a;
    Drawable.ConstantState b;
    ColorStateList c = null;
    PorterDuff.Mode d = b.n;

    d(d dVar) {
        if (dVar != null) {
            this.a = dVar.a;
            this.b = dVar.b;
            this.c = dVar.c;
            this.d = dVar.d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.b != null;
    }

    public int getChangingConfigurations() {
        int i = this.a;
        Drawable.ConstantState constantState = this.b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @NonNull
    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    @NonNull
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new c(this, resources) : new b(this, resources);
    }
}
