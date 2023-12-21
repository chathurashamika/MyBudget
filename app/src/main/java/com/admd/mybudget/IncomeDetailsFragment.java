package com.admd.mybudget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.google.firebase.firestore.DocumentSnapshot;

public class IncomeDetailsFragment extends DialogFragment {

    private DocumentSnapshot documentSnapshot;

    public IncomeDetailsFragment(DocumentSnapshot documentSnapshot) {
        this.documentSnapshot = documentSnapshot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income_details, container, false);

        TextView detailsTextView = view.findViewById(R.id.detailsTextView);
        Button editButton = view.findViewById(R.id.editButton);
        Button deleteButton = view.findViewById(R.id.deleteButton);
        // Extract details from the DocumentSnapshot
        String amount = documentSnapshot.getString("amount");
        String dateTime = documentSnapshot.getString("date_time");
        String description = documentSnapshot.getString("description");
        String incomeType = documentSnapshot.getString("income_type");

        // Display details in the TextView
        String incomeDetails =
                "Income Type: " + incomeType + "\n"
                + "LKR: " + amount + "\n"
                +"Date: " + dateTime + "\n"
                + "Description: " + description+"\n\n";

        detailsTextView.setText(incomeDetails);

        // Set click listeners for buttons
        editButton.setOnClickListener(v -> {
            // Handle edit button click
            // Implement your edit logic here
            // You can pass income details to the edit screen (documentSnapshot)
            dismiss(); // Close the dialog after clicking edit
        });

        deleteButton.setOnClickListener(v -> {
            // Handle delete button click
            // Implement your delete logic here
            // You can use documentSnapshot.getId() to get the document ID for deletion
            dismiss(); // Close the dialog after clicking delete
        });

        return view;
    }
}
