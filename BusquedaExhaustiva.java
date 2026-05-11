import java.util.*;

public class BusquedaExhaustiva {
    static final int TARGET_H = 4;
    static final int TARGET_THETA = 0;
    static final int MIN_H = -10;
    static final int MAX_H = 10;
    static final int DELTA_H = 1;
    static final int DELTA_THETA = 5;

    static class State {
        final int h;
        final int theta;

        State(int h, int theta) {
            this.h = h;
            this.theta = theta;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return h == state.h && theta == state.theta;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h, theta);
        }

        @Override
        public String toString() {
            return String.format("(H=%d, θ=%d°)", h, theta);
        }
    }

    static class Node {
        final State state;
        final Node parent;
        final String action;

        Node(State state, Node parent, String action) {
            this.state = state;
            this.parent = parent;
            this.action = action;
        }
    }

    private static boolean isGoal(State s) {
        return s.h == TARGET_H && s.theta == TARGET_THETA;
    }

    private static List<Node> expand(Node node) {
        List<Node> children = new ArrayList<>();
        State s = node.state;

        if (s.h + DELTA_H <= MAX_H) {
            children.add(new Node(new State(s.h + DELTA_H, s.theta), node, "Avanzar +" + DELTA_H));
        }
        if (s.h - DELTA_H >= MIN_H) {
            children.add(new Node(new State(s.h - DELTA_H, s.theta), node, "Avanzar -" + DELTA_H));
        }
        if (s.theta + DELTA_THETA <= 180) {
            children.add(new Node(new State(s.h, s.theta + DELTA_THETA), node, "Rotar +" + DELTA_THETA + "°"));
        }
        if (s.theta - DELTA_THETA >= -180) {
            children.add(new Node(new State(s.h, s.theta - DELTA_THETA), node, "Rotar -" + DELTA_THETA + "°"));
        }

        return children;
    }

    public static List<Node> breadthFirstSearch(State start) {
        Queue<Node> frontier = new LinkedList<>();
        Set<State> explored = new HashSet<>();

        frontier.add(new Node(start, null, "Inicio"));
        explored.add(start);

        while (!frontier.isEmpty()) {
            Node node = frontier.poll();
            if (isGoal(node.state)) {
                return buildPath(node);
            }
            for (Node child : expand(node)) {
                if (!explored.contains(child.state)) {
                    explored.add(child.state);
                    frontier.add(child);
                }
            }
        }
        return Collections.emptyList();
    }

    private static List<Node> buildPath(Node goal) {
        LinkedList<Node> path = new LinkedList<>();
        Node current = goal;
        while (current != null) {
            path.addFirst(current);
            current = current.parent;
        }
        return path;
    }

    public static void main(String[] args) {
        State start = new State(0, 10);
        State target = new State(TARGET_H, TARGET_THETA);

        System.out.println("=== Búsqueda exhaustiva ===");
        System.out.println("Estado inicial: " + start);
        System.out.println("Meta: " + target);
        System.out.println("Método: búsqueda en anchura (BFS), explorando ambos sentidos y rotación.");

        List<Node> path = breadthFirstSearch(start);
        if (path.isEmpty()) {
            System.out.println("No se encontró solución.");
            return;
        }

        System.out.println("Camino encontrado con " + (path.size() - 1) + " movimientos:");
        for (int i = 0; i < path.size(); i++) {
            Node node = path.get(i);
            System.out.printf("%2d. %s -> %s\n", i, node.action, node.state);
        }
    }
}
