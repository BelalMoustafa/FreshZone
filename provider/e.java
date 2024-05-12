package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.util.List;

public final class e {
    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e = 0;
    private final String f;

    public e(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.a = (String) com.microsoft.clarity.z1.e.f(str);
        this.b = (String) com.microsoft.clarity.z1.e.f(str2);
        this.c = (String) com.microsoft.clarity.z1.e.f(str3);
        this.d = (List) com.microsoft.clarity.z1.e.f(list);
        this.f = a(str, str2, str3);
    }

    private String a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String d() {
        return this.f;
    }

    @NonNull
    public String e() {
        return this.a;
    }

    @NonNull
    public String f() {
        return this.b;
    }

    @NonNull
    public String g() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
