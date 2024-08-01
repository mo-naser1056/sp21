package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {

    // Define the keyboard layout
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    // Array to hold GuitarString objects
    private static final GuitarString[] strings = new GuitarString[KEYBOARD.length()];

    public static void main(String[] args) {
        // Initialize GuitarString objects for each key
        for (int i = 0; i < KEYBOARD.length(); i++) {
            // Calculate the frequency for the i-th key
            double frequency = 440 * Math.pow(2, (i - 24) / 12.0);
            strings[i] = new GuitarString(frequency);
        }

        while (true) {
            // Check if a key has been typed
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);

                if (index != -1) {
                    // Pluck the corresponding GuitarString
                    strings[index].pluck();
                }
            }

            // Compute the superposition of samples
            double sample = 0.0;
            for (GuitarString string : strings) {
                sample += string.sample();
            }

            // Play the sample on standard audio
            StdAudio.play(sample);

            // Advance the simulation of each guitar string by one step
            for (GuitarString string : strings) {
                string.tic();
            }
        }
    }
}
