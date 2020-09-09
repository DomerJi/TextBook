package com.textbook.browse.ui.activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.link.DefaultLinkHandler;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnLongPressListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.model.LinkTapEvent;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.silang.superfileview.R;
import com.textbook.browse.face.OnItemClickListener;
import com.textbook.browse.model.Catalogue;
import com.textbook.browse.model.CatalogueFactory;
import com.textbook.browse.model.LoadFileModel;
import com.textbook.browse.ui.adapter.CatalogueAdapter;
import com.textbook.browse.ui.adapter.PageAdapter;
import com.textbook.browse.ui.base.BaseActivity;
import com.textbook.browse.util.Md5Tool;
import com.textbook.browse.util.PageUtil;
import com.textbook.browse.util.TLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FileDisplayActivity extends BaseActivity {


    private String TAG = "FileDisplayActivity";
    private String filePath;
    private PDFView mPdfView;
    private LinearLayout mLlPage;
    private TextView mTvPage;
    private TextView mTvPageCount;
    private TextView mTvPageSymbol;
    private PageUtil mPageUtil;
    private PageAdapter mPageAdapter;
    private LinearLayout mLlCatalogue;
    private List<Catalogue> catalogues;
    private CatalogueAdapter catalogueAdapter;
    private RecyclerView mCataLogues;
    private RecyclerView mRvPage;
    private AppCompatImageView mIvNight;
    private AppCompatImageView mIvOrientation;
    private AppCompatImageView mIvWidthHeight;

    private boolean isNight = false;
    private boolean isHorization = true;
    private boolean isFull = false;
    private PDFView.Configurator mConfigurator;
    private int mCurrentPage = 0;
    private ImageView mIvMenu;
    private long downTime;
    private LinearLayout mLlBottomTab;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_display);
        initView();
        initData();

    }

    private void initData() {
        Intent intent = this.getIntent();
        filePath = (String) intent.getSerializableExtra("path");
        TLog.d(TAG, "filePath:" + filePath);
        if (TextUtils.isEmpty(filePath)) {
            return;
        }


        if (filePath.contains("http")) {//网络地址要先下载
            Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 1) {

                        if (msg.obj instanceof File) {
                            File file = (File) msg.obj;
                            if (file != null) {
                                mPdfView.fromFile(file).load();
                                return;
                            }
                        }
                    }
                    // todo 失败

                }
            };
            downLoadFromNet(filePath, handler);
        }

        initCatalogues();

        mConfigurator = mPdfView.fromAsset(filePath)
//                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(isHorization)
                .enableDoubletap(false)
                .defaultPage(mCurrentPage)
                // allows to draw something on the current page, usually visible in the middle of the screen
                .onDraw(new OnDrawListener() {
                    @Override
                    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                    }
                })
                // allows to draw something on all pages, separately for every page. Called only for visible pages
                .onDrawAll(new OnDrawListener() {
                    @Override
                    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                    }
                })
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {

                    }
                }) // called after document is loaded and starts to be rendered
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        mCurrentPage = page;
                        initPages(pageCount);
                        mTvPage.setText(String.valueOf(mPageUtil.getDatas().get(page).name));
                        mTvPageCount.setText(String.valueOf(pageCount - mPageUtil.getHeadCount()));
                        mTvPageSymbol.setText("/");
                        if (mPageAdapter != null) {
                            mPageAdapter.setCurrentPageNotify(page);
                        }
                        if (catalogueAdapter != null) {
                            catalogueAdapter.setCurrentPageNotify(page);
                        }
                    }
                })
                .onPageScroll(new OnPageScrollListener() {
                    @Override
                    public void onPageScrolled(int page, float positionOffset) {

                    }
                })
                .onError(new OnErrorListener() {
                    @Override
                    public void onError(Throwable t) {

                    }
                })
                .onPageError(new OnPageErrorListener() {
                    @Override
                    public void onPageError(int page, Throwable t) {

                    }
                })
                .onRender(new OnRenderListener() {
                    @Override
                    public void onInitiallyRendered(int nbPages) {

                    }
                }) // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .onTap(new OnTapListener() {
                    @Override
                    public boolean onTap(MotionEvent e) {
                        TLog.e("MotionEvent", " ========onTap  getAction = " + e.getAction());

                        if (mLlBottomTab.getTag() instanceof Boolean) {
                            if (!(boolean) mLlBottomTab.getTag()) {
                                return false;
                            }
                        }

                        if (mLlBottomTab.getVisibility() == View.GONE) {
                            mLlBottomTab.setTag(false);
                            mLlBottomTab.setAlpha(0f);
                            mLlBottomTab.setVisibility(View.VISIBLE);
                            mLlBottomTab.animate().alpha(1f)
                                    .setDuration(300)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            mLlBottomTab.setTag(true);
                                        }
                                    });
                        } else {
                            mLlBottomTab.setTag(false);
                            mLlBottomTab.setVisibility(View.VISIBLE);
                            mLlBottomTab.animate().alpha(0f)
                                    .setDuration(300)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            mLlBottomTab.setTag(true);
                                            mLlBottomTab.setVisibility(View.GONE);
                                        }
                                    });
                        }
                        return true;


                    }
                })
                .onLongPress(new OnLongPressListener() {
                    @Override
                    public void onLongPress(MotionEvent e) {

                    }
                })
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                .linkHandler(new DefaultLinkHandler(mPdfView) {
                    @Override
                    public void handleLinkEvent(LinkTapEvent event) {
                        super.handleLinkEvent(event);
                    }
                })
                .pageFitPolicy(isFull ? FitPolicy.HEIGHT : FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(true) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(true) // make a fling change only a single page like ViewPager
                .nightMode(isNight); // toggle night mode

        mConfigurator.load();
    }


    public void initView() {
        mPdfView = (PDFView) findViewById(R.id.pdfView);

        // 页码
        mLlPage = findViewById(R.id.ll_page);
        mTvPage = findViewById(R.id.tv_page);
        mTvPageCount = findViewById(R.id.tv_page_count);
        mTvPageSymbol = findViewById(R.id.tv_page_symbol);

        mTvPage.setTextColor(isNight ? Color.WHITE : Color.BLACK);
        mTvPageCount.setTextColor(isNight ? Color.WHITE : Color.BLACK);
        mTvPageSymbol.setTextColor(isNight ? Color.WHITE : Color.BLACK);

        mLlBottomTab = findViewById(R.id.ll_bottom_tab);

        // 目录按钮
        mLlCatalogue = findViewById(R.id.ll_catalogue);
        mIvMenu = findViewById(R.id.iv_menu);
        // 目录列表和页码列表
        mCataLogues = findViewById(R.id.rv_catalogues);
        mRvPage = findViewById(R.id.rv_page);

        // 工具栏
        mIvNight = findViewById(R.id.iv_night);
        mIvOrientation = findViewById(R.id.iv_orientation);
        mIvWidthHeight = findViewById(R.id.iv_width_height);

        // 黑夜/白天模式
        mIvNight.setImageResource(isNight ? R.drawable.ic_night : R.drawable.ic_light);
        mIvNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNight = !isNight;
                mConfigurator.defaultPage(mCurrentPage).nightMode(isNight).load();
                mIvNight.setImageResource(isNight ? R.drawable.ic_night : R.drawable.ic_light);

                mTvPage.setTextColor(isNight ? Color.WHITE : Color.BLACK);
                mTvPageCount.setTextColor(isNight ? Color.WHITE : Color.BLACK);
                mTvPageSymbol.setTextColor(isNight ? Color.WHITE : Color.BLACK);

            }
        });

        // 水平/垂直浏览
        mIvOrientation.setImageResource(isHorization ? R.drawable.ic_panorama_horizontal : R.drawable.ic_panorama_vertical);
        mIvOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHorization = !isHorization;
                mConfigurator.defaultPage(mCurrentPage).swipeHorizontal(isHorization).load();
                mIvOrientation.setImageResource(isHorization ? R.drawable.ic_panorama_horizontal : R.drawable.ic_panorama_vertical);
            }
        });

        // 高度/宽度占满
        mIvWidthHeight.setImageResource(isFull ? R.drawable.ic_page_normal : R.drawable.ic_page_full);
        mIvWidthHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFull = !isFull;
                mConfigurator.defaultPage(mCurrentPage).pageFitPolicy(isFull ? FitPolicy.HEIGHT : FitPolicy.WIDTH).load();
                mIvWidthHeight.setImageResource(isFull ? R.drawable.ic_page_normal : R.drawable.ic_page_full);
            }
        });
    }

    /**
     * 初始化目录 {@link CatalogueFactory}
     */
    private void initCatalogues() {
        if (catalogues == null) {
            catalogues = CatalogueFactory.getCatalogueList(filePath);
        }
        if (catalogues == null || catalogues.isEmpty()) {
            mLlCatalogue.setVisibility(View.GONE);
        } else {
            mCataLogues.setLayoutManager(new LinearLayoutManager(mContext,
                    LinearLayoutManager.VERTICAL, false));
            mLlCatalogue.setVisibility(View.VISIBLE);
            mLlCatalogue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRvPage.setVisibility(View.GONE);
                    if (mCataLogues.getVisibility() == View.GONE) {
                        mCataLogues.setVisibility(View.VISIBLE);
                        if (catalogueAdapter == null) {
                            catalogueAdapter = new CatalogueAdapter(filePath);
                            catalogueAdapter.setCurrentPage(mPdfView.getCurrentPage());
                            mCataLogues.setAdapter(catalogueAdapter);
                            catalogueAdapter.setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Catalogue catalogue = catalogueAdapter.getItem(position);
                                    int index = catalogue.getPage();
                                    if (mPageUtil != null) {
                                        index = catalogue.getPage() + mPageUtil.getHeadCount() - 1;
                                    }
                                    mPdfView.jumpTo(index);
                                    catalogueAdapter.setCurrentPageNotify(index);
                                    mCataLogues.setVisibility(View.GONE);
                                    mIvMenu.setSelected(mCataLogues.getVisibility() == View.VISIBLE);
                                }
                            });
                        } else {
                            catalogueAdapter.setCurrentPageNotify(mPdfView.getCurrentPage());
                        }
                    } else {
                        mCataLogues.setVisibility(View.GONE);
                    }
                    mIvMenu.setSelected(mCataLogues.getVisibility() == View.VISIBLE);
                }
            });
        }
    }

    /**
     * 初始化页数
     *
     * @param pageCount
     */
    private void initPages(int pageCount) {

        if (mPageUtil == null) {
            final String[] heads = CatalogueFactory.getHeads(filePath);
            mPageUtil = new PageUtil(pageCount, heads);

            final GridLayoutManager gridManager = new GridLayoutManager(mContext, 10);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int i) {
                    if (i == (mPageUtil.getHeadCount() - 1)) {
                        int spanSize = gridManager.getSpanCount() - mPageUtil.getHeadCount();
                        if (spanSize > 0) {
                            return spanSize + 1;
                        }
                    }
                    return 1;

                }
            });
            mRvPage.setLayoutManager(gridManager);
            mLlPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCataLogues.setVisibility(View.GONE);
                    if (mRvPage.getVisibility() == View.VISIBLE) {
                        mRvPage.setVisibility(View.GONE);
                    } else {
                        mRvPage.setVisibility(View.VISIBLE);
                        if (mPageAdapter == null) {
                            mPageAdapter = new PageAdapter(mPageUtil);
                            mPageAdapter.setCurrentPage(mPdfView.getCurrentPage());
                            mPageAdapter.setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    int index = mPageUtil.getDatas().get(position).index;
                                    String name = mPageUtil.getDatas().get(position).name;
                                    mPdfView.jumpTo(index);
                                    mPageAdapter.setCurrentPageNotify(index);
                                    mRvPage.setVisibility(View.GONE);
                                }
                            });
                            mRvPage.setAdapter(mPageAdapter);
                        } else {
                            mPageAdapter.setCurrentPageNotify(mPdfView.getCurrentPage());
                        }
                    }
                    mIvMenu.setSelected(mCataLogues.getVisibility() == View.VISIBLE);
                }
            });
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TLog.d("FileDisplayActivity-->onDestroy");
        if (mPdfView != null) {
            mPdfView.recycle();
        }
    }


    public static void show(Context context, String url) {
        Intent intent = new Intent(context, FileDisplayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("path", url);
        intent.putExtras(bundle);
        context.startActivity(intent);

    }


    private void downLoadFromNet(final String url, final Handler handler) {

        //1.网络下载、存储路径、
        File cacheFile = getCacheFile(url);
        if (cacheFile.exists()) {
            if (cacheFile.length() <= 0) {
                TLog.d(TAG, "删除空文件！！");
                cacheFile.delete();
                return;
            }
        }


        LoadFileModel.loadPdfFile(url, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                TLog.d(TAG, "下载文件-->onResponse");
                boolean flag;
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    ResponseBody responseBody = response.body();
                    is = responseBody.byteStream();
                    long total = responseBody.contentLength();

                    File file1 = getCacheDir(url);
                    if (!file1.exists()) {
                        file1.mkdirs();
                        TLog.d(TAG, "创建缓存目录： " + file1.toString());
                    }


                    //fileN : /storage/emulated/0/pdf/kauibao20170821040512.pdf
                    File fileN = getCacheFile(url);//new File(getCacheDir(url), getFileName(url))

                    TLog.d(TAG, "创建缓存文件： " + fileN.toString());
                    if (!fileN.exists()) {
                        boolean mkdir = fileN.createNewFile();
                    }
                    fos = new FileOutputStream(fileN);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        TLog.d(TAG, "写入缓存文件" + fileN.getName() + "进度: " + progress);
                    }
                    fos.flush();
                    TLog.d(TAG, "文件下载成功,准备展示文件。");
                    // 2.ACache记录文件的有效期
                    if (handler != null) {
                        Message message = new Message();
                        message.what = 1;
                        message.obj = fileN;
                        handler.sendMessage(message);
                    }
                } catch (Exception e) {
                    TLog.d(TAG, "文件下载异常 = " + e.toString());
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                TLog.d(TAG, "文件下载失败");
                File file = getCacheFile(url);
                if (!file.exists()) {
                    TLog.d(TAG, "删除下载失败文件");
                    file.delete();
                }
                if (handler != null) {
                    Message message = new Message();
                    message.what = 0;
                    handler.sendMessage(message);
                }
            }
        });


    }

    /***
     * 获取缓存目录
     *
     * @param url
     * @return
     */
    private File getCacheDir(String url) {

        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/007/");

    }

    /***
     * 绝对路径获取缓存文件
     *
     * @param url
     * @return
     */
    private File getCacheFile(String url) {
        File cacheFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/007/"
                + getFileName(url));
        TLog.d(TAG, "缓存文件 = " + cacheFile.toString());
        return cacheFile;
    }

    /***
     * 根据链接获取文件名（带类型的），具有唯一性
     *
     * @param url
     * @return
     */
    private String getFileName(String url) {
        String fileName = Md5Tool.hashKey(url) + "." + getFileType(url);
        return fileName;
    }

    /***
     * 获取文件类型
     *
     * @param paramString
     * @return
     */
    private String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {
            TLog.d(TAG, "paramString---->null");
            return str;
        }
        TLog.d(TAG, "paramString:" + paramString);
        int i = paramString.lastIndexOf('.');
        if (i <= -1) {
            TLog.d(TAG, "i <= -1");
            return str;
        }


        str = paramString.substring(i + 1);
        TLog.d(TAG, "paramString.substring(i + 1)------>" + str);
        return str;
    }

}
