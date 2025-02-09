package fa.dfa;

import fa.State;

import java.util.HashMap;

/**
 * Represents a state for a Deterministic Finite Automata (DFA)
 *
 * @author Jayce Lowry
 */
public class DFAState extends State implements Comparable<DFAState> {
    private HashMap<Character, DFAState> transitions;

    /**
     * Creates a new DFAState.
     *
     * @param name the name of this DFAState.
     */
    public DFAState(String name) {
        super(name);
        transitions = new HashMap<>();
    }

    /**
     * Sets this DFAState to transition to another
     * DFAState on a particular symbol.
     *
     * @param toState The state to transition to.
     * @param onSymb The symbol to transition on.
     */
    public void setTransition(DFAState toState, char onSymb) {
        if (toState == null) {
            return;
        }
        transitions.put(onSymb, toState);
    }

    /**
     * Gets the DFAState this DFAState transitions to
     * on a particular symbol.
     *
     * @param onSymb The symbol this DFAState transitions on.
     * @return The state this DFAState transitions to, or null
     * if this DFAState doesn't have a transition on the specified
     * symbol.
     */
    public DFAState getTransitionState(char onSymb) {
        return transitions.get(onSymb);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(DFAState o) {
        return this.getName().compareTo(o.getName());
    }
}
