
see if i can display values in jtable as they fill


solver () {
	
	int x = 0;
	int y = 0;
	
        enter = new Square[9][9];
        for (int x=0;x<9;x++) {
            for(int p=0;p<9;p++) {
                enter[x][p]= new Square();
            }
        }
        enter = inputGui();
	recursion(0,0);
        solutionGui(enter);
}

recursion void (int x, int y) {
	if(!enter[x][y].final) {
		for(int trying=0;trying<9;trying++) {
			System.println("Trying "+trying+"at ("+x+","+y+").   ");
			if(colcheck(x,trying)&&rowcheck(y,trying)&&squarecheck(x,y,trying)) {
				enter[x][y] = trying;
				break;
			}
		}	
	}
	
	if(x==8&&y==8) {
		return;
	}
	else if(y==8) {
		if(solver(x+1,0));
	}
	else {	  // y<8
		solver(x,y+1);
	}
}

colcheck boolean(int ex, int maybe) {
	for(int r=0;r<9:r++) {
		if(enter[ex][r].final&&enter[ex][r].final == maybe) {
			System.print("Found another "+maybe+" in the column.");
			return false;
		}
	}
	return true;
}

rowcheck boolean(int why, int maybe) {
	for(int r=0;r<9:r++) {
		if(enter[r][why].final&&enter[r][why].final == maybe) {
			System.print("Found another "+maybe+" in the row.");
			return false;
		}
	}
	return true;
}

squarecheck boolean(int ex, int why, int maybe) {
	int a = ex/3;
	int b = why/3;
		
	for(int r=(3*a);r<(3*a+2);r++) {
		for(int s=(3*b);s<(3*b+2);s++) {
			if(enter[r][s].final&&enter[r][s].final == maybe) {
				System.print("Found another "+maybe+" in the square.");
				return false;
			}
		}
	}
	return true;
}

