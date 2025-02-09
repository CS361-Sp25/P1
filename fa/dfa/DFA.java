package fa.dfa;

import fa.State;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of a Deterministic Finite Automata (DFA).
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
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DFA swap(char symb1, char symb2) {
        return null;
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
        DFAState state = getState(name);
        if (state == null) return false;
        finalStates.add(state);
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
        DFAState state = getState(name);
        if (state == null) return false;
        this.startState = state;
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
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Character> getSigma() {
        return Set.of();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State getState(String name) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFinal(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStart(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "";
    }
}
