package demo;

import magick.ImageInfo;
import magick.Magick;
import magick.MagickException;
import magick.MagickImage;

/**
 * Created by daijiajia on 16/5/13.
 */
public class ImageMagickDemo {
    static {
        System.setProperty("jmagick.systemclassloader","no");
    }

    public static void main(String[] args) {
        resize("http://www.imagemagick.org/image/wizard.png","wizard");
    }

    public static void resize(String from,String to) {
        try {
            ImageInfo fromPic = new ImageInfo(from);
            MagickImage image = new MagickImage(fromPic);
            MagickImage toPic = image.scaleImage(100,100);
            toPic.setFileName(to);
            toPic.writeImage(fromPic);
        } catch (MagickException e) {
            e.printStackTrace();
        }

    }
}
