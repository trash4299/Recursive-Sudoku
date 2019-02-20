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
        //TESTING ARRAYS
        //int [][] temptest = {{0,1,5,4,6,9,7,3,8},{4,8,7,1,3,5,6,2,9},{6,9,3,8,7,2,4,1,5},{8,6,2,3,4,1,5,9,7},{5,4,9,2,8,7,3,6,1},{7,3,1,9,5,6,2,8,4},{9,2,4,5,1,3,8,7,6},{1,7,8,6,2,4,9,5,3},{3,5,6,7,9,8,1,4,2}};
        int [][] temptest = {{2,0,0,3,0,0,0,0,0},{8,0,4,0,6,2,0,0,3},{0,1,3,8,0,0,2,0,0},{0,0,0,0,2,0,3,9,0},{5,0,7,0,0,0,6,2,1},{0,3,2,0,0,6,0,0,0,},{0,2,0,0,0,9,1,4,0},{6,0,1,2,5,0,8,0,9},{0,0,0,0,0,1,0,0,2}};

        for(int t=0;t<9;t++)
        {
            for(int h=0;h<9;h++)
            {
                if(temptest[t][h]!=0)
                {
                    enter[t][h].finnum=temptest[t][h];
                    enter[t][h].fin=true;
                }
            }
        }

        //enter = inputGui();
        //end testing stuff
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
                System.out.print("Trying "+(trying+1)+" at ("+(x+1)+","+(y+1)+"). ");
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
            else   //x < 8 and y < 8
                recursion(x, y + 1);
        }
    }

    private boolean check (int ex, int why, int maybe) {
        int a = ex/3;
        int b = why/3;

        for(int r=0;r<9;r++) {
            if(r!=y&&enter[ex][r].finnum == maybe) {
                System.out.println("Found another "+maybe+" in the row at ("+(ex+1)+","+(r+1)+").");
                return false;
            }
        }
        for(int r=0;r<9;r++) {
            if(r!=x&&enter[r][why].finnum == maybe) {
                System.out.println("Found another "+maybe+" in the column at("+(r+1)+","+(why+1)+").");
                return false;
            }
        }
        for(int r=(3*a);r<(3*a+3);r++) {
            for(int s=(3*b);s<(3*b+3);s++) {
                if(!(a==ex&&b==why)&&enter[r][s].finnum == maybe) {
                    System.out.println("Found another "+maybe+" in the square at ("+(r+1)+","+(s+1)+").");
                    return false;
                }
            }
        }
        return true;
    }

}
