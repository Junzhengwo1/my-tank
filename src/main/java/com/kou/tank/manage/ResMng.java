package com.kou.tank.manage;

import com.kou.tank.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * 资源加载
 * @author JIAJUN KOU
 */
public class ResMng {

    public static BufferedImage goodTankL,goodTankU,goodTankR,goodTankD;
    public static BufferedImage badTankL,badTankU,badTankR,badTankD;
    public static BufferedImage bulletL,bulletU,bulletR,bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];


    static {
        try {
            goodTankU  = ImageIO.read(Objects.requireNonNull(ResMng.class.getClassLoader().getResourceAsStream("static/good.png")));
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);

            badTankU = ImageIO.read(Objects.requireNonNull(ResMng.class.getClassLoader().getResourceAsStream("static/bad.jpg")));
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD =ImageUtil.rotateImage(badTankU,180);

            bulletU = ImageIO.read(Objects.requireNonNull(ResMng.class.getClassLoader().getResourceAsStream("static/bullet.jpg")));
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bulletD = ImageUtil.rotateImage(bulletU,180);

            for (int i = 0; i < explodes.length; i++) {
                explodes[i] = ImageIO.read(Objects.requireNonNull(ResMng.class.getClassLoader().getResourceAsStream("static/e"+(i+1)+".png")));
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
