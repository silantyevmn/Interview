package silantyevmn.ru.developerinterview.lesson3;

import android.support.annotation.NonNull;

import java.util.Iterator;

public class DirectedList {
    private DoubleList<Integer> doubleList;

    public DirectedList() {
        this.doubleList = new DoubleList<>();
        init();
    }

    public void init() {
        doubleList.addNext(0);
        doubleList.addPrev(-1);
        doubleList.addNext(1);
        doubleList.addNext(2);
        doubleList.addPrev(-2);
        doubleList.addPrev(-3);
        doubleList.addNext(3);
    }

    public String getStringList() {
        StringBuilder builder=new StringBuilder();
        builder.append("[");
        for (Integer integer : doubleList) {
            builder.append(integer);
            builder.append(",");
        }
        builder.delete(builder.lastIndexOf(","),builder.lastIndexOf(",")+1); //удаляем последнюю запятую.
        builder.append("]");
        return builder.toString();
    }


    class DoubleList<T> implements Iterable<T> {
        private Node<T> first;
        private Node<T> last;
        private int counter = 0;

        @NonNull
        @Override
        public Iterator<T> iterator() {
            return new DoubleIterator<>(first, counter);
        }

        public void addNext(T element) {
            if (counter == 0) {
                first = new Node<>(element);
                last = first;
            } else {
                last.addNext(element);
                last.next.prev = last;
                last = last.next;
            }
            counter++;
        }

        public void addPrev(T element) {
            if (counter == 0) {
                first = new Node<>(element);
                last = first;
            } else {
                first.addPrev(element);
                first.prev.next = first;
                first = first.prev;
            }
            counter++;
        }

        private class Node<T> {
            private T element;
            private Node<T> next;
            private Node<T> prev;

            private Node() {
            }

            public Node(T element) {
                this.element = element;
            }

            public void set(T element) {
                this.element = element;
            }

            public void addNext(T element) {
                if (isNext()) {
                    next.addNext(element);
                } else {
                    next = new Node<>(element);
                }
            }

            public void addPrev(T element) {
                if (isPrev()) {
                    prev.addPrev(element);
                } else {
                    prev = new Node<>(element);
                }
            }

            public T get() {
                return element;
            }

            private boolean isNext() {
                return next != null;
            }

            private boolean isPrev() {
                return prev != null;
            }
        }

        private class DoubleIterator<T> implements Iterator<T> {
            private Node<T> node;
            private int counter;
            private boolean isFirst = true;

            private DoubleIterator() {
            }

            public DoubleIterator(Node<T> node, int counter) {
                this.node = node;
                this.counter = counter;
            }

            @Override
            public boolean hasNext() {
                return counter == 1 && isFirst || node.isNext();
            }

            @Override
            public T next() {
                if (isFirst) isFirst = false;
                else node = node.next;
                return node.get();
            }
        }
    }

}
