package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.microsoft.clarity.z1.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
    public int a = -1;
    Object b;
    public byte[] c = null;
    public Parcelable d = null;
    public int e = 0;
    public int f = 0;
    public ColorStateList g = null;
    PorterDuff.Mode h = k;
    public String i = null;
    public String j;

    static class a {
        static IconCompat a(@NonNull Object obj) {
            e.f(obj);
            int d = d(obj);
            if (d == 2) {
                return IconCompat.h((Resources) null, c(obj), b(obj));
            }
            if (d == 4) {
                return IconCompat.f(e(obj));
            }
            if (d == 6) {
                return IconCompat.c(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.b = obj;
            return iconCompat;
        }

        static int b(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e) {
                Log.e("IconCompat", "Unable to get icon resource", e);
                return 0;
            } catch (InvocationTargetException e2) {
                Log.e("IconCompat", "Unable to get icon resource", e2);
                return 0;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            }
        }

        static String c(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.e("IconCompat", "Unable to get icon package", e);
                return null;
            } catch (InvocationTargetException e2) {
                Log.e("IconCompat", "Unable to get icon package", e2);
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon package", e3);
                return null;
            }
        }

        static int d(@NonNull Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (InvocationTargetException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e3) {
                e = e3;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            }
        }

        static Uri e(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.e("IconCompat", "Unable to get icon uri", e);
                return null;
            } catch (InvocationTargetException e2) {
                Log.e("IconCompat", "Unable to get icon uri", e2);
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (r0 >= 26) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
            r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
            r5 = androidx.core.graphics.drawable.IconCompat.b(r5, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
            r5 = android.graphics.drawable.Icon.createWithBitmap(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
            r0 = r4.g;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
            if (r0 == null) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
            r5.setTintList(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
            r4 = r4.h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00af, code lost:
            if (r4 == androidx.core.graphics.drawable.IconCompat.k) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
            r5.setTintMode(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
            return r5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static android.graphics.drawable.Icon g(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                int r0 = r4.a
                r1 = 0
                r2 = 26
                switch(r0) {
                    case -1: goto L_0x00b5;
                    case 0: goto L_0x0008;
                    case 1: goto L_0x009c;
                    case 2: goto L_0x0091;
                    case 3: goto L_0x0084;
                    case 4: goto L_0x007b;
                    case 5: goto L_0x0065;
                    case 6: goto L_0x0010;
                    default: goto L_0x0008;
                }
            L_0x0008:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Unknown type"
                r4.<init>(r5)
                throw r4
            L_0x0010:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r0 < r3) goto L_0x0020
                android.net.Uri r5 = r4.m()
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.d.a(r5)
                goto L_0x00a4
            L_0x0020:
                if (r5 == 0) goto L_0x004a
                java.io.InputStream r5 = r4.n(r5)
                if (r5 == 0) goto L_0x002f
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
                if (r0 < r2) goto L_0x0076
                goto L_0x006d
            L_0x002f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L_0x004a:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L_0x0065:
                int r5 = android.os.Build.VERSION.SDK_INT
                if (r5 < r2) goto L_0x0072
                java.lang.Object r5 = r4.b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L_0x006d:
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5)
                goto L_0x00a4
            L_0x0072:
                java.lang.Object r5 = r4.b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L_0x0076:
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.b(r5, r1)
                goto L_0x00a0
            L_0x007b:
                java.lang.Object r5 = r4.b
                java.lang.String r5 = (java.lang.String) r5
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
                goto L_0x00a4
            L_0x0084:
                java.lang.Object r5 = r4.b
                byte[] r5 = (byte[]) r5
                int r0 = r4.e
                int r1 = r4.f
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
                goto L_0x00a4
            L_0x0091:
                java.lang.String r5 = r4.k()
                int r0 = r4.e
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
                goto L_0x00a4
            L_0x009c:
                java.lang.Object r5 = r4.b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L_0x00a0:
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
            L_0x00a4:
                android.content.res.ColorStateList r0 = r4.g
                if (r0 == 0) goto L_0x00ab
                r5.setTintList(r0)
            L_0x00ab:
                android.graphics.PorterDuff$Mode r4 = r4.h
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.k
                if (r4 == r0) goto L_0x00b4
                r5.setTintMode(r4)
            L_0x00b4:
                return r5
            L_0x00b5:
                java.lang.Object r4 = r4.b
                android.graphics.drawable.Icon r4 = (android.graphics.drawable.Icon) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.g(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
    }

    IconCompat(int i2) {
        this.a = i2;
    }

    public static IconCompat a(@NonNull Icon icon) {
        return a.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    @NonNull
    public static IconCompat c(@NonNull Uri uri) {
        androidx.core.util.a.c(uri);
        return d(uri.toString());
    }

    @NonNull
    public static IconCompat d(@NonNull String str) {
        androidx.core.util.a.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat e(@NonNull Bitmap bitmap) {
        androidx.core.util.a.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.b = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat f(@NonNull Uri uri) {
        androidx.core.util.a.c(uri);
        return g(uri.toString());
    }

    @NonNull
    public static IconCompat g(@NonNull String str) {
        androidx.core.util.a.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat h(Resources resources, @NonNull String str, int i2) {
        androidx.core.util.a.c(str);
        if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.e = i2;
            if (resources != null) {
                try {
                    iconCompat.b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.b = str;
            }
            iconCompat.j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    private static String s(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap i() {
        int i2 = this.a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i2 == 1) {
            return (Bitmap) this.b;
        } else {
            if (i2 == 5) {
                return b((Bitmap) this.b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int j() {
        int i2 = this.a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.b);
        }
        if (i2 == 2) {
            return this.e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String k() {
        int i2 = this.a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.b);
        }
        if (i2 == 2) {
            String str = this.j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.b).split(":", -1)[0] : this.j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int l() {
        int i2 = this.a;
        return (i2 != -1 || Build.VERSION.SDK_INT < 23) ? i2 : a.d(this.b);
    }

    @NonNull
    public Uri m() {
        int i2 = this.a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.e(this.b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream n(@NonNull Context context) {
        String str;
        StringBuilder sb;
        Uri m = m();
        String scheme = m.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(m);
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
                sb.append(str);
                sb.append(m);
                Log.w("IconCompat", sb.toString(), e);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.b));
            } catch (FileNotFoundException e3) {
                e = e3;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
                sb.append(str);
                sb.append(m);
                Log.w("IconCompat", sb.toString(), e);
                return null;
            }
        }
    }

    public void o() {
        Parcelable parcelable;
        this.h = PorterDuff.Mode.valueOf(this.i);
        switch (this.a) {
            case -1:
                parcelable = this.d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 1:
            case 5:
                parcelable = this.d;
                if (parcelable == null) {
                    byte[] bArr = this.c;
                    this.b = bArr;
                    this.a = 3;
                    this.e = 0;
                    this.f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.c, Charset.forName("UTF-16"));
                this.b = str;
                if (this.a == 2 && this.j == null) {
                    this.j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.b = this.c;
                return;
            default:
                return;
        }
        this.b = parcelable;
    }

    public void p(boolean z) {
        this.i = this.h.name();
        switch (this.a) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 1:
            case 5:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.c = ((String) this.b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.c = (byte[]) this.b;
                return;
            case 4:
            case 6:
                this.c = this.b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
        this.d = (Parcelable) this.b;
    }

    @NonNull
    @Deprecated
    public Icon q() {
        return r((Context) null);
    }

    @NonNull
    public Icon r(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.a
            java.lang.String r1 = s(r1)
            r0.append(r1)
            int r1 = r4.a
            switch(r1) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0043;
                case 3: goto L_0x002d;
                case 4: goto L_0x0022;
                case 5: goto L_0x006a;
                case 6: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x008a
        L_0x0022:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.b
            r0.append(r1)
            goto L_0x008a
        L_0x002d:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.e
            r0.append(r1)
            int r1 = r4.f
            if (r1 == 0) goto L_0x008a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f
            goto L_0x0087
        L_0x0043:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.j
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.j()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L_0x008a
        L_0x006a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L_0x0087:
            r0.append(r1)
        L_0x008a:
            android.content.res.ColorStateList r1 = r4.g
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.g
            r0.append(r1)
        L_0x0098:
            android.graphics.PorterDuff$Mode r1 = r4.h
            android.graphics.PorterDuff$Mode r2 = k
            if (r1 == r2) goto L_0x00a8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.h
            r0.append(r1)
        L_0x00a8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
