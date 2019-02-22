class Solver {
    private Square[][] enter;
    private int [][] temptest;
    private boolean done;
    public int x,y;

    public static void main(String[] args) {
        new Solver();
    }

    private Solver() {
        done = false;
        enter = new Square[9][9];
        x = 0;
        y = 0;
        for (int x=0;x<9;x++) {
            for(int p=0;p<9;p++) {
                enter[x][p]= new Square();
            }
        }
        
        enter = inputGui();
        recursion(x,y);
        new TableGui(enter);
    }

    private Square [][] inputGui() {
        TableGui beginning = new TableGui();
        return beginning.give();
    }

    private void recursion  (int x, int y) {
        if(!enter[x][y].fin) {
            for(int trying=0;trying<9;trying++) {
                //System.out.print("\nTrying "+(trying+1)+" at ("+(x+1)+","+(y+1)+"). ");
                if(check(x,y,trying+1)) {
                    enter[x][y].finnum = trying+1;
                    if(x==8&&y==8) {
                        done = true;
                        return;
                    }
                    else if(y==8)
                        recursion(x+1,0);
                    else
                        recursion(x,y+1);
                    if(!done)
                        enter[x][y].finnum = 0;
                    else
                        return;
                }
            }
        }
        else {
            if (x == 8 && y == 8) {
                done = true;
                return;
            } else if (y == 8)
                recursion(x + 1, 0);
            else
                recursion(x, y + 1);
        }
    }

    private boolean check (int ex, int why, int maybe) {
        int a = ex/3;
        int b = why/3;

        for(int r=0;r<9;r++) {
            if(enter[ex][r].finnum == maybe) {
                //System.out.print("Found another "+maybe+" in the row at ("+(ex+1)+","+(r+1)+").");
                return false;
            }
        }
        for(int r=0;r<9;r++) {
            if(enter[r][why].finnum == maybe) {
                //System.out.print("Found another "+maybe+" in the column at("+(r+1)+","+(why+1)+").");
                return false;
            }
        }
        for(int r=(3*a);r<(3*a+3);r++) {
            for(int s=(3*b);s<(3*b+3);s++) {
                if(enter[r][s].finnum == maybe) {
                    //System.out.print("Found another "+maybe+" in the square at ("+(r+1)+","+(s+1)+").");
                    return false;
                }
            }
        }
        return true;
    }

}
