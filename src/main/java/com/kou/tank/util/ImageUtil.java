package com.kou.tank.util;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author JIAJUN KOU
 *
 */
public class ImageUtil {

    public static BufferedImage rotateImage(final BufferedImage bufferedImage,final int degree){
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int type = bufferedImage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2D;
        (graphics2D =  (img = new BufferedImage(width,height,type))
                .createGraphics())
                .setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        graphics2D.rotate(Math.toRadians(degree), width >> 1, height >> 1);
        graphics2D.drawImage(bufferedImage,0,0,null);
        graphics2D.dispose();
        return img;
    }



}
