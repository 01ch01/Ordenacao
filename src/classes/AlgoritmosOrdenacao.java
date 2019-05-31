/**
 * Super classe abstrata criada para calculo de tempo, implementação dos acessos
 * e do próprio vetor.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Apr 30, 2019 at 9:10:04 PM
 * @version 0.1
 */
package classes;

public abstract class AlgoritmosOrdenacao {

    private int acessos = 0;
    protected int trocas = 0;
    protected int comparacoes = 0;
    private int[] vetor;
    private boolean vetorOrdenado = false;
    protected long tempoTotal = 0;

    public AlgoritmosOrdenacao(int[] vetor) {
        this.vetor = vetor.clone();
    }

    /**
     * Retorna o elemento do vetor de índice 'index'.
     *
     * @param index : o índice desejado.
     * @return : o inteiro em si;
     */
    protected int getItem(int index) {
        this.acessos++;
        return this.vetor[index];
    }

    protected void setItem(int index, int item) {
        this.vetor[index] = item;
        this.trocas++;
    }

    public int getAcessos() {
        return acessos;
    }

    public void setAcessos(int acessos) {
        this.acessos = acessos;
    }

    public int getTrocas() {
        return trocas;
    }

    public void setTrocas(int trocas) {
        this.trocas = trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public boolean isVetorOrdenado() {
        return vetorOrdenado;
    }

    public void setVetorOrdenado(boolean vetorOrdenado) {
        this.vetorOrdenado = vetorOrdenado;
    }

    public long getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(long tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

}
