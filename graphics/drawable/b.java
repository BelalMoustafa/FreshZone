package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.microsoft.clarity.u1.a;

class b extends Drawable implements Drawable.Callback, com.microsoft.clarity.u1.b, a {
    static final PorterDuff.Mode n = PorterDuff.Mode.SRC_IN;
    private int h;
    private PorterDuff.Mode i;
    private boolean j;
    d k;
    private boolean l;
    Drawable m;

    b(Drawable drawable) {
        this.k = d();
        a(drawable);
    }

    b(@NonNull d dVar, Resources resources) {
        this.k = dVar;
        e(resources);
    }

    @NonNull
    private d d() {
        return new d(this.k);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        d dVar = this.k;
        if (dVar != null && (constantState = dVar.b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        d dVar = this.k;
        ColorStateList colorStateList = dVar.c;
        PorterDuff.Mode mode = dVar.d;
        if (colorStateList == null || mode == null) {
            this.j = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.j && colorForState == this.h && mode == this.i)) {
                setColorFilter(colorForState, mode);
                this.h = colorForState;
                this.i = mode;
                this.j = true;
                return true;
            }
        }
        return false;
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.m;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.m = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            d dVar = this.k;
            if (dVar != null) {
                dVar.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final Drawable b() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void draw(@NonNull Canvas canvas) {
        this.m.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        d dVar = this.k;
        return changingConfigurations | (dVar != null ? dVar.getChangingConfigurations() : 0) | this.m.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        d dVar = this.k;
        if (dVar == null || !dVar.a()) {
            return null;
        }
        this.k.a = getChangingConfigurations();
        return this.k;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.m.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.m.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.m.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return a.f(this.m);
    }

    public int getMinimumHeight() {
        return this.m.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.m.getMinimumWidth();
    }

    public int getOpacity() {
        return this.m.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.m.getPadding(rect);
    }

    @NonNull
    public int[] getState() {
        return this.m.getState();
    }

    public Region getTransparentRegion() {
        return this.m.getTransparentRegion();
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.h(this.m);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.d r0 = r1.k
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.m
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.b.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.m.jumpToCurrentState();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.l && super.mutate() == this) {
            this.k = d();
            Drawable drawable = this.m;
            if (drawable != null) {
                drawable.mutate();
            }
            d dVar = this.k;
            if (dVar != null) {
                Drawable drawable2 = this.m;
                dVar.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.l = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return a.m(this.m, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.m.setLevel(i2);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.m.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        a.j(this.m, z);
    }

    public void setChangingConfigurations(int i2) {
        this.m.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.m.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.m.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.m.setFilterBitmap(z);
    }

    public boolean setState(@NonNull int[] iArr) {
        return f(iArr) || this.m.setState(iArr);
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.k.c = colorStateList;
        f(getState());
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.k.d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.m.setVisible(z, z2);
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
