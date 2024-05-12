package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class h {

    private static class a implements ThreadFactory {
        private String a;
        private int b;

        /* renamed from: androidx.core.provider.h$a$a  reason: collision with other inner class name */
        private static class C0034a extends Thread {
            private final int h;

            C0034a(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.h = i;
            }

            public void run() {
                Process.setThreadPriority(this.h);
                super.run();
            }
        }

        a(@NonNull String str, int i) {
            this.a = str;
            this.b = i;
        }

        public Thread newThread(Runnable runnable) {
            return new C0034a(runnable, this.a, this.b);
        }
    }

    private static class b<T> implements Runnable {
        @NonNull
        private Callable<T> h;
        @NonNull
        private com.microsoft.clarity.z1.a<T> i;
        @NonNull
        private Handler j;

        class a implements Runnable {
            final /* synthetic */ com.microsoft.clarity.z1.a h;
            final /* synthetic */ Object i;

            a(b bVar, com.microsoft.clarity.z1.a aVar, Object obj) {
                this.h = aVar;
                this.i = obj;
            }

            public void run() {
                this.h.accept(this.i);
            }
        }

        b(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull com.microsoft.clarity.z1.a<T> aVar) {
            this.h = callable;
            this.i = aVar;
            this.j = handler;
        }

        public void run() {
            T t;
            try {
                t = this.h.call();
            } catch (Exception unused) {
                t = null;
            }
            this.j.post(new a(this, this.i, t));
        }
    }

    static ThreadPoolExecutor a(@NonNull String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull com.microsoft.clarity.z1.a<T> aVar) {
        executor.execute(new b(b.a(), callable, aVar));
    }

    static <T> T c(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, int i) {
        try {
            return executorService.submit(callable).get((long) i, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
