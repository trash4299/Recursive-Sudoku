import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

class TableGui extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private boolean in;
    private Square [][] elbow;

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    TableGui() {
        elbow = new Square[9][9];
        for (int x=0;x<9;x++) {
            for(int p=0;p<9;p++) {
                elbow[x][p]= new Square();
            }
        }
        in = false;
        JPanel p = new JPanel();
        JTable table = new JTable(9,9);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setRowHeight(40);
        TableColumnModel columnModel = table.getColumnModel();
        for(int x=0;x<9;x++) {
            columnModel.getColumn(x).setPreferredWidth(15);
        }
        this.setTitle("Enter Known Values");
        JButton b1 = new JButton("Solve!");
        this.add(p);
        b1.addActionListener(e -> in = true);
        p.add(b1);
        p.add(new JScrollPane(table));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        while(!in){
            try {
                Thread.sleep(1);
            } catch(InterruptedException ignored) {
            }
        }
        setVisible(false);
        for(int a=0;a<9;a++) {
            for(int b=0;b<9;b++) {
                String temp = (String) table.getModel().getValueAt(a,b);
                if(temp!=null&&temp!=""&&!temp.equals("")) {
                    elbow[a][b].finnum = Integer.parseInt(temp);
                    elbow[a][b].fin=true;
                }
            }
        }
    }

    Square[][] give() {
        return elbow;
    }

    TableGui(Square[][] end) {
        JPanel p = new JPanel();
        JTable table = new JTable(9,9);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setRowHeight(40);
        TableColumnModel columnModel = table.getColumnModel();
        for(int x=0;x<9;x++) {
            columnModel.getColumn(x).setPreferredWidth(15);
        }
        p.add(new JScrollPane(table));
        this.add(p);
        this.setTitle("Solved Sudoku!");
        for(int x=0; x<9;x++) {
            for(int y=0; y<9;y++) {
                table.setValueAt(end[x][y].finnum,x,y);
            }
        }
        this.pack();
        this.setVisible(true);
    }
}
