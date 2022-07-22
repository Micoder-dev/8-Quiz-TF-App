package com.example.quiztruefalseapp.view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiztruefalseapp.R;

public class FilmViewHolder extends RecyclerView.ViewHolder {

    private TextView txtFilmQuestion;
    private ImageButton imgButtonTrue, imgButtonFalse;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);

        txtFilmQuestion = itemView.findViewById(R.id.film_question_text);
        imgButtonTrue = itemView.findViewById(R.id.trueButton);
        imgButtonFalse = itemView.findViewById(R.id.falseButton);

    }

    public TextView getTxtFilmQuestion() {
        return txtFilmQuestion;
    }

    public ImageButton getImgButtonTrue() {
        return imgButtonTrue;
    }

    public ImageButton getImgButtonFalse() {
        return imgButtonFalse;
    }
}
