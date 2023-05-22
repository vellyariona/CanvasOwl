package com.example.canvasowl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    private ImageView imageView;

    private int frameCount = 0;

    private int colorBlack;
    private int colorWhite;
    private int colorYellow;
    private int colorBiruTua;
    private int colorCoklat;
    private int colorCoklatmuda;
    private int colorCoklattua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // color
        colorBlack = ResourcesCompat.getColor(getResources(),
                R.color.black, null);
        colorWhite = ResourcesCompat.getColor(getResources(),
                R.color.white, null);
        colorYellow = ResourcesCompat.getColor(getResources(),
                R.color.kuning, null);
        colorBiruTua = ResourcesCompat.getColor(getResources(),
                R.color.biruTua, null);

        colorCoklat = ResourcesCompat.getColor(getResources(),
                R.color.coklat, null);

        colorCoklatmuda = ResourcesCompat.getColor(getResources(),
                R.color.coklatmuda, null);

        colorCoklattua = ResourcesCompat.getColor(getResources(),
                R.color.coklattua, null);



        imageView = findViewById(R.id.my_image_view);
        imageView.setOnClickListener(view -> {
            drawSomething(view);
        });
    }

    private void drawSomething(View view) {
        int width = view.getWidth();
        int halfWidth = width/2;

        int height = view.getHeight();
        int halfHeight = height/2;

        // coordinate
        Point faceA = new Point(halfWidth-240, halfHeight-180);
        Point faceB = new Point(halfWidth+240, halfHeight-180);
        Point faceC = new Point(halfWidth, halfHeight+320);

        Point leftFoot = new Point(faceA.x+170, faceA.y+545);
        Point rightFoot = new Point(faceB.x-170, faceB.y+545);

        switch (frameCount) {
            case 0:
                // init mCanvas
                mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                imageView.setImageBitmap(mBitmap);
                mCanvas = new Canvas(mBitmap);


                //badan
                mPaint.setColor(colorCoklat);
                mCanvas.save();
                mCanvas.rotate(90, 200, 200);
                mCanvas.scale(3, 1);
                mCanvas.drawOval(200, -600, 800, 320, mPaint);
                mCanvas.restore();
                break;



            case 1:

//                draw kaki
                mPaint.setColor(colorYellow);
                mCanvas.save();
                mCanvas.drawOval(new RectF(leftFoot.x+120, leftFoot.y+550,
                        leftFoot.x+220, leftFoot.y+800), mPaint);
                mCanvas.drawOval(new RectF(leftFoot.x+200, leftFoot.y+550,
                        leftFoot.x+300, leftFoot.y+800), mPaint);
                mCanvas.drawOval(new RectF(leftFoot.x+280, leftFoot.y+550,
                        leftFoot.x+380, leftFoot.y+800), mPaint);

                mCanvas.restore();

                mCanvas.drawOval(new RectF(leftFoot.x-20, leftFoot.y+550,
                        leftFoot.x-120, leftFoot.y+800), mPaint);
                mCanvas.drawOval(new RectF(leftFoot.x-100, leftFoot.y+550,
                        leftFoot.x-200, leftFoot.y+800), mPaint);
                mCanvas.drawOval(new RectF(leftFoot.x-180, leftFoot.y+550,
                        leftFoot.x-280, leftFoot.y+800), mPaint);

                mCanvas.save();
                mCanvas.restore();

                break;



            case 2:
                // mata
                Point leftEye = new Point(faceA.x+100, faceA.y-80);
                Point rightEye = new Point(faceB.x-100, faceB.y-80);
                mPaint.setColor(colorWhite);
                mCanvas.drawCircle(leftEye.x, leftEye.y, 200, mPaint);
                mCanvas.drawCircle(rightEye.x, rightEye.y, 200, mPaint);

                // bolamata
                mPaint.setColor(colorBlack);
                mCanvas.drawOval(new RectF(leftEye.x-60, leftEye.y-60,
                        leftEye.x+60, leftEye.y+62), mPaint);
                mCanvas.drawOval(new RectF(rightEye.x-60, rightEye.y-60,
                        rightEye.x+60, rightEye.y+62), mPaint);

                mPaint.setColor(colorWhite);

                mCanvas.drawCircle(leftEye.x-2, leftEye.y-10, 30, mPaint);
                mCanvas.drawCircle(rightEye.x+2, rightEye.y-10, 30, mPaint);
                break;
            case 3:
                //perut
                mPaint.setColor(colorCoklatmuda);
                mCanvas.drawCircle(faceC.x, faceC.y+200, 340, mPaint);
                break;
            case 4:
                //paruh
                Path path = new Path();
                path.setFillType(Path.FillType.EVEN_ODD);
                path.lineTo(faceA.x/3+360, faceA.y/4+600);
                path.lineTo(faceB.x/3+360, faceB.y/4+600);
                path.lineTo(faceC.x/3+360, faceC.y/4+730);
                path.lineTo(faceA.x/3+360, faceA.y/4+600);
                path.close();

                mPaint.setColor(colorYellow);
                mCanvas.drawPath(path, mPaint);
                break;
            case 5:
                //sayap
                mPaint.setColor(colorCoklattua);
                mCanvas.save();
                mCanvas.drawOval(new RectF(leftFoot.x-500, leftFoot.y-500,
                        leftFoot.x, leftFoot.y+560), mPaint);
                mCanvas.restore();

                mCanvas.save();
                mCanvas.drawOval(new RectF(rightFoot.x, rightFoot.y-500,
                        rightFoot.x+500, rightFoot.y+560), mPaint);
                mCanvas.restore();
                break;
            case 6:
                String text = "KUK.. KUK...";

                TextPaint textPaint = new TextPaint();
                textPaint.setAntiAlias(true);
                textPaint.setTextSize(50 * getResources().getDisplayMetrics().density);
                textPaint.setColor(colorWhite);

                int widthz = (int) textPaint.measureText(text);
                StaticLayout staticLayout = new StaticLayout(text, textPaint, (int) widthz, Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
                staticLayout.draw(mCanvas);
                break;

            case 7:
                getWindow().getDecorView().setBackgroundColor(colorBiruTua);
                break;
            default:
                break;
        }

        frameCount++;
        view.invalidate();
    }
}