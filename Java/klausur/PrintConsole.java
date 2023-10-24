public class PrintConsole{
    public static void main(String[] args){
        int num = 10;
        printConsole(num);
    }

    public static void printConsole(int n){
        for(int i = 0 ; i <= 2*n ; i += 2){
            System.out.println(i);
        }
    }
}