import java.util.PriorityQueue;

public class Printqueue<T> {
    private PriorityQueue<PrintTask<T>> queue;

    public Printqueue() {
        queue = new PriorityQueue<>();
    }

    public void offer(T item, int priority) {
        queue.offer(new PrintTask<>(item, priority));
    }

    public void print() {
        System.out.println("Polling from queue");
        while (!queue.isEmpty()) {
            PrintTask<T> task = queue.poll();
            System.out.println(task.getItem());
        }
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        Printqueue<Double> queue = new Printqueue<>();

        queue.offer(3.0, 2);
        queue.offer(9.0, 8);
        queue.offer(5.0, 4);
        queue.print();
    }

    private static class PrintTask<T> implements Comparable<PrintTask<T>> {
        private T item;
        private int priority;

        public PrintTask(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        @Override
        public int compareTo(PrintTask<T> other) {
            return Integer.compare(this.priority, other.priority);
        }
    }
}