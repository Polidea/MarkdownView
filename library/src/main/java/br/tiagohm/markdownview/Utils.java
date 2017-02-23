package br.tiagohm.markdownview;

import android.content.res.AssetManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils
{
    private Utils()
    {
    }

    public static String getStringFromAssetFile(AssetManager asset, String filename)
    {
        InputStream is = null;

        try
        {
            is = asset.open(filename);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while((length = is.read(buffer)) != -1)
            {
                baos.write(buffer, 0, length);
            }
            return baos.toString("UTF-8");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
        finally
        {
            if(is != null)
            {
                try
                {
                    is.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}