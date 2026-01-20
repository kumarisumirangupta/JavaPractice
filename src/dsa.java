public class dsa {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
        };

        //Print spiral traversal of the matrix
        boolean  reversre= false;
        for(int i=0 ;i< arr.length; i++){

            if(reversre) {
                reversre = false;
                for (int j = arr[i].length - 1 ; j >= 0; j--) {
                    System.out.print(arr[i][j]+",");
                }
            } else {
                reversre = true;
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] +",");
                }
            }
            System.out.print("\n");
        }

        //boundary traversal of the matrix


    }
}
