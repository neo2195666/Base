package MyLock;

//synchronized本质就是排队

public class MySynchronized {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread( ()->{for (int i = 0; i < 20; i++) ticket.sale();},"A").start();
        new Thread( ()->{for (int i = 0; i < 20; i++) ticket.sale();},"B").start();
        new Thread( ()->{for (int i = 0; i < 20; i++) ticket.sale();},"C").start();

    }
}


class Ticket{
    int ticket = 60;
    public synchronized void sale(){
        if(ticket > 0)
            System.out.println(Thread.currentThread().getName() + "卖了一张票，剩余" + ticket-- + "票");
    }
}