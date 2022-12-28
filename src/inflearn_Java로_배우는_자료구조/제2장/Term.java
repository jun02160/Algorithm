package inflearn_Java로_배우는_자료구조.제2장;

public class Term {
    public int coef;
    public int expo;

    public Term(int c, int e) {
        coef = c;
        expo = e;
    }

    public int calcTerm(int x) {
        return (int) (coef * Math.pow(x, expo));
    }

    public void printTerm() {
        System.out.println(coef + "x^" + expo);  // -x^2 => -1x^2
    }
}
