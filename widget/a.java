package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import com.microsoft.clarity.d2.e;
import java.lang.reflect.Field;

public final class a {
    private static Field a;
    private static boolean b;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    static class C0042a {
        static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class b {
        static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    public static Drawable a(@NonNull CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(compoundButton);
        }
        if (!b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            b = true;
        }
        Field field = a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                a = null;
            }
        }
        return null;
    }

    public static ColorStateList b(@NonNull CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0042a.a(compoundButton);
        }
        if (compoundButton instanceof e) {
            return ((e) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    public static void c(@NonNull CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0042a.c(compoundButton, colorStateList);
        } else if (compoundButton instanceof e) {
            ((e) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static void d(@NonNull CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0042a.d(compoundButton, mode);
        } else if (compoundButton instanceof e) {
            ((e) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
