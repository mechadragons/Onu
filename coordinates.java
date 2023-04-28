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
                    x = 255;
                    break;
                case "green":
                    x = 510;
                    break;
                case "blue":
                    x = 765;
            }
        }
        else if (card.symbol == "reverse" || card.symbol == "plusTwo") {
            if (card.color == "blue") {
                y = 665;
                switch (card.symbol) {
                    case "reverse":
                        x = 0;
                        break;
                    case "plusTwo":
                        x = 85;
                }
            }
            else {
                y = 532;
                switch (card.color) {
                    case "red":
                        switch (card.symbol) {
                            case "reverse":
                                x = 85;
                                break;
                            case "plusTwo":
                                x = 170;
                        }
                        break;
                    case "green":
                        switch (card.symbol) {
                            case "reverse":
                                x = 595;
                                break;
                            case "plusTwo":
                                x = 680;
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

    private int gety(int colorInt) {
        return (int) Math.round(HEIGHT * colorInt);
    }

    private int getx(String symbol) {
        int symbolInt = Integer.parseInt(symbol);
        if (symbolInt == 0) {
            return (int) Math.round(WIDTH * 9);
        }
        return (int) Math.round(WIDTH * (symbolInt - 1));
    }
}