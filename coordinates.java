class Coordinates {
    int x = -1;
    int y = -1;

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
                    y = 133;
                    break;
                case "green":
                    y = 266;
                    break;
                case "blue":
                    y = 399;
            }
            switch (card.symbol) {
                case "1":
                    x = 0;
                    break;
                case "2":
                    x = 85;
                    break;
                case "3":
                    x = 170;
                    break;
                case "4":
                    x = 255;
                    break;
                case "5":
                    x = 340;
                    break;
                case "6":
                    x = 425;
                    break;
                case "7":
                    x = 510;
                    break;
                case "8":
                    x = 595;
                    break;
                case "9":
                    x = 680;
                    break;
                case "0":
                    x = 765;    
            }
        }
    }
}