package com.chaudhry.najeeb.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    // Total scores
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulYellowTeamA = 0;
    int foulYellowTeamB = 0;
    int foulRedTeamA = 0;
    int foulRedTeamB = 0;

    //define instance variables for the widgets
    private Button penaltyKickPointsPlus3ForTeamA;
    private Button freeKickPointsPlus2ForTeamA;
    private Button throwInPointsPlus1ForTeamA;
    private Button goalKickPointsPlus1ForTeamA;
    private Button cornerKickPointsPlus1ForTeamA;
    private Button yellowCardPointsMinus2ForTeamA;
    private Button redCardPointsMinus3ForTeamA;

    private Button penaltyKickPointsPlus3ForTeamB;
    private Button freeKickPointsPlus2ForTeamB;
    private Button throwInPointsPlus1ForTeamB;
    private Button goalKickPointsPlus1ForTeamB;
    private Button cornerKickPointsPlus1ForTeamB;
    private Button yellowCardPointsMinus2ForTeamB;
    private Button redCardPointsMinus3ForTeamB;

    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the widgets
        // Team A
        penaltyKickPointsPlus3ForTeamA = (Button) findViewById (R.id.penaltyKickPointsPlus3ForTeamA);
        freeKickPointsPlus2ForTeamA = (Button) findViewById (R.id.freeKickPointsPlus2ForTeamA);
        throwInPointsPlus1ForTeamA = (Button) findViewById(R.id.throwInPointsPlus1ForTeamA);
        goalKickPointsPlus1ForTeamA = (Button) findViewById(R.id.goalKickPointsPlus1ForTeamA);
        cornerKickPointsPlus1ForTeamA = (Button) findViewById(R.id.cornerKickPointsPlus1ForTeamA);
        yellowCardPointsMinus2ForTeamA = (Button) findViewById(R.id.yellowCardPointsMinus2ForTeamA);
        redCardPointsMinus3ForTeamA = (Button) findViewById(R.id.redCardPointsMinus3ForTeamA);
        // Team B
        penaltyKickPointsPlus3ForTeamB = (Button) findViewById (R.id.penaltyKickPointsPlus3ForTeamB);
        freeKickPointsPlus2ForTeamB = (Button) findViewById (R.id.freeKickPointsPlus2ForTeamB);
        throwInPointsPlus1ForTeamB = (Button) findViewById(R.id.throwInPointsPlus1ForTeamB);
        goalKickPointsPlus1ForTeamB = (Button) findViewById(R.id.goalKickPointsPlus1ForTeamB);
        cornerKickPointsPlus1ForTeamB = (Button) findViewById(R.id.cornerKickPointsPlus1ForTeamB);
        yellowCardPointsMinus2ForTeamB = (Button) findViewById(R.id.yellowCardPointsMinus2ForTeamB);
        redCardPointsMinus3ForTeamB = (Button) findViewById(R.id.redCardPointsMinus3ForTeamB);
        // Reset button
        reset = (Button) findViewById(R.id.reset);

        // Set listeners
        // Team A
        penaltyKickPointsPlus3ForTeamA.setOnClickListener(this);
        freeKickPointsPlus2ForTeamA.setOnClickListener(this);
        throwInPointsPlus1ForTeamA.setOnClickListener(this);
        goalKickPointsPlus1ForTeamA.setOnClickListener(this);
        cornerKickPointsPlus1ForTeamA.setOnClickListener(this);
        yellowCardPointsMinus2ForTeamA.setOnClickListener(this);
        redCardPointsMinus3ForTeamA.setOnClickListener(this);
        // Team B
        penaltyKickPointsPlus3ForTeamB.setOnClickListener(this);
        freeKickPointsPlus2ForTeamB.setOnClickListener(this);
        throwInPointsPlus1ForTeamB.setOnClickListener(this);
        goalKickPointsPlus1ForTeamB.setOnClickListener(this);
        cornerKickPointsPlus1ForTeamB.setOnClickListener(this);
        yellowCardPointsMinus2ForTeamB.setOnClickListener(this);
        redCardPointsMinus3ForTeamB.setOnClickListener(this);
        // Reset button
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Team A
            case R.id.penaltyKickPointsPlus3ForTeamA:
                scoreTeamA += 3;
                displayScoreForTeamA(scoreTeamA);
                break;
            case R.id.freeKickPointsPlus2ForTeamA:
                scoreTeamA += 2;
                displayScoreForTeamA(scoreTeamA);
                break;
            case R.id.throwInPointsPlus1ForTeamA:
            case R.id.goalKickPointsPlus1ForTeamA:
            case R.id.cornerKickPointsPlus1ForTeamA:
                scoreTeamA += 1;
                displayScoreForTeamA(scoreTeamA);
                break;
            case R.id.yellowCardPointsMinus2ForTeamA:
                foulYellowTeamA++;
                displayFoulYellowForTeamA(foulYellowTeamA);
                break;
            case R.id.redCardPointsMinus3ForTeamA:
                foulRedTeamA++;
                displayFoulRedForTeamA(foulRedTeamA);
                break;
            // Team B
            case R.id.penaltyKickPointsPlus3ForTeamB:
                scoreTeamB += 3;
                displayScoreForTeamB(scoreTeamB);
                break;
            case R.id.freeKickPointsPlus2ForTeamB:
                scoreTeamB += 2;
                displayScoreForTeamB(scoreTeamB);
                break;
            case R.id.throwInPointsPlus1ForTeamB:
            case R.id.goalKickPointsPlus1ForTeamB:
            case R.id.cornerKickPointsPlus1ForTeamB:
                scoreTeamB += 1;
                displayScoreForTeamB(scoreTeamB);
                break;
            case R.id.yellowCardPointsMinus2ForTeamB:
                foulYellowTeamB++;
                displayFoulYellowForTeamB(foulYellowTeamB);
                break;
            case R.id.redCardPointsMinus3ForTeamB:
                foulRedTeamB++;
                displayFoulRedForTeamB(foulRedTeamB);
                break;
            // Reset button
            case R.id.reset:
                resetButton();
                break;
            default:
                // do nothing
                break;
        }
    }

    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulYellowForTeamA(int count) {
        TextView teamAFoulYellow = (TextView) findViewById(R.id.team_a_foul_yellow);
        teamAFoulYellow.setText(String.valueOf(count));
    }

    public void displayFoulYellowForTeamB(int count) {
        TextView teamBFoulYellow = (TextView) findViewById(R.id.team_b_foul_yellow);
        teamBFoulYellow.setText(String.valueOf(count));
    }

    public void displayFoulRedForTeamA(int count) {
        TextView teamAFoulRed = (TextView) findViewById(R.id.team_a_foul_red);
        teamAFoulRed.setText(String.valueOf(count));
    }

    public void displayFoulRedForTeamB(int count) {
        TextView teamBFoulRed = (TextView) findViewById(R.id.team_b_foul_red);
        teamBFoulRed.setText(String.valueOf(count));
    }

    public void resetButton() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulYellowTeamA = 0;
        foulYellowTeamB = 0;
        foulRedTeamA = 0;
        foulRedTeamB = 0;
        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayFoulYellowForTeamA(foulYellowTeamA);
        displayFoulYellowForTeamB(foulYellowTeamB);
        displayFoulRedForTeamA(foulRedTeamA);
        displayFoulRedForTeamB(foulRedTeamB);
    }
}
