package com.example.touki.calculator;

/**
 * Created by touki on 7/26/2017.
 */

public class History {
    private int _id;
    private String _history;

    public History()
    {

    }

    public History(String history) {
        this._history = history;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_history(String _history) {
        this._history = _history;
    }

    public int get_id() {
        return _id;
    }

    public String get_history() {
        return _history;
    }
}
