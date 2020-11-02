package test0728;

public class HomeShuLie {
    //斐波那契数列
    public int shuLie(int num) {
        if(num  < 2){
            return 0;
        }else if(num < 3){
            return 1;
        }else{
            return shuLie(num-1)+shuLie(num-2);
        }
    }
    public static void main(String[] args) {
        //F[n]=F[n-1]+F[n-2](n>=3,F[1]=1,F[2]=1)
        HomeShuLie homeShuLie = new HomeShuLie();
        for (int i = 1; i <20 ; i++) {
            System.out.print(homeShuLie.shuLie(i)+"  ");

        }
    }
}
