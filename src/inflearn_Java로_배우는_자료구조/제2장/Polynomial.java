package inflearn_Java로_배우는_자료구조.제2장;

public class Polynomial {
    public char name;
    public Term[] terms;
    public int nTerms;

    public Polynomial() {
        nTerms = 0;
        terms = new Term[100];
    }

    public Polynomial(char name) {
        this.name = name;
        nTerms = 0;
        terms = new Term[100];
    }

    public int calcPolynomial(int x) {
        int result = 0;
        for (int i=0; i<nTerms; i++) {
            result += terms[i].calcTerm(x);
        }
        return result;
    }

    public void printPolynomial() {
        for (int i=0; i<nTerms; i++) {
            terms[i].printTerm();
            System.out.println("+");
        }
        System.out.println();
    }

    public void addTerm(int c, int e) {
        int index = findTerm(e);
        if (index != -1) {
            terms[index].coef += c;
        } else {
            int i = nTerms-1;
            while (i>=0 && terms[i].expo < e) {
                terms[i+1] = terms[i];
                i--;
            }
            terms[i+1] = new Term(c, e);
            nTerms++;
        }
    }

    public int findTerm(int e) {
        for (int i=0; i<nTerms && terms[i].expo >= e; i++) {
            if (terms[i].expo == e)
                return i;
        }
        return -1;
    }
}
