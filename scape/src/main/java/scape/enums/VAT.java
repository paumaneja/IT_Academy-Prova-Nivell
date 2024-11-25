package scape.enums;

public enum VAT {
    CLUE(0.10),
    DECORATION(0.21);

    private final double tax;

    VAT (double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

}
