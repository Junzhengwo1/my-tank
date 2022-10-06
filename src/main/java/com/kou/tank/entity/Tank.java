package com.kou.tank.entity;

import com.kou.tank.enume.TankDirEnum;
import com.kou.tank.enume.TankEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @author JIAJUN KOU
 */

public class Tank {

    // 坦克位置
    private int x;

    private int y;

    private TankDirEnum dirEnum;

    private boolean bL,bU,bR,bD;

    // 坦克移动速度
    private static  final int SPEED = 5;

    // 坦克是否该移动
    private boolean moving = false;

    // 坦克名称
    public String title;

    // 坦克等级
    private int level;

    public Tank(int x, int y, TankDirEnum dirEnum, String title, int level) {
        this.x = x;
        this.y = y;
        this.dirEnum = dirEnum;
        this.title = title;
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TankDirEnum getDirEnum() {
        return dirEnum;
    }

    public void setDirEnum(TankDirEnum dirEnum) {
        this.dirEnum = dirEnum;
    }

    public boolean isbL() {
        return bL;
    }

    public void setbL(boolean bL) {
        this.bL = bL;
    }

    public boolean isbU() {
        return bU;
    }

    public void setbU(boolean bU) {
        this.bU = bU;
    }

    public boolean isbR() {
        return bR;
    }

    public void setbR(boolean bR) {
        this.bR = bR;
    }

    public boolean isbD() {
        return bD;
    }

    public void setbD(boolean bD) {
        this.bD = bD;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // 画坦克
    public void paint(Graphics g) {
        try {
            BufferedImage tankImg = ImageIO.read(Objects.requireNonNull(Tank.class.getClassLoader().getResourceAsStream("static/logo.png")));

            g.drawImage(tankImg,x,y,
                    TankEnum.SIZE_X.getSize(),
                    TankEnum.SIZE_Y.getSize(),
                    null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        move();
    }

    // 键盘按一下 就东一下
    public void keyPressed(KeyEvent e) {
        System.out.println("按下键盘");
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT -> bL = true;
            case KeyEvent.VK_UP -> bU = true;
            case KeyEvent.VK_RIGHT -> bR = true;
            case KeyEvent.VK_DOWN -> bD = true;
        }

        // 确定移动方向
        setMainDir();

    }

    private void setMainDir() {

        moving = bL || bU || bR || bD;

        if (bL && !bU && !bR && !bD){
            dirEnum = TankDirEnum.L;
        }
        if (!bL && bU && !bR && !bD){
            dirEnum = TankDirEnum.U;
        }
        if (!bL && !bU && bR && !bD){
            dirEnum = TankDirEnum.R;
        }
        if (!bL && !bU && !bR && bD){
            dirEnum = TankDirEnum.D;
        }
    }

    private void move() {
        if (!moving) return;
        switch (dirEnum) {
            case L -> x -= SPEED;
            case U -> y -= SPEED;
            case R -> x += SPEED;
            case D -> y += SPEED;
        }

    }


    public void keyReleased(KeyEvent e) {
        System.out.println("松开键盘");
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT -> bL = false;
            case KeyEvent.VK_UP -> bU = false;
            case KeyEvent.VK_RIGHT -> bR = false;
            case KeyEvent.VK_DOWN -> bD = false;
        }
        // 确定移动方向
        setMainDir();

    }
}
