class Principal {
    public static void main(String [] args){
        Pilha<Object> pTest = new Pilha<Object>();
        pTest.push('a', 2, 1.4, "[.toString() makes this possible]");

        Pilha<Object> p = new Pilha<Object>();
        p.push(10, "frase", 30, 21, 20, pTest, 121.1, 'z');

        p.printPilha();
    }
}