package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ View h;

    public /* synthetic */ n(View view) {
        this.h = view;
    }

    public final void run() {
        ((InputMethodManager) this.h.getContext().getSystemService("input_method")).showSoftInput(this.h, 0);
    }
}
