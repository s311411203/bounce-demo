
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.*;

public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle b) { super.onCreate(b); setContentView(new V(this)); }
    static class V extends View {
        float x = 300, y = 300, vx = 11, vy = 9, r = 50;
        V(android.content.Context c) { super(c); }
        @Override protected void onDraw(Canvas cv) {
            cv.drawColor(0xFF101820);
            x += vx; y += vy;
            if (x - r < 0 || x + r > getWidth())  { vx = -vx; x = Math.max(r, Math.min(x, getWidth() - r)); }
            if (y - r < 0 || y + r > getHeight()) { vy = -vy; y = Math.max(r, Math.min(y, getHeight() - r)); }
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setColor(0xFF4FC3F7); cv.drawCircle(x, y, r, p);
            postInvalidateDelayed(16);
        }
    }
}
