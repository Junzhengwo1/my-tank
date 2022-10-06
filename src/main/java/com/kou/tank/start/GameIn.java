package com.kou.tank.start;

import com.kou.tank.entity.Tank;
import com.kou.tank.view.MyFrame;

/**
 * 入口
 * @author JIAJUN KOU
 */
public class GameIn {


    public static void main(String[] args) throws InterruptedException {


        MyFrame myFrame = new MyFrame();
        new MyFrame().setVisible(true);

        while (true) {
            Thread.sleep(50);
            myFrame.repaint();

        }

    }




}
