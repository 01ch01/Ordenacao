/**
 * Título da classe. Insira aqui uma pequena descrição sobre a mesma.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Apr 30, 2019 at 9:38:21 PM
 * @version 0.1
 */
package classes;

import java.util.Scanner;

public class InsertionSort extends AlgoritmosOrdenacao {

    private Scanner input = new Scanner(System.in);
    private int insercoes = 0;

    public InsertionSort(int[] vetor) {
        super(vetor);
        long tempoInicial = System.currentTimeMillis();
        this.ordenaVetorInsertionSort();
        long tempoFinal = System.currentTimeMillis();
        super.tempoTotal = tempoFinal - tempoInicial;
    }

    public int getInsercoes() {
        return insercoes;
    }

    public void setInsercoes(int insercoes) {
        this.insercoes = insercoes;
    }

    private void ordenaVetorInsertionSort() {
        int element, i, j;

        for (j = 1; j < this.getVetor().length; j++) {
            element = this.getItem(j);
            for (i = j - 1; (i >= 0) && (this.getItem(i) > element); i--) {
                super.comparacoes++;
                this.setItem(i + 1, this.getItem(i));
            }
            this.inserir(i + 1, element);
        }
    }

    private void inserir(int i, int element) {
        this.setInsercoes(this.getInsercoes() + 1);
        this.setItem(i, element);
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    @Override
    public long getTempoTotal() {
        return tempoTotal;
    }

    @Override
    public void setTempoTotal(long tempoTotal) {
        this.tempoTotal = tempoTotal;
    }
}
