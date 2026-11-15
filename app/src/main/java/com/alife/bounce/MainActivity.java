
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.*;
import java.util.Random;

public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(new Bounce(this));
    }
    static class Bounce extends View {
        float x = 100, y = 100, vx = 9, vy = 7, r = 40;
        Random rnd = new Random();
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        Bounce(android.content.Context c) { super(c); }
        @Override protected void onDraw(Canvas cv) {
            cv.drawColor(0xFF101820);
            x += vx; y += vy;
            if (x - r < 0 || x + r > getWidth()) { vx = -vx; x = Math.max(r, Math.min(x, getWidth() - r)); }
            if (y - r < 300 || y + r > getHeight()) { vy = -vy; y = Math.max(r, Math.min(y, getHeight() - r - 200)); }
            p.setColor(Color.rgb(80 + rnd.nextInt(0), 200, 255));
            p.setColor(0xFF4FC3F7);
            cv.drawCircle(x, y, r, p);
            postInvalidateDelayed(16);
        }
    }
}
