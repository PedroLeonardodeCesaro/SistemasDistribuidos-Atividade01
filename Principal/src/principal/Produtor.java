package principal;

public class Produtor implements Runnable {
    private Dados dados;
    private int tempo;

    public Produtor(Dados dados) {
        this.dados = dados;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * getTempo()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                dados.adicionar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}