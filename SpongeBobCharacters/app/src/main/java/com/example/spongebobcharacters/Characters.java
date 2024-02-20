package com.example.spongebobcharacters;

public class Characters {

   private int characterImage;
    private String characterName;
    private String CharacterDescription;

    public int getCharacterImage() {
        return characterImage;
    }

    public void setCharacterImage(int characterImage) {
        this.characterImage = characterImage;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterDescription() {
        return CharacterDescription;
    }

    public void setCharacterDescription(String characterDescription) {
        this.CharacterDescription = characterDescription;
    }

    public Characters(int characterImage, String characterName, String characterDescription) {
        this.characterImage = characterImage;
        this.characterName = characterName;
        this.CharacterDescription = characterDescription;
    }
}
