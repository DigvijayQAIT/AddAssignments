package pyramid;

public class AssignmentOne {

	public static void main(String[] args) {
		
		int i, j, rows = 3, k = 0;
		
		for (i = rows; i >= 1; --i) {
			for (int space = 0; space < rows - i; ++space) {
				System.out.print("  ");
			}
			for (j = i; j <= 2 * i -1; ++j) {
				System.out.print("* ");
			}
			for (j = 0; j < i - 1; ++j) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		
		for (i = 2; i <= rows; ++i, k =0) {
			for (int space = 1; space <= rows - i; ++space) {
				System.out.print("  ");
			}
			

	        while(k != 2*i-1)
	        {
	            System.out.print("* ");
	            ++k;
	        }
	        
	        System.out.println("");
		}

	}

}
