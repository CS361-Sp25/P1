package fa.dfa;

import fa.State;

import java.util.Set;

/**
 * TODO Docs
 */
public class DFA implements DFAInterface {

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
     * {@inheritDoc}
     */
    @Override
    public boolean addState(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setFinal(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setStart(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSigma(char symbol) {

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
