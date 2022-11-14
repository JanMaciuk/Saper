import java.util.Scanner;

public class Main {
    public static boolean running = true;
    public static void main(String[] args) {

        int tura = 0;
        int y = 0;
        int x = 0;
        Scanner userIn = new Scanner(System.in);


        System.out.println("Podaj rozmiar planszy:");
        int rozmiar = 1;
        try { rozmiar = userIn.nextInt(); }
        catch (java.util.InputMismatchException e) {
            System.out.println("Podaj liczbę!");
            try { rozmiar = userIn.nextInt(); }
            catch (java.util.InputMismatchException b) {System.exit(2);}
        }
        if (rozmiar < 2) {
            System.out.println("Podaj liczbę większą od 1!");
            try { rozmiar = userIn.nextInt(); }
            catch (java.util.InputMismatchException b) {System.exit(2);}
        }
        Cell[][] board = GenerujBoarda(rozmiar);

        while (running) {
            System.out.println("Rozegrać turę? (y/n)");
            if (userIn.next().equalsIgnoreCase("n")) {
                running = false;
                System.exit(2);
            } else {
                System.out.println("podaj kordynat y");
                    try { y = userIn.nextInt(); }
                    catch (java.util.InputMismatchException e) {
                        System.out.println("Podaj liczbę!");
                        try { y = userIn.nextInt(); }
                        catch (java.util.InputMismatchException b) {System.exit(2);}
                }
                System.out.println("podaj kordynat x");
                    try { x = userIn.nextInt(); }
                    catch (java.util.InputMismatchException e) {
                        System.out.println("Podaj liczbę!");
                        try { x = userIn.nextInt(); }
                        catch (java.util.InputMismatchException b) {System.exit(2);}
                }
                Klikniecie(board,y,x);
            }
            tura++;
            Print(board, rozmiar);
            System.out.println("tura: "+tura);
        }

    }
    public static Cell[][] GenerujBoarda(int rozmiar) {
        Cell[][] board = new Cell[rozmiar][rozmiar];
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                board[i][j] = new Cell();
            }
        }
        return board;
    }

    public static void Klikniecie(Cell[][] board, int x, int y) {
        if (board[x][y].getBomba()) {
            System.out.println("Kaboom, przegrałeś");
            running = false;
            System.exit(2);
        } else {
            board[x][y].setOdkryta(true);
            //set neighbouring cells as discovered
            for (int i = y-1; i <= y+1; i++) {
                for (int j = x-1; j <= x+1; j++) {
                    board[j][i].setOdkryta(true);
                    }
                }
            }

    }

    public static void Print(Cell[][] board, int M) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j].getOdkryta()) {
                    if (board[i][j].getBomba()) {
                        System.out.print("X  ");
                    } else {
                        System.out.print("0  ");
                    }
                } else {
                    System.out.print("'  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}