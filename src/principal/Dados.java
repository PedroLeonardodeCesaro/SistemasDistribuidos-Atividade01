package principal;


public class Dados {
    private int quantidade;
    private boolean consumidorNotificou;

    public Dados() {
        quantidade = 0;
        consumidorNotificou = false;
    }

    public synchronized void adicionar() throws InterruptedException {
        while (quantidade > 0 && !consumidorNotificou) {
            wait();
        }
        quantidade++;
        System.out.println("Produtor adicionou um Dado. Total: " + quantidade);
        consumidorNotificou = false;
        notify();
    }

    public synchronized void consumir() throws InterruptedException {
        while (quantidade == 0) {
            wait();
        }
        quantidade--;
        System.out.println("Consumidor consumiu um Dado. Total: " + quantidade);
        consumidorNotificou = true;
        notify();
    }
}
