/**
 * Título da classe. Insira aqui uma pequena descrição sobre a mesma.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Apr 30, 2019 at 10:05:47 PM
 * @version 0.1
 */
package classes;

public class QuickSort extends AlgoritmosOrdenacao {

    private int pivosSelecionados = 0;

    public int getPivosSelecionados() {
        return pivosSelecionados;
    }

    public QuickSort(int[] vetor) {
        super(vetor);
        long tempoInicial = System.currentTimeMillis();
        this.ordenaVetorQuickSort(0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        super.tempoTotal = tempoFinal - tempoInicial;
        this.setVetorOrdenado(true);

    }

    private int selecionarPivo(int inicio, int fim) {
        this.pivosSelecionados++;
        return pivoQuickSort(inicio, fim);
    }

    private void ordenaVetorQuickSort(int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = this.selecionarPivo(inicio, fim);
            this.ordenaVetorQuickSort(inicio, posicaoPivo - 1);
            this.ordenaVetorQuickSort(posicaoPivo + 1, fim);
        }
    }

    private int pivoQuickSort(int inicio, int fim) {
        int pivo = super.getItem(inicio);
        int i = inicio + 1;
        int f = fim;

        while (i <= f) {
            super.comparacoes++;
            if (super.getItem(i) <= pivo) {
                i++;
            } else if (super.getItem(f) > pivo) {
                f--;
            } else {
                int swap = super.getItem(i);
                super.setItem(f, swap);
                i++;
                f--;
            }
        }
        super.setItem(inicio, super.getItem(f));
        super.setItem(f, pivo);
        return f;
    }

}
