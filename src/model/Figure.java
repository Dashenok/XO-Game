package model;

/**
 * Created by b0noI on 05/02/2015.
 */
public enum Figure {
    X("X"), O("O");
    private final String figure;

    Figure(String figure) {
        this.figure = figure;
    }

    /*public Figure(final String figure) {

        assert figure != null;

        this.figure = figure;
    }*/

    public String getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return this.figure;
    }

}
