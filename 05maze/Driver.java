public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data3.dat", true);
        
        f.clearTerminal();
        f.solve();

        f.clearTerminal();
        System.out.println(f);
    }
}
