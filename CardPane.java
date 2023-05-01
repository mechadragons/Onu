import javax.swing.JLayeredPane;
class CardPane {
    int layer;
    Card card;
    JLayeredPane pane;

    CardPane(int layer, Card card, JLayeredPane pane) {
        this.layer = layer;
        this.card = card;
        this.pane = pane;
    }
}