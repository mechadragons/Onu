import java.lang.Math;

class Coordinates {
    int x = -1;
    int y = -1;
    final double WIDTH = 85.55;
    final double HEIGHT = 133.6;

    public Coordinates(Card card) {
        if (card.symbol == "skip") {
            y = 532;
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
        else if (card.symbol == "reverse" || card.symbol == "plusTwo") {
            if (card.color == "blue") {
                y = 668;
                switch (card.symbol) {
                    case "reverse":
                        x = 0;
                        break;
                    case "plusTwo":
                        x = 86;
                }
            }
            else {
                y = 534;
                switch (card.color) {
                    case "red":
                        switch (card.symbol) {
                            case "reverse":
                                x = 86;
                                break;
                            case "plusTwo":
                                x = 171;
                        }
                        break;
                    case "yellow":
                        switch (card.symbol) {
                            case "reverse":
                                x = 342;
                            case "plusTwo":
                                x = 428;
                        }
                    case "green":
                        switch (card.symbol) {
                            case "reverse":
                                x = 599;
                                break;
                            case "plusTwo":
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