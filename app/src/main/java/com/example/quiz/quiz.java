package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class quiz extends AppCompatActivity implements View.OnClickListener {

    private int mCurrentPosition = 1;
    private ArrayList<Questions> mQuestionsList = new ArrayList<Questions>();

    private int mSelectedOptionPosition = 0;
    private int mCorrectAnswers = 0;
    TextView tv_option_one,tv_option_two,tv_option_three,tv_option_four;
    Button btn_submit;
    ProgressBar progressBar;
    TextView tv_progress,tv_question;
    ImageView iv_image;
    Constants constants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestionsList = constants.getQuestions();  //new ArrayList<Questions>();
            setQuestion();

            tv_option_one.findViewById(R.id.tv_option_one);
            tv_option_two.findViewById(R.id.tv_option_two);
            tv_option_three.findViewById(R.id.tv_option_three);
            tv_option_four.findViewById(R.id.tv_option_four);
            btn_submit.findViewById(R.id.btn_submit);
            progressBar.findViewById(R.id.progressBar);
            tv_progress.findViewById(R.id.tv_progress);
            tv_question.findViewById(R.id.tv_question);
            iv_image.findViewById(R.id.iv_image);
            tv_option_one.setOnClickListener(this);
            tv_option_two.setOnClickListener(this);
            tv_option_three.setOnClickListener(this);
            tv_option_four.setOnClickListener(this);
            btn_submit.setOnClickListener(this);
        }

        /**
         * A function for setting the question to UI components.
         */
        private void setQuestion() {

            Questions question = mQuestionsList.get(mCurrentPosition - 1); // Getting the question from the list with the help of current position.
            defaultOptionsView();

            if (mCurrentPosition == mQuestionsList.size()) {
                btn_submit.setText("FINISH");
            } else {
                btn_submit.setText("SUBMIT");
            }

            progressBar.setProgress(mCurrentPosition);
            tv_progress.setText("$mCurrentPosition" + "/" + progressBar.getMax());

            tv_question.setText(question.question);
            iv_image.setImageResource(question.image);
            tv_option_one.setText(question.optionOne);
            tv_option_two.setText(question.optionTwo);
            tv_option_three.setText(question.optionThree);
            tv_option_four.setText(question.optionFour);
        }

        /**
         * A function to set the view of selected option view.
         */
        private void selectedOptionView(TextView tv, int selectedOptionNum) {

            defaultOptionsView();

            mSelectedOptionPosition = selectedOptionNum;

            tv.setTextColor(
                    Color.parseColor("#363A43")
            );
            tv.setBackground(ContextCompat.getDrawable(
                    this,
                    R.drawable.selected_option_border_bg
            ));
        }

        /**
         * A function to set default options view when the new question is loaded or when the answer is reselected.
         */
        private void defaultOptionsView() {

            ArrayList<TextView> options = new ArrayList<TextView>();
            options.add(0, tv_option_one);
            options.add(1, tv_option_two);
            options.add(2, tv_option_three);
            options.add(3, tv_option_four);

            for (TextView option : options) {
                option.setTextColor(Color.parseColor("#7A8089"));
                option.setTypeface(Typeface.DEFAULT);
                option.setBackground(ContextCompat.getDrawable(
                        this,
                R.drawable.default_option_border_bg));
            }
        }

        /**
         * A function for answer view which is used to highlight the answer is wrong or right.
         */
        private void answerView(int answer, int drawableView) {

            switch(answer) {

                case 1 :
                    {
                    tv_option_one.setBackground(ContextCompat.getDrawable(
                            this,
                        drawableView));
                }
                case 2 :
                    {
                    tv_option_two.setBackground(ContextCompat.getDrawable(
                            this,
                        drawableView));
                }
                case 3 : {
                    tv_option_three.setBackground(ContextCompat.getDrawable(
                            this,
                    drawableView));
                }
                case 4 : {
                    tv_option_four.setBackground(ContextCompat.getDrawable(
                            this,
                    drawableView));
                }
            }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {

            case R.id.tv_option_one :
                {
                selectedOptionView(tv_option_one, 1);
                break;
            }

            case R.id.tv_option_two :
                {

                selectedOptionView(tv_option_two, 2);
                break;
            }

            case R.id.tv_option_three :
                {
                selectedOptionView(tv_option_three, 3);
                break;
            }

            case R.id.tv_option_four :
                {
                selectedOptionView(tv_option_four, 4);
                break;
            }

            case R.id.btn_submit :

                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++;
                    if(mCurrentPosition <= mQuestionsList.size()){
                            setQuestion();
                        }
                        else {
                            /*Intent intent =
                                    new Intent(this, ResultActivity.java);
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers);
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList.size());
                            startActivity(intent);
                            finish();
                            // END*/
                        }
                    }
                 else {
                    Questions question = mQuestionsList.get(mCurrentPosition - 1);

                    // This is to check if the answer is wrong
                    if (question.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg);
                    }
                    else {
                        mCorrectAnswers++;
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg);

                    if (mCurrentPosition == mQuestionsList.size()) {
                        btn_submit.setText("FINISH");
                    } else {
                        btn_submit.setText("GO TO NEXT QUESTION");
                    }

                    mSelectedOptionPosition = 0;
                }
            }
        }

    }