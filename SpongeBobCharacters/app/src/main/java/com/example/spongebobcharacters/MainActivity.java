package com.example.spongebobcharacters;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements OnSelectedCharacter{

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CharactersAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharactersData charactersData = new CharactersData(this);

        recyclerView = findViewById(R.id.characters_list);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CharactersAdapter(charactersData.getCharacters(),this::onClickedChar);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        TextInputEditText searchCharacterEditText = findViewById(R.id.search_char);
        searchCharacterEditText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        filter(s.toString(),charactersData);
                    }
                }
        );
    }

        private void filter(String userInput,CharactersData charactersData)
        {
            ArrayList<Characters> filteredList = new ArrayList<>();
            for (Characters character :charactersData.getCharacters() ) {
                if (character.getCharacterName().contains(userInput)) {
                    filteredList.add(character);
                }
            }
            adapter.updateFilterList(filteredList);
            adapter = new CharactersAdapter(filteredList,this::onClickedChar);
            recyclerView.setAdapter(adapter);
        }

    @Override
    public void onClickedChar(Characters character) {
        ImageView imageView;
        TextView textViewName,textViewDes;
        Dialog characterDescriptionDialog = new Dialog(this);
        characterDescriptionDialog.setContentView(R.layout.character_description);
        imageView = characterDescriptionDialog.findViewById(R.id.image_char);
        textViewName = characterDescriptionDialog.findViewById(R.id.name_char);
        textViewDes = characterDescriptionDialog.findViewById(R.id.desc_char);

        imageView.setImageResource(character.getCharacterImage());
        textViewName.setText(character.getCharacterName());
        textViewDes.setText(character.getCharacterDescription());

        characterDescriptionDialog.show();
    }
}