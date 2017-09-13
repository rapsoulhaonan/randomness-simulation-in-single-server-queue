import java.util.Random;

public class myRnd {
    // Linear congruential values for x(i+1) = (a * x(i)) % m.
    final static int a = 65539;
    final static long m = 2147483648L;

    // Current value for returning.
    long x;

    public myRnd() {
        x = (long) (Math.random() * (2147483648L - 1) + 1);
        if (x % 2 == 0)
            x = x + 1;
    }

    double next() {
        // Calculate next value in sequence.
        x = (a * x) % m;
        //System.out.print("\n" + x);
        // Return its 0-to-1 value.
        return (double)x / m;
    }

    public static void main(String[] args) {
        myRnd r;
        System.out.println("\nAll average waiting time");
        for (int round = 0; round < 10; round++)
        {
            r = new myRnd();
            double waiting_Queue = 0;
            double waiting_queue_Sum = 0;
            for (int i = 0; i < 1000000; i++) {
                double inter_arr_Time = -Math.log(r.next()); 
                double svc_Dur = 0.9;
                waiting_Queue = Math.max(0, waiting_Queue + svc_Dur - inter_arr_Time);  
                waiting_queue_Sum += waiting_Queue;
            }
            double avg_waiting_Queue = waiting_queue_Sum / 1000000;
            System.out.print("\n" + avg_waiting_Queue);
        }
    }   
}
