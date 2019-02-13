# Recursive-Sudoku

I am making a recursive Sudoku solver to compare against my non-recursive solver. I am making the recursion happen with a void method which is intersting and tough. The solver has to go back and forth between cells which means transversing the array in the x and y directions. I think the main problems is with the control signals of when to advance to the next cell or go back up the tree. To fully fit with recursion, I want my program to go back up the tree once a branch fails rather than going back a cell when I tell it to. 
