package controllers;

import lombok.RequiredArgsConstructor;
import views.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@RequiredArgsConstructor
public class ChooseLevelController implements ActionListener {
    private final Game game;

    @Override
    public void actionPerformed(ActionEvent e) {
        game.getSodokuModel().setLevel(Integer.parseInt(e.getActionCommand()));
        game.gameStart();
    }
}
