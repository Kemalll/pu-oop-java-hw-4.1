package GPS;

import Field.Field;
import Field.UnchartedField;
import Field.MoveingField;
import Field.UncrossableSwamp;
import Field.SafeField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GPS extends JFrame implements MouseListener {

  
    Field[][] forest;
    public static final int FOREST_SIZE = 8;

    public GPS() {
        this.forest = new Field[FOREST_SIZE][FOREST_SIZE];
        for (int l = 0; l < FOREST_SIZE; l++) {
            for (int k = 0; k < FOREST_SIZE; k++) {
                forest[l][k] = (new UnchartedField(l, k, Color.GREEN));
            }
        }
            forest[1][6]=(new UncrossableSwamp(Color.BLUE));
            forest[7][7]=(new MoveingField(Color.YELLOW));

        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                this.renderSpecialField(g,row,col);

            }
        }
    }
    private Field getField(int row,int col){
        return this.forest[row][col];
    }
    private boolean hasSpecialField(int row,int col){
        return this.getField(row,col) !=null;
    }

    private void renderSpecialField(Graphics g,int row,int col){

        if(this.hasSpecialField(row,col)) {
            Field f = this.getField(row, col);
            f.render(g);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}




