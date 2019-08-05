package innerclasses;

public class Display {

    private static final int DISPLAY_HEIGHT =  1920;
    private static final int DISPLAY_WIDTH = 1280;
    private int x = 0;

    public Display(){
        Pixel pixel = new Pixel(10, 10, Color.BLUE);

    }


    private class Pixel{


        int x;
        int y;
        private Color color;

        private Pixel(int x, int y, Color color) {

            if (0 <= x&&x <= DISPLAY_WIDTH && 0<= y && y<= DISPLAY_WIDTH){
                this.x = x;
                this.y = y;
                this.color = color;
                System.out.println(" Creating " + color + " pixel at (" + x +", "+y+")");
            } else {
                throw new IllegalArgumentException("Coordinates x should be between 0 - " +DISPLAY_WIDTH+ " and y should between 0 - " + DISPLAY_HEIGHT);
            }
        }

    }


    public enum Color {
        RED, GREEN, BLUE, CIAN, MAGENTA, YELLOW, BLACK
    }
}
