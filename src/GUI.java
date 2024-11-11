import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class GUI implements ActionListener {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JTable board = new JTable(9, 9);
    TableCellEditor defaultEditor = board.getDefaultEditor(Object.class);

    JButton submit = new JButton("Solve");
    JButton resetBut = new JButton("Reset");

    public GUI(){
        
        board.setShowGrid(true);

        // JTextField[] grid = new JTextField[9];
        // JTextField uno = new JTextField();

        JLabel L1 = new JLabel("Gimma dem values");

        submit.setSize(20,10);
        submit.setPreferredSize(new Dimension(20,10));
        submit.setMaximumSize(new Dimension(20,10));

        resetBut.setSize(20,10);
        resetBut.setPreferredSize(new Dimension(20,10));
        resetBut.setMaximumSize(new Dimension(20,10));

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout());
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SoodoKoo");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,500);

        panel.add(L1);
        // panel.add(uno);
        panel.add(board);
        panel.add(submit);
        panel.add(resetBut);

        submit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ae){
                submitted(ae);
            }
        });

        resetBut.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ae){
                resetGame(ae);
            }
        });


        //FOR TESTING
        autoInput();

        // for (int i=0;i<9;i++){
        //     panel.add(grid[i]);
        // }
    }

    //this must use ex5
    public void autoInput(){

        String ex1 = "0 5 3 0 0 8 4 9 0 2 8 4 3 9 6 0 0 7 0 9 6 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 2 8 3 0 5 0 0 0 0 0 2 0 0 6 1 0 0 7 4 1 8 5 9 6 2 0 0 8 7 6 0 0 1 0 0 6 0 0 0 9 0 7 8";
        String ex2 = "0 0 2 0 6 0 4 0 0 0 0 4 0 0 5 0 7 8 5 0 0 0 7 0 0 0 3 2 7 1 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 7 1 9 5 0 0 0 4 0 0 0 6 8 3 0 2 0 0 1 0 0 0 0 2 0 6 0 8 0 0";
        String ex3 = "0 0 0 0 8 7 0 1 3 0 0 0 4 0 0 0 0 0 0 0 1 2 3 0 4 0 7 0 0 5 0 0 4 0 6 2 0 0 2 5 0 9 3 0 0 1 7 0 6 0 0 5 0 0 7 0 9 0 5 1 2 0 0 0 0 0 0 0 7 0 0 0 3 1 0 9 8 0 0 0 0";
        String ex4 = "8 0 0 3 9 0 0 5 0 9 0 5 0 0 0 0 6 0 0 0 3 0 4 0 8 1 0 2 0 1 0 8 9 0 0 3 3 5 6 0 7 0 8 2 9 4 0 0 2 0 0 7 0 0 0 2 0 0 4 0 6 0 0 0 8 0 0 0 0 4 0 7 0 6 0 0 8 0 0 0 5";
        String ex5 = "0 0 2 0 0 4 5 0 0 0 6 0 0 0 5 0 7 0 4 0 0 0 7 8 0 0 3 2 7 1 0 0 0 0 0 0 0 0 8 0 0 0 2 0 0 0 0 0 0 0 0 7 1 9 5 0 0 8 3 0 0 0 2 0 4 0 2 0 0 0 6 0 0 0 6 1 0 0 8 0 0";
        String[] autobase = ex5.split(" ");



        for(int i=0; i<81; i++){
            if(!autobase[i].equals("0")){
                String val = Integer.toString(i, 3);
                val = String.format("%4s", val);
                val = val.replace(' ', '0');
                board.setValueAt(autobase[i], i/9, i%9);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    private void submitted(MouseEvent ae){
        
        String[] base = collectInput();

        App.gatherInput(base);
        tempdisplayinput();
        int[][][][] output = App.solve();
        displayOutput(output);
        submit.setEnabled(false);
        board.setDefaultEditor(Object.class, null);
    }

    public void resetGame(MouseEvent ae){
        submit.setEnabled(true);
        board.setDefaultEditor(Object.class, defaultEditor);
        clearBoard();
    }

    public void clearBoard(){
        for (int i=0; i<81; i++){
            board.setValueAt(null, i/9, i%9);
        }
    }

    public String[] collectInput(){
        String[] base = new String[81];
        for (int i=0; i<81; i++){
            if (board.getValueAt(i/9, i%9) == null)
                base[i] = "0";
            else
                base[i] = board.getValueAt(i/9, i%9).toString();
        }
        return base;
    }

    public void tempdisplayinput(){
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        System.out.print(App.detes[i][k][j][l] + " ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public void displayOutput(int[][][][] output){

        int count = 0;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                String val = Integer.toString(count, 3);
                val = String.format("%4s", val);
                val = val.replace(' ', '0');
                board.setValueAt(output[Character.getNumericValue(val.charAt(0))][Character.getNumericValue(val.charAt(2))][Character.getNumericValue(val.charAt(1))][Character.getNumericValue(val.charAt(3))], i, j);
                count++;
            }
        }

    }

}
