package fa.dfa;

import fa.State;

import java.util.HashMap;

/**
 * Represents a State for a Deterministic Finite Automata (DFA),
 * and manages transitions to other States.
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
     * DFAState on a particular symbol. The transition
     * is not set if the state to transition to is null.
     *
     * @param toState The state to transition to.
     * @param onSymb The symbol to transition on.
     */
    public void setTransition(DFAState toState, char onSymb) {
        if (toState == null) { // Avoid putting null values
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
     * Swaps two transition labels for this DFAState. That is,
     * transitions to another DFAState on symb1 will be
     * changed to symb2, and vice versa.
     *
     * @param symb1 the first symbol.
     * @param symb2 the second symbol.
     */
    protected void swapTransitions(char symb1, char symb2) {
        if (!transitions.containsKey(symb1) || !transitions.containsKey(symb2)) {
            return;
        }
        DFAState firstState = getTransitionState(symb1);
        DFAState secondState = getTransitionState(symb2);

        setTransition(firstState, symb2);
        setTransition(secondState, symb1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(DFAState o) {
        return this.getName().compareTo(o.getName());
    }
}
