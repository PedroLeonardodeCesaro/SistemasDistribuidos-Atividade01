package principal;


/*
"Maçãs foi usado como exemplo para mostrar a troca do objeto entre o produtor e consumidor"
*/

public class Dados {
    private int quantidade;
    private boolean consumidorNotificou;

    public Dados() {
        quantidade = 0;
        consumidorNotificou = false;
    }

    public synchronized void adicionar() throws InterruptedException {
        while (quantidade > 0 && !consumidorNotificou) {
            wait(); // Aguarda até que o consumidor notifique que consumiu uma maçã
        }
        quantidade++;
        System.out.println("Produtor adicionou um Dado. Total: " + quantidade);
        consumidorNotificou = false; // Reinicia a flag de notificação do consumidor
        notify(); // Notifica o consumidor que uma maçã foi adicionada
    }

    public synchronized void consumir() throws InterruptedException {
        while (quantidade == 0) {
            wait(); // Aguarda até que haja pelo menos uma maçã para consumir
        }
        quantidade--;
        System.out.println("Consumidor consumiu um Dado. Total: " + quantidade);
        consumidorNotificou = true; // Sinaliza ao produtor que o consumidor consumiu uma maçã
        notify(); // Notifica o produtor que uma maçã foi consumida
    }
}
