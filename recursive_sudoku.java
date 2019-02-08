class Solver {
    private Square[][] enter;

    public static void main(String[] args) {
        new Solver();
    }

    private Solver() {
        enter = new Square[9][9];
        for (int x=0;x<9;x++) {
            for(int p=0;p<9;p++) {
                enter[x][p]= new Square();
            }
        }
        enter = inputGui();
        new TableGui(solvin());
    }

    private Square [][] inputGui() {
        TableGui beginning = new TableGui();
        return beginning.give();
    }

    private Square[][] solvin(){
        recursion(0,0);
        return enter;
    }

    private void recursion  (int x, int y) {
        if(!enter[x][y].fin) {
            for(int trying=0;trying<9;trying++) {
                System.out.println("\nTrying "+(trying+1)+" at ("+x+","+y+").   ");
                if(colcheck(x,trying+1)&&rowcheck(y,trying+1)&&squarecheck(x,y,trying+1)) {
                    enter[x][y].finnum = trying+1;
                    break;
                }
            }
        }
        if(x==8&&y==8) {
            return;
        }
        else if(y==8) {
            recursion(x+1,0);
        }
        else {
            recursion(x,y+1);
        }
    }

    private boolean colcheck (int ex, int maybe) {
        for(int r=0;r<9;r++) {
            if(enter[ex][r].fin&&enter[ex][r].finnum == maybe) {
                System.out.print("Found another "+maybe+" in the column.");
                return false;
            }
        }
        return true;
    }

    private boolean rowcheck (int why, int maybe) {
        for(int r=0;r<9;r++) {
            if(enter[r][why].fin&&enter[r][why].finnum == maybe) {
                System.out.print("Found another "+maybe+" in the row.");
                return false;
            }
        }
        return true;
    }

    private boolean squarecheck(int ex, int why, int maybe) {
        int a = ex/3;
        int b = why/3;

        for(int r=(3*a);r<(3*a+2);r++) {
            for(int s=(3*b);s<(3*b+2);s++) {
                if(enter[r][s].fin&&enter[r][s].finnum == maybe) {
                    System.out.print("Found another "+maybe+" in the square.");
                    return false;
                }
            }
        }
        return true;
    }

}
