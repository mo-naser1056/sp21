package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
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
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        Stopwatch stopwatch = new Stopwatch();

        // Sample code to simulate timing data (replace with actual timing logic)
        for (int i = 0; i <= 7; i++) {
            int N = (int)Math.pow(2 ,i) * 1000;

            // Simulate AList construction
            AList<Integer> list = new AList<>();
            for (int j = 0; j < N; j++) {
                list.addLast(j);
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
