import java.util.EmptyStackException;
import java.util.Optional;

public class Pilha<Tipo> {
    private static final int TAM_MAX = 1000;
    private Tipo valores[];
    private int topo = -1;

    public Pilha() {
        this.valores = (Tipo[]) new Object[TAM_MAX];
    }

    public boolean empty() {
        return this.topo == -1;
    }

    public boolean full() {
        return this.topo == TAM_MAX - 1;
    }

    public void push(Tipo... valores) {
        for (Tipo valor : valores) {
            if (!full()) {
                this.valores[++topo] = valor;
            } else {
                System.out.println("A pilha está cheia!");
            }
        }
    }

    public void pushPilha(Pilha<Tipo> p) {
        while (!p.empty() && !this.full()) {
            this.push(p.pop().orElse(null)); // handling empty stack in push
        }
    }

    public Optional<Tipo> pop() {
        if (this.empty()) {
            System.out.println("A pilha está vazia!");
            return Optional.empty();
        } else {
            return Optional.of(this.valores[topo--]);
        }
    }

    public void pop(int quantPop) {
        if (this.empty()) {
            System.out.println("A pilha está vazia!");
            return;
        }
        if (quantPop > this.topo) {
            quantPop = this.topo + 1;
        }
        for (int i = 0; i < quantPop; i++) {
            this.pop();
        }
    }

    public Optional<Tipo> top() {
        if (this.empty()) {
            System.out.println("A pilha está vazia!");
            return Optional.empty();
        } else {
            return Optional.of(this.valores[topo]);
        }
    }

    public void printPilha() {
        if (this.empty()) {
            System.out.println("A pilha está vazia!");
        } else {
            System.out.println("Imprimindo Pilha:");
            for (int i = 0; i <= this.topo; i++) {
                System.out.println(" " + this.valores[i]);
            }
        }
    }

    public String toString() {
        String pilhaStr = ":";
        if (!this.empty()) {
            for (int i = 0; i <= topo; i++) {
                pilhaStr += " " + this.valores[i];
            }
        }
        return this.getClass().getName() + pilhaStr;
    }
}
