package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.collection.g;

public final class o {
    private final e a;

    private static class a extends e {
        @NonNull
        protected final Window a;
        @NonNull
        private final View b;

        a(@NonNull Window window, @NonNull View view) {
            this.a = window;
            this.b = view;
        }

        private void g(int i) {
            if (i == 1) {
                i(4);
            } else if (i == 2) {
                i(2);
            } else if (i == 8) {
                ((InputMethodManager) this.a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getDecorView().getWindowToken(), 0);
            }
        }

        private void k(int i) {
            if (i == 1) {
                l(4);
                m(1024);
            } else if (i == 2) {
                l(2);
            } else if (i == 8) {
                View view = this.b;
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = this.a.getCurrentFocus();
                }
                if (view == null) {
                    view = this.a.findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new n(view));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    g(i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
            if (i == 0) {
                l(6144);
            } else if (i == 1) {
                l(4096);
                i(2048);
            } else if (i == 2) {
                l(2048);
                i(4096);
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    k(i2);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void i(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void j(int i) {
            this.a.addFlags(i);
        }

        /* access modifiers changed from: protected */
        public void l(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void m(int i) {
            this.a.clearFlags(i);
        }
    }

    private static class b extends a {
        b(@NonNull Window window, View view) {
            super(window, view);
        }

        public void c(boolean z) {
            if (z) {
                m(67108864);
                j(Integer.MIN_VALUE);
                i(8192);
                return;
            }
            l(8192);
        }
    }

    private static class c extends b {
        c(@NonNull Window window, View view) {
            super(window, view);
        }

        public void b(boolean z) {
            if (z) {
                m(134217728);
                j(Integer.MIN_VALUE);
                i(16);
                return;
            }
            l(16);
        }
    }

    private static class d extends e {
        final WindowInsetsController a;
        protected Window b;

        d(@NonNull Window window, @NonNull o oVar) {
            this(window.getInsetsController(), oVar);
            this.b = window;
        }

        d(@NonNull WindowInsetsController windowInsetsController, @NonNull o oVar) {
            new g();
            this.a = windowInsetsController;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.a.hide(i);
        }

        public void b(boolean z) {
            if (z) {
                if (this.b != null) {
                    f(16);
                }
                this.a.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.b != null) {
                g(16);
            }
            this.a.setSystemBarsAppearance(0, 16);
        }

        public void c(boolean z) {
            if (z) {
                if (this.b != null) {
                    f(8192);
                }
                this.a.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.b != null) {
                g(8192);
            }
            this.a.setSystemBarsAppearance(0, 8);
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
            this.a.setSystemBarsBehavior(i);
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
            Window window = this.b;
            if (!(window == null || (i & 8) == 0 || Build.VERSION.SDK_INT >= 32)) {
                ((InputMethodManager) window.getContext().getSystemService("input_method")).isActive();
            }
            this.a.show(i);
        }

        /* access modifiers changed from: protected */
        public void f(int i) {
            View decorView = this.b.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void g(int i) {
            View decorView = this.b.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }
    }

    private static class e {
        e() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
        }

        public void b(boolean z) {
        }

        public void c(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
        }
    }

    public o(@NonNull Window window, @NonNull View view) {
        e aVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.a = new d(window, this);
            return;
        }
        if (i >= 26) {
            aVar = new c(window, view);
        } else if (i >= 23) {
            aVar = new b(window, view);
        } else if (i >= 20) {
            aVar = new a(window, view);
        } else {
            this.a = new e();
            return;
        }
        this.a = aVar;
    }

    public void a(int i) {
        this.a.a(i);
    }

    public void b(boolean z) {
        this.a.b(z);
    }

    public void c(boolean z) {
        this.a.c(z);
    }

    public void d(int i) {
        this.a.d(i);
    }

    public void e(int i) {
        this.a.e(i);
    }
}
