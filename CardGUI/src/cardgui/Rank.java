package cardgui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DV003874
 */
public enum Rank {

        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JAKE(10),
        QUEEN(10),
        KING(10);
        private final int value;

        Rank(int number) {
            value = number;
        }

        public int getNumScore() {
            return value;
        }
}
