package pdfviewer;

import android.graphics.Canvas;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.jyc.appfuncdemo.R;

/**
 * Created by jiangyongchao on 3/21.
 * 使用帮助可查看本包下的README文档
 */

public class PdfViewer extends AppCompatActivity implements OnPageChangeListener
        , OnLoadCompleteListener  , OnDrawListener{

    private PDFView pdfView ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();  //去掉标题栏
        setContentView(R.layout.pdfviewer);
        pdfView = findViewById(R.id.pdfView);
        readPdfFromAssets("linux.pdf");
    }

    private void readPdfFromAssets(String bookname) {
        pdfView.fromAsset(bookname)
                // .pages(0, 2, 1, 3, 3, 3) // 会过滤一些页面，注释掉
                .enableSwipe(true)
                .enableDoubletap(true)
                .swipeVertical(true)    //竖向翻页
                .defaultPage(1)
                .showMinimap(false)    //pdf放大的时候，是否在屏幕的右上角生成小地图
                .onDraw(this)
                .onLoad(this)
                .onPageChange(this)
                .enableAnnotationRendering(false)
                .password(null)
                .showPageWithAnimation(true)
                .load();
    }

    @Override
    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
        //页面绘制时回调，可以得到宽、高等信息
    }

    @Override
    public void loadComplete(int nbPages) {
        //加载完成时回调，可以得到总页数nbPages
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        //翻页时回调，可以得到当前页数page，总页数pageCount
    }
}
