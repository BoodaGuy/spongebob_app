package com.example.spongebobcharacters;

import android.content.Context;

import java.util.ArrayList;

public class CharactersData {

    private String[] characterNames;
    private String[] characterDescription_2;
    private String[] characterDescription_3;

    public String[] getCharacterNames() {
        return characterNames;
    }

    public String[] getCharacterDescription_2() {
        return characterDescription_2;
    }

    public String[] getCharacterDescription_3() {
        return characterDescription_3;
    }

    public int[] getCharactersImages() {
        return charactersImages;
    }

    public ArrayList<Characters> getCharacters() {
        return characters;
    }

    private int[] charactersImages;

    private ArrayList<Characters> characters;

    public CharactersData(Context context)
    {
           this.characterNames = context.getResources().getStringArray(R.array.characters_names);
           this.characterDescription_2 = context.getResources().getStringArray(R.array.characters_descriptions_2);
           this.characterDescription_3 = context.getResources().getStringArray(R.array.characters_descriptions_3);
           this.charactersImages = new int[]{
                   R.drawable.spongebob, R.drawable.petric, R.drawable.squiduid, R.drawable.sendy, R.drawable.mr_krab, R.drawable.gerry, R.drawable.lerry
                   , R.drawable.sea_man, R.drawable.naar_haple, R.drawable.prle, R.drawable.plankton
           };
           characters = new ArrayList();

        for (int index = 0; index < characterNames.length; index++) {
            characters.add(new Characters(
                    charactersImages[index],
                    characterNames[index].toString(),
                    characterDescription_2[index].toString()));
        }
    }



}
