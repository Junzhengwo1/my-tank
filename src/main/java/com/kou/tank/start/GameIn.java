package com.kou.tank.start;

import com.kou.tank.view.MyFrame;

/**
 * 入口
 * @author JIAJUN KOU
 */
public class GameIn {


    public static void main(String[] args) throws InterruptedException {

        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);

        while (true) {
            Thread.sleep(50);
            myFrame.repaint();

        }

    }




}
