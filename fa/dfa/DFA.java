package fa.dfa;

import fa.State;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of a Deterministic Finite Automata (DFA).
 * 
 * @author Chase Stombaugh
 */
public class DFA implements DFAInterface {
    private Set<DFAState> states;
    private Set<Character> alphabet;
    private Map<String, Map<Character, String>> transitions; // (state, symbol) -> next state
    private DFAState startState;
    private Set<DFAState> finalStates;

    /*
     * Constructor for a new DFA, Initializes the alphabet, set of states, start state, final states,
     * and the transition map. The start state is set to null to start. 
     */
    public DFA() {
        this.alphabet = new LinkedHashSet<>();
        this.states = new LinkedHashSet<>();
        this.startState = null;
        this.finalStates = new LinkedHashSet<>();
        this.transitions = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        if (!alphabet.contains(onSymb) || getState(fromState) == null || getState(toState) == null) {
            return false;
        }
        transitions.get(fromState).put(onSymb, toState);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DFA swap(char symb1, char symb2) {
        DFA newDFA = new DFA();

        // Copy all states
        for (DFAState state : states) {
            newDFA.addState(state.getName());
        }

        // Copy start and final states
        newDFA.setStart(startState.getName());
        for (DFAState state : finalStates) {
            newDFA.setFinal(state.getName());
        }

        // Copy and swap transitions
        for (String state : transitions.keySet()) {
            for (Map.Entry<Character, String> entry : transitions.get(state).entrySet()) {
                char symbol = entry.getKey();
                String nextState = entry.getValue();

                // Swap the symbols
                if (symbol == symb1) {
                    symbol = symb2;
                } else if (symbol == symb2) {
                    symbol = symb1;
                }

                // Add the transition with the swapped symbol
                newDFA.addTransition(state, nextState, symbol);
            }
        }

        return newDFA;
    }


    /**
     * Adds a new state to the DFA. 
     * 
     * @param name - The name of the state
     * @return - True if the state was added successfully, False if the state existed perviously
     */
    @Override
    public boolean addState(String name) {
        if (getState(name) != null) {
            return false;
        }
        DFAState newState = new DFAState(name);
        states.add(newState);
        transitions.put(name, new HashMap<>());
        return true;
    }

    /**
     * Marks a state as a final state in the DFA.
     * 
     * @param name -The name of the state to be marked as final.
     * @return - True if the state was successfully marked as final, false if the state does not exist.
     */
    @Override
    public boolean setFinal(String name) {
        State state = getState(name); 
        if (state == null) return false;
        finalStates.add((DFAState) state);
        return true;
    }


    /**
     * Sets the start state of the DFA.
     * 
     * @param name - The name of the state to be set as the start state.
     * @return - True if the state was successfully set, false if the state does not exist.
     */
    @Override
    public boolean setStart(String name) {
        State state = getState(name);
        if (state == null) return false;
        this.startState = (DFAState) state;
        return true;
    }

    /**
     * Adds a symbol to the DFA's alphabet.
     * 
     * @param symbol - The symbol to be added to the alphabet.
     */
    @Override
    public void addSigma(char symbol) {
        alphabet.add(symbol);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean accepts(String s) {
        if (startState == null) return false; // No start state means no valid transitions

        DFAState currentState = startState; // Start from the initial state
        for (char c : s.toCharArray()) {
            if (!alphabet.contains(c)) return false; // Reject if character is not in Sigma
            if (!transitions.containsKey(currentState.getName()) || 
                !transitions.get(currentState.getName()).containsKey(c)) {
                return false; // Reject if no transition exists
            }
            // Move to the next state (cast is required)
            currentState = (DFAState) getState(transitions.get(currentState.getName()).get(c));
        }
        return finalStates.contains(currentState); // Correct final state check
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Character> getSigma() {
        return new LinkedHashSet<>(alphabet);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State getState(String name) {
        for (DFAState state : states) {
            if (state.getName().equals(name)) {
                return state;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFinal(String name) {
        return finalStates.contains(getState(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStart(String name) {
        return startState != null && startState.getName().equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Print states in the order they were added
        sb.append("Q = { ");
        for (DFAState state : states) {
            sb.append(state.getName()).append(" ");
        }
        sb.append("}\n");

        // Print Sigma (Alphabet) in the order they were added
        sb.append("Sigma = { ");
        for (char symbol : alphabet) {
            sb.append(symbol).append(" ");
        }
        sb.append("}\n");

        // Print transition table
        sb.append("delta =\n\t");
        for (char symbol : alphabet) {
            sb.append(symbol).append("\t");
        }
        sb.append("\n");

        for (DFAState state : states) {
            sb.append(state.getName()).append("\t");
            for (char symbol : alphabet) {
                String nextState = transitions.get(state.getName()).get(symbol);
                sb.append((nextState != null ? nextState : "-")).append("\t");
            }
            sb.append("\n");
        }

        // Print start state
        sb.append("q0 = ").append(startState != null ? startState.getName() : "-").append("\n");

        // Print final states
        sb.append("F = { ");
        for (DFAState state : finalStates) {
            sb.append(state.getName()).append(" ");
        }
        sb.append("}");

        return sb.toString();
    }

}
