public class Queens
{
    public static void main(String[] args)
    {
        int n= 8;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='-';
        if(solveForNQueens(board,0,n)) printBoard(board,n);

    }
    public static void printBoard(char board[][], int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(" "+board[i][j]+" ");
            System.out.println();
        }
    }
    public static boolean checkForThreat(char board[][], int row, int column, int n)
    {
        int i,j;
        //checks given row for Queens
        for(i=0;i<column;i++)
        {
            if(board[row][i]=='Q') return false;
        }
        //checks given column for Queens
        for(i=0;i<row;i++)
        {
            if(board[i][column]=='Q') return false;
        }
        //checks diagonal X
        for(i=row,j=column; i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q') return false;
        }
        for(i=row,j=column; i<n && j>=0;i++,j--)
        {
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    public static boolean solveForNQueens(char board[][], int column, int n)
    {
       //if column is bigger n then the algorithm is finished(its iterated through every column)
        if(column>=n) return true;


        for(int i=0;i<n;i++)
        {
            if(checkForThreat(board,i,column,n)) // checks current position/ if position is threatened -> checks for next in row. / if isSafe() = true puts "Q" in pos and incements column by 1
            {
                board[i][column]='Q';
                if(solveForNQueens(board, column+1,n)) return true; // recursive call to method to place next Queen/ if there is no position to place the queen in next column -> sets previous queen pos. to neutral/ replace prev. queen
                else board[i][column]='-';

            }
        }
        return false;
    }
}