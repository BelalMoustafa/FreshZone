package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.microsoft.clarity.d2.g;

public class c {

    static class a {
        static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    public static ColorStateList a(@NonNull ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.a(imageView);
        }
        if (imageView instanceof g) {
            return ((g) imageView).getSupportImageTintList();
        }
        return null;
    }

    public static PorterDuff.Mode b(@NonNull ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.b(imageView);
        }
        if (imageView instanceof g) {
            return ((g) imageView).getSupportImageTintMode();
        }
        return null;
    }

    public static void c(@NonNull ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            a.c(imageView, colorStateList);
            if (i == 21 && (drawable = imageView.getDrawable()) != null && a.a(imageView) != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView instanceof g) {
            ((g) imageView).setSupportImageTintList(colorStateList);
        }
    }

    public static void d(@NonNull ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            a.d(imageView, mode);
            if (i == 21 && (drawable = imageView.getDrawable()) != null && a.a(imageView) != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView instanceof g) {
            ((g) imageView).setSupportImageTintMode(mode);
        }
    }
}
