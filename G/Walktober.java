import java.util.*;

class Solution{
    public static long solve(int N,int M,int P, int[][] my){
        long ans=0;
        for(int j=0;j<N;j++){
            int maximum=Integer.MIN_VALUE;
            for(int i=0;i<M;i++){
                if(my[i][j]>maximum)
                    maximum=my[i][j];
            }
            ans+=(maximum-my[P-1][j]);
        }
        return ans;
    }
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        int testCase=sc.nextInt();
        for(int test=1;test<=testCase;test++){
            int M=sc.nextInt();
            int N=sc.nextInt();
            int P=sc.nextInt();
            int[][] my=new int[M][N];
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    my[i][j]=sc.nextInt();
                }
            }
            long ans=solve(N,M,P,my);
            System.out.println("Case #"+test+": "+ans);
        }
    }
}