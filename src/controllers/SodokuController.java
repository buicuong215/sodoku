package controllers;

import lombok.RequiredArgsConstructor;
import models.SodokuModel;
import utils.Constants;
import views.Game;
import views.SodokuView;
import views.TimeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
@RequiredArgsConstructor
public class SodokuController implements ActionListener, KeyListener {
    private final SodokuView sodokuView;
    private final Game game;
    private final TimeView timeView;
    private int rowCurrent=0;
    private int colCurrent=0;



    @Override
    public void actionPerformed(ActionEvent e) {
        String[] data=e.getActionCommand().split("");
        rowCurrent=Integer.parseInt(data[0]);
        colCurrent=Integer.parseInt(data[1]);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int value= e.getKeyChar()-48;
        SodokuModel sodokuModel= game.getSodokuModel();
        if(value<=0||value>9||colCurrent==0||rowCurrent==0||sodokuModel.getNodes()[rowCurrent][colCurrent].isProtect()){
            return;
        }

        if(!sodokuModel.validateNode(rowCurrent,colCurrent,value)){
            int checkFalse=sodokuModel.getCheckFalse()+1;
            timeView.updateCheck(checkFalse);
            sodokuModel.setCheckFalse(checkFalse);
            if(checkFalse==3){
                game.gameOver(Constants.MESSAGE_LOSE);
            }

        }else{
            sodokuModel.updateData(rowCurrent, colCurrent, value);
            sodokuView.updateView(rowCurrent,colCurrent,value);
            game.setStatusEnd(Constants.STATUS_LOSE);

        }


        if(sodokuModel.checkWin()){
            game.gameOver(Constants.MESSAGE_WIN);
            game.setStatusEnd(Constants.STATUS_WIN);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
