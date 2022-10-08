package com.kou.tank.view;

import com.kou.tank.entity.Tank;
import com.kou.tank.enume.TankDirEnum;
import com.kou.tank.enume.TankEnum;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author JIAJUN KOU
 */
@Slf4j
public class MyFrame extends Frame {

    Tank mytTank;
    Tank enemy;

    public MyFrame() {
        this.setTitle("King Tank Game……");
        this.setLocation(400,100);
        this.setSize(800,600);

        this.addKeyListener(new TankKeyListener());

        // 初始化坦克
        mytTank = new Tank(100, 100, TankDirEnum.R,"KING", 1);
        enemy = new Tank(300, 400, TankDirEnum.D,"enemy", 2);


    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g){
        if(null == offScreenImage ){
            offScreenImage = this.createImage(TankEnum.SIZE_X.getSize(),TankEnum.SIZE_Y.getSize());
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.fillRect(0,0,TankEnum.SIZE_X.getSize(), TankEnum.SIZE_Y.getSize());
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage,0,0,null);

    }



    @Override
    public void paint(Graphics g) {
        mytTank.paint(g);
        log.info(mytTank.getTitle() + ": Tank 绘画完成……");
        enemy.paint(g);
        log.info(enemy.getTitle() + ": Tank 绘画完成……");

    }

    private  class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            mytTank.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            mytTank.keyReleased(e);

        }
    }
}
