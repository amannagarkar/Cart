package com.example.cart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.NumberPicker;
import android.widget.Toast;

public class DialogBox extends DialogFragment {
    private NumberPicker.OnValueChangeListener valueChangeListener;
    private int qty;
    private int id;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final NumberPicker numberPicker = new NumberPicker(getActivity());

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(60);
        numberPicker.setValue(qty);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Value");
        builder.setMessage("Choose a number :");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //valueChangeListener.onValueChange(numberPicker,
                   //     numberPicker.getValue(), numberPicker.getValue());
                Toast.makeText(getContext(),String.valueOf(numberPicker.getValue()),Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).doPositiveClick(id,numberPicker.getValue());
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //valueChangeListener.onValueChange(numberPicker,
                      //  numberPicker.getValue(), numberPicker.getValue());
                dismiss();
            }
        });

        builder.setView(numberPicker);
        return builder.create();
    }

    public NumberPicker.OnValueChangeListener getValueChangeListener() {
        return valueChangeListener;
    }

    public void set(int id,int qty)
    {
        this.id=id;
        this.qty=qty;
    }

    public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }
}
