import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    public GUI(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        // JTextField[] grid = new JTextField[9];
        JTextField uno = new JTextField();
        JLabel L1 = new JLabel("Gimma dem values");
        JButton submit = new JButton("Solve");


        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout());
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SoodoKoo");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,500);

        panel.add(L1);
        panel.add(uno);
        panel.add(submit);

        submit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ae){
                submitted(ae);
            }
        });

        // for (int i=0;i<9;i++){
        //     panel.add(grid[i]);
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    private void submitted(MouseEvent ae){
        String ex1 = "0 5 3 0 0 8 4 9 0 2 8 4 3 9 6 0 0 7 0 9 6 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 2 8 3 0 5 0 0 0 0 0 2 0 0 6 1 0 0 7 4 1 8 5 9 6 2 0 0 8 7 6 0 0 1 0 0 6 0 0 0 9 0 7 8";
        String ex2 = "0 0 2 0 6 0 4 0 0 0 0 4 0 0 5 0 7 8 5 0 0 0 7 0 0 0 3 2 7 1 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 7 1 9 5 0 0 0 4 0 0 0 6 8 3 0 2 0 0 1 0 0 0 0 2 0 6 0 8 0 0";
        String ex3 = "0 0 0 0 8 7 0 1 3 0 0 0 4 0 0 0 0 0 0 0 1 2 3 0 4 0 7 0 0 5 0 0 4 0 6 2 0 0 2 5 0 9 3 0 0 1 7 0 6 0 0 5 0 0 7 0 9 0 5 1 2 0 0 0 0 0 0 0 7 0 0 0 3 1 0 9 8 0 0 0 0";
        String ex4 = "8 0 0 3 9 0 0 5 0 9 0 5 0 0 0 0 6 0 0 0 3 0 4 0 8 1 0 2 0 1 0 8 9 0 0 3 3 5 6 0 7 0 8 2 9 4 0 0 2 0 0 7 0 0 0 2 0 0 4 0 6 0 0 0 8 0 0 0 0 4 0 7 0 6 0 0 8 0 0 0 5";
        String[] base = ex4.split(" ");

        App.gatherInput(base);
        tempdisplayinput();
        App.solve();
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

}
