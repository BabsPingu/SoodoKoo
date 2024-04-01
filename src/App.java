import java.util.Scanner;
import java.util.ArrayList;


public class App {

    static int[][][][] detes;
    static ArrayList<Integer>[] poss = new ArrayList[81];

    public static void main(String[] args) throws Exception {

        for (int i=0;i<81;i++){
            poss[i] = new ArrayList<Integer>();
            for(int j=1;j<=9;j++){
                poss[i].add(j);
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("gimma dem values");

        String input = in.nextLine();
        String ex1 = "0 5 3 0 0 8 4 9 0 2 8 4 3 9 6 0 0 7 0 9 6 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 2 8 3 0 5 0 0 0 0 0 2 0 0 6 1 0 0 7 4 1 8 5 9 6 2 0 0 8 7 6 0 0 1 0 0 6 0 0 0 9 0 7 8";
        //String ex2 = "0 0 2 0 6 0 4 0 0 0 0 4 0 0 5 0 7 8 5 0 0 0 7 0 0 0 3 2 7 1 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 7 1 9 5 0 0 0 4 0 0 0 6 8 3 0 2 0 0 1 0 0 0 0 2 0 6 0 8 0 0";

        //String[] base = input.split(" ");
        String[] base = ex1.split(" ");

        detes = gatherInput(base);

        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        System.out.print(detes[i][k][j][l] + " ");
                    }
                }
                System.out.println();
            }
        }

        System.out.println("\n");
        solve();


    }

    public static int[][][][] gatherInput(String[] input){
        int[][][][] detes = new int[3][3][3][3];
        int a = 0;
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        detes[i][j][k][l] = Integer.parseInt(input[a]);
                        a++;
                    }
                }
            }
        }
        return detes;
    }

    public static void solve(){
        int fin = 0;
        while(fin==0){
            fin = 1;
            for(int i=0; i<3;i++){
                for(int j=0;j<3;j++){
                    for(int k=0;k<3;k++){
                        for(int l=0;l<3;l++){
                            if(detes[i][j][k][l] == 0){
                                fin = 0;
                                checkRelations(i,j,k,l);
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        System.out.print(detes[i][k][j][l] + " ");
                    }
                }
                System.out.println();
            }
        }
        
    }

    public static void checkRelations(int a, int b, int c, int d){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(detes[a][b][i][j] != 0){
                    poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].remove(Integer.valueOf(detes[a][b][i][j]));
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(detes[a][i][c][j] != 0){
                    poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].remove(Integer.valueOf(detes[a][i][c][j]));
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(detes[i][b][j][d] != 0){
                    poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].remove(Integer.valueOf(detes[i][b][j][d]));
                }
            }
        }
        if(poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].size()==1){
            detes[a][b][c][d] = poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].get(0);
        }
    }


}
