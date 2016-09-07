package com.example.a1333539.loancalculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double amount;
    double interest;
    int years;

    private EditText amountEdit;
    private EditText interestEdit;
    private EditText yearsEdit;

    private TextView totalText = (TextView) findViewById(R.id.totaltxt);
    private TextView yearsRateText = (TextView) findViewById(R.id.interesttxt);;
    private TextView monthlyText = (TextView) findViewById(R.id.monthlytxt);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view)
    {
        amountEdit = (EditText) findViewById(R.id.amountedit);
        interestEdit = (EditText) findViewById(R.id.rateedit);
        yearsEdit = (EditText) findViewById(R.id.yearsedit);

        amount = Double.parseDouble(amountEdit.getText().toString());
        interest = Double.parseDouble(interestEdit.getText().toString());
        years = Integer.parseInt(yearsEdit.getText().toString());

        LoanCalculator loan = new LoanCalculator(amount, years, interest);

        double monthlyPayment = loan.getMonthlyPayment();
        double totalLoan = loan.getLoanAmount();
        double totalInterest = loan.getYearlyInterestRate() * 12;

        totalText.setText(Double.toString(monthlyPayment));
        yearsRateText.setText(Double.toString(totalInterest));
        monthlyText.setText(Double.toString(monthlyPayment));
    }

    public void clear(View view)
    {
        amountEdit = (EditText) findViewById(R.id.amountedit);
        interestEdit = (EditText) findViewById(R.id.rateedit);
        yearsEdit = (EditText) findViewById(R.id.yearsedit);

        amountEdit.setText("");
        interestEdit.setText("");
        yearsEdit.setText("");
    }
}
