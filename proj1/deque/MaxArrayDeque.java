package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> comp;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comp = c;
    }

    public T max() {
       return max(comp);
    }
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        int maxi = 0;
        for (int i = 0; i < this.size(); i++) {
            if (c.compare(this.get(maxi), this.get(i)) < 0) {
                maxi = i;
            }
        }
        return this.get(maxi);
    }
}
