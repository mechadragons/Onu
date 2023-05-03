import java.lang.Math;

class Coordinates {
    int x = -1;
    int y = -1;
    final double WIDTH = 85.55;
    final double HEIGHT = 133.6;

    public Coordinates(Card card) {
        if (card.color.equals("wild")) {
            y = 668;
            if (card.symbol.equals("wild")) {
                x = 171;
            }
            else {
                x = 342;
            }
        }
        else if (card.symbol.equals("skip")) {
            y = 534;
            switch (card.color) {
                case "red":
                    x = 0;
                    break;
                case "yellow":
                    x = 257;
                    break;
                case "green":
                    x = 513;
                    break;
                case "blue":
                    x = 770;
            }
        }
        else if (card.symbol == "reverse" || card.symbol == "drawTwo") {
            if (card.color.equals("blue")) {
                y = 668;
                if (card.symbol.equals("reverse")) {
                    x = 0;
                }
                else {
                    x = 86;
                }
            }
            else {
                y = 534;
                if (card.color.equals("red")) {
                    if (card.symbol.equals("reverse")) {
                        x = 86;
                    }
                    else {
                        x = 171;
                    }
                }
                else if (card.color.equals("yellow")) {
                    if (card.symbol.equals("reverse")) {
                        x = 342;
                    }
                    else {
                        x = 428;
                    }
                }
                else {
                    if (card.symbol.equals("reverse")) {
                        x = 599;
                    }
                    else {
                        x = 684;
                    }
                }
            }
        }
        else {
            switch (card.color) {
                case "red":
                    y = 0;
                    break;
                case "yellow":
                    y = gety(1);
                    break;
                case "green":
                    y = gety(2);
                    break;
                case "blue":
                    y = gety(3);
            }

            x = getx(card.symbol);
        }
    }

    private int getx(String symbol) {
        int symbolInt = Integer.parseInt(symbol);
        if (symbolInt == 0) {
            return (int) Math.round(WIDTH * 9);
        }
        return (int) Math.round(WIDTH * (symbolInt - 1));
    }

    private int gety(int colorInt) {
        return (int) Math.round(HEIGHT * colorInt);
    }
}