package principal;

public class Consumidor implements Runnable {
    private Dados dados;
    private int tempo;

    public Consumidor(Dados dados) {
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
                dados.consumir();
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