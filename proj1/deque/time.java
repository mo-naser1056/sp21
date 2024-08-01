package deque;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayDeque;

/**
 * Created by hug.
 */
public class time {
    private static void printTimingTable(deque.ArrayDeque<Integer> Ns, deque.ArrayDeque<Double> times, deque.ArrayDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }
    public static void main(String[] args) {
        timeAListConstruction();

    }

    public static void timeAListConstruction() {
        deque.ArrayDeque<Integer> Ns = new deque.ArrayDeque<>();
        deque.ArrayDeque<Double> times = new deque.ArrayDeque<>();
        deque.ArrayDeque<Integer> opCounts = new deque.ArrayDeque<>();

        Stopwatch stopwatch = new Stopwatch();

        // Sample code to simulate timing data (replace with actual timing logic)
        for (int i = 0; i <= 8; i++) {
            int N = (int)Math.pow(2 ,i) * 1000;

            // Simulate AList construction
            ArrayDeque<Integer> list = new ArrayDeque<>();
            for (int k = 0; k < N; k++) {
                list.addLast(k);
            }

            double timeInSeconds = stopwatch.elapsedTime();
            int ops = N; // Assuming one operation per addLast call

            Ns.addLast(N);
            times.addLast(timeInSeconds);
            opCounts.addLast(ops);
        }

        printTimingTable(Ns, times, opCounts);
    }
}

