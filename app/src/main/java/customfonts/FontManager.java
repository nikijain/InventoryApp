package customfonts;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
@SuppressLint("AppCompatCustomView")
public class FontManager extends TextView {


    public FontManager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontManager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontManager(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/fontawesome-webfont.ttf");
            setTypeface(tf);
        }
    }

}
