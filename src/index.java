import java.util.ArrayList;

public class index {
    static String input = "r";

    public static boolean check_input(String input) {

        System.out.print(input);
        boolean temp_valid = false;
        try {
            switch (input) {
                case "Y":
                    temp_valid = true;
                    System.out.println("what");
                    break;

                case "R":
                    temp_valid = true;
                    System.out.print("hi");
                    break;

                case "penis":
                    temp_valid = true;
                    break;

                default:
                    System.out.println(" invalid input");
                    temp_valid = false;


            }

        } catch (Exception e) {

        }
        return temp_valid;
    }




    public static void create_empty_table() {

    }

    public static boolean validate_board(String[][] grid) {
        boolean valid_grid = false;
        int counter_y = 0;
        int counter_R = 0;
        for (int A = 0; A < 6; A++) {

            for (int B = 0; B < 7; B++) {
                switch (grid[A][B]) {
                    case "Y":
                        counter_y++;
                        break;
                    case "R":
                        counter_R++;
                        break;
                    default:
                        break;
                }
            }

        }

        if (counter_R < counter_y) {
            System.out.println("too many yellow ");
            return false;
        }
        if (counter_R >= counter_y + 2) {
            System.out.println("too many reds impossible");
            return false;
        }


        System.out.println("yellow moves = " + counter_y + "\n" + "red moves=" + counter_R);
        for (int i = 0; i < 6; i++) {

            for (int x = 0; x < 7; x++) {
                //System.out.print(grid[i][x]);
                try {
                    switch (grid[i][x]) {

                        case ".":
                            valid_grid = true;
                            break;

                        case "R":
                            valid_grid = true;


                            if (i - 1 < 4) {
                                if (grid[i + 1][x] == ".") {
                                    System.out.println("impossible config");
                                    //System.out.print(i);

                                    valid_grid = false;
                                    break;
                                }
                            }

                            break;

                        case "Y":
                            valid_grid = true;
                            counter_y++;

                            if (i - 1 < 4) {
                                if (grid[i + 1][x] == ".") {
                                    System.out.println("impossible config");
                                    //System.out.print(i);

                                    valid_grid = false;
                                    break;
                                }
                            }

                            break;

                        default:
                            System.out.println(" invalid input");
                            valid_grid = false;
                            System.out.println("wtf  is => " + grid[i][x]);

                            break;

                    }
                } catch (Exception e) {

                }

            }

            //System.out.print("\n");
        }



        return valid_grid;
    }

public static boolean validate_move(int input_col,String[][] grid ) {
	boolean valid_move = false;
	//String area =  grid[4][1];
	try {
	if ( grid[0][input_col] == ".") {
		System.out.println("valid move");
		valid_move = true;
		
	}else{
		System.out.println("full");
		}
	}
	catch ( Exception e ) {
		System.out.println("invalid input form");
		
		
	}
	
	
	
	
	return valid_move;
}



    public static void main(String[] args) {
        //red always starts


    	String [][] grid = { {".",".",".",".",".",".","."},
    						 {".",".",".",".",".",".","."},
    						 {".",".",".",".",".",".","."},
    						 {".",".",".",".",".",".","."},
    						 {".",".",".",".",".",".","."},
    						 {".",".",".",".",".",".","."},
			  				};
    	
        grid[5][1] = "R";
        grid[4][1] = "Y";
        grid[3][1] = "Y";
        grid[2][1] = "Y";
        grid[1][1] = "Y";
        grid[0][1] = "Y";
      
    
        
        for (int i = 0; i < 6; i++) {

            for (int x = 0; x < 7; x++) {
                System.out.print(grid[i][x]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        validate_board(grid);
        validate_move(1,grid);





    }

}