package Trees;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int points[][]=new int[N][2];
        if(N==0){
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<2; j++){
                points[i][j]=s.nextInt();
            }
        }
        int K=s.nextInt();
        if(K==0){
            return;
        }
        int[] dist=new int[N];
        int m=0;
        for(int i=0; i<N; i++){
            int formula= (int) (Math.pow(points[i][0],2)+Math.pow(points[i][1], 2));
            int distance= (int) Math.sqrt(formula);
            dist[m]=distance;
            m++;
        }
        for(int i=0; i<K; i++){
            int smallestDist=Integer.MAX_VALUE;
            int smallestDistIndex=-1;
            for(int k=0; k<N; k++){
                if(dist[k]<smallestDist){
                    smallestDist=dist[k];
                    smallestDistIndex=k;
                }
            }
            System.out.print(points[smallestDistIndex][0]+" "+points[smallestDistIndex][1]);
            System.out.println();
            dist[smallestDistIndex]=Integer.MAX_VALUE;
        }
    }
}
