package androidx.core.app;

import android.app.Person;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;

public class j {
    CharSequence a;
    IconCompat b;
    String c;
    String d;
    boolean e;
    boolean f;

    static class a {
        static j a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.a(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(j jVar) {
            return new Person.Builder().setName(jVar.c()).setIcon(jVar.a() != null ? jVar.a().q() : null).setUri(jVar.d()).setKey(jVar.b()).setBot(jVar.e()).setImportant(jVar.f()).build();
        }
    }

    public static class b {
        CharSequence a;
        IconCompat b;
        String c;
        String d;
        boolean e;
        boolean f;

        @NonNull
        public j a() {
            return new j(this);
        }

        @NonNull
        public b b(boolean z) {
            this.e = z;
            return this;
        }

        @NonNull
        public b c(IconCompat iconCompat) {
            this.b = iconCompat;
            return this;
        }

        @NonNull
        public b d(boolean z) {
            this.f = z;
            return this;
        }

        @NonNull
        public b e(String str) {
            this.d = str;
            return this;
        }

        @NonNull
        public b f(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        @NonNull
        public b g(String str) {
            this.c = str;
            return this;
        }
    }

    j(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
    }

    public IconCompat a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public CharSequence c() {
        return this.a;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    @NonNull
    public String g() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        if (this.a == null) {
            return "";
        }
        return "name:" + this.a;
    }

    @NonNull
    public Person h() {
        return a.b(this);
    }
}
