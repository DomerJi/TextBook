package com.textbook.browse.util;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by v_jishuaipeng on 2020-09-03.
 * 描述:
 */
public class AssetsUtil {
    public static final String NAME = "booklist";

    public static String getFromAssets(Context context, String fileName) {
        File file = getFile(context, fileName);
        if (file == null || !file.exists()) {
            return "";
        } else {
            if (file.length() > 0) {
                return file.getAbsolutePath();
            }
        }
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            BufferedInputStream in = null;
            BufferedOutputStream out = null;
            in = new BufferedInputStream(inputStream);
            out = new BufferedOutputStream(new FileOutputStream(file));
            int len = -1;
            byte[] b = new byte[1024];
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    public static File getFile(Context context, String fileName) {
        File cacheFile = new File(context.getExternalCacheDir().getAbsolutePath());
        if (cacheFile != null && !cacheFile.exists()) {
            cacheFile.mkdir();

        }

        File cache2File = new File(context.getExternalCacheDir().getAbsolutePath() + File.pathSeparator + NAME);
        if (!cache2File.exists()) {
            cacheFile.mkdir();
        }

        File file = new File(context.getExternalCacheDir().getAbsolutePath() + File.pathSeparator
                + NAME + File.pathSeparator
                + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return file;
        }
        return file;
    }
}
