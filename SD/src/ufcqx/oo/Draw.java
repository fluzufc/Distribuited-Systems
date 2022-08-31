package src.ufcqx.oo;

public class Draw {
    public static void main(String[] args) {
        Figure figures[] = new Figure[2];
        figures[0] = new Circle();
        figures[1] = new Square();

        for(int i = 0; i < figures.length; i++)
            figures[i].draw();
    }
}
