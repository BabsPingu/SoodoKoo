import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class App {

    static int[][][][] detes = new int[3][3][3][3];
    static ArrayList<Integer>[] poss = new ArrayList[81];
    static int cow = 0;

    public static void main(String[] args) throws Exception {


        new GUI();
        run();


    }

    public static void run(){

        // Scanner in = new Scanner(System.in);
        // System.out.println("gimma dem values");

        // String input = in.nextLine();
        // String ex1 = "0 5 3 0 0 8 4 9 0 2 8 4 3 9 6 0 0 7 0 9 6 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 2 8 3 0 5 0 0 0 0 0 2 0 0 6 1 0 0 7 4 1 8 5 9 6 2 0 0 8 7 6 0 0 1 0 0 6 0 0 0 9 0 7 8";
        // String ex2 = "0 0 2 0 6 0 4 0 0 0 0 4 0 0 5 0 7 8 5 0 0 0 7 0 0 0 3 2 7 1 0 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 7 1 9 5 0 0 0 4 0 0 0 6 8 3 0 2 0 0 1 0 0 0 0 2 0 6 0 8 0 0";
        // String ex3 = "0 0 0 0 8 7 0 1 3 0 0 0 4 0 0 0 0 0 0 0 1 2 3 0 4 0 7 0 0 5 0 0 4 0 6 2 0 0 2 5 0 9 3 0 0 1 7 0 6 0 0 5 0 0 7 0 9 0 5 1 2 0 0 0 0 0 0 0 7 0 0 0 3 1 0 9 8 0 0 0 0";
        // String ex4 = "8 0 0 3 9 0 0 5 0 9 0 5 0 0 0 0 6 0 0 0 3 0 4 0 8 1 0 2 0 1 0 8 9 0 0 3 3 5 6 0 7 0 8 2 9 4 0 0 2 0 0 7 0 0 0 2 0 0 4 0 6 0 0 0 8 0 0 0 0 4 0 7 0 6 0 0 8 0 0 0 5";

        //String[] base = input.split(" ");
        // String[] base = ex3.split(" ");

        // gatherInput(base);

        // for (int i=0;i<81;i++){
        //     poss[i] = new ArrayList<Integer>();
        //     for(int j=1;j<=9;j++){
        //         int t = Integer.parseInt(Integer.toString(i,3));
        //         int d = t%10; t = t/10; int c=t%10; t=t/10; int b=t%10; t=t/10; int a=t%10; t=t/10;
        //         if(detes[a][b][c][d] == 0){
        //             poss[i].add(j);
        //         }
        //     }
        // }

        for (int i=0;i<81;i++){
            poss[i] = new ArrayList<Integer>();
            for(int j=1;j<=9;j++){
                poss[i].add(j);
            }
        }

        // for(int i=0; i<3;i++){
        //     for(int j=0;j<3;j++){
        //         for(int k=0;k<3;k++){
        //             for(int l=0;l<3;l++){
        //                 System.out.print(detes[i][k][j][l] + " ");
        //             }
        //         }
        //         System.out.println();
        //     }
        // }

        System.out.println("\n");
        // solve();

    }

    public static void gatherInput(String[] input){
        int a = 0;
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        detes[i][k][j][l] = Integer.parseInt(input[a]);
                        a++;
                    }
                }
            }
        }
    }

    public static int[][][][] solve(){
        int fin = 0;
        while(fin==0 && cow<=162){
            fin = 1;
            for(int i=0; i<3;i++){
                for(int j=0;j<3;j++){
                    for(int k=0;k<3;k++){
                        for(int l=0;l<3;l++){
                            if(detes[i][j][k][l] == 0){
                                fin = 0;
                                checkRelations(i,j,k,l);
                            } else {
                                poss[Integer.parseInt(Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + Integer.toString(l),3)].clear();
                            }
                        }
                    }
                }
            }
            cow++;
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

        return detes;
        
    }

    public static void checkRelations(int a, int b, int c, int d){
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        ArrayList<Integer> temp3 = new ArrayList<>();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i!=c || j!=d){
                    if(detes[a][b][i][j] != 0){
                        poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].remove(Integer.valueOf(detes[a][b][i][j]));
                    } else {
                        temp1.addAll(poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(i) + Integer.toString(j),3)]);
                    }
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i!=b || j!=d){
                    if(detes[a][i][c][j] != 0){
                        poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].remove(Integer.valueOf(detes[a][i][c][j]));
                    } else {
                        temp2.addAll(poss[Integer.parseInt(Integer.toString(a) + Integer.toString(i) + Integer.toString(c) + Integer.toString(j),3)]);
                    }
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i!=a || j!=c){
                    if(detes[i][b][j][d] != 0){
                        poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].remove(Integer.valueOf(detes[i][b][j][d]));
                    } else {
                        temp3.addAll(poss[Integer.parseInt(Integer.toString(i) + Integer.toString(b) + Integer.toString(j) + Integer.toString(d),3)]);
                    }
                }
            }
        }
        if(poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].size()==1){
            detes[a][b][c][d] = poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].get(0);
            cow = 0;
        }

        //change detes val if temp contains all possible vals from poss except 1

        ArrayList<Integer> copy = new ArrayList<>();
        copy = (ArrayList<Integer>) poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].clone();
        for (int v : temp1){
            copy.removeAll(Arrays.asList(v));
        }
        
        if(copy.size()==1){
            detes[a][b][c][d] = copy.get(0);
            cow = 0;
        }
        
        copy = (ArrayList<Integer>) poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].clone();
        for (int v : temp2){
            copy.removeAll(Arrays.asList(v));
        }
        
        if(copy.size()==1){
            detes[a][b][c][d] = copy.get(0);
            cow = 0;
        }

        copy = (ArrayList<Integer>) poss[Integer.parseInt(Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d),3)].clone();
        for (int v : temp3){
            copy.removeAll(Arrays.asList(v));
        }
        
        if(copy.size()==1){
            detes[a][b][c][d] = copy.get(0);
            cow = 0;
        }

    }


}
