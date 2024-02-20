package com.example.spongebobcharacters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.MyViewHolder> {

    private ArrayList<Characters> characters;
    private OnSelectedCharacter listener;



    public CharactersAdapter(ArrayList<Characters> characters , OnSelectedCharacter listener)
    {
        this.characters = characters;
        this.listener = listener;
    }

    public void updateFilterList(ArrayList<Characters> filteredList) {
        characters = filteredList;
        notifyDataSetChanged();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView characterName;
        TextView characterDes;
        ImageView characterImage;

        //this is the components in the card of character
        public MyViewHolder(@NonNull View itemView,OnSelectedCharacter listener,ArrayList<Characters> characters) {
            super(itemView);
            characterName = itemView.findViewById(R.id.char_name);
            characterDes = itemView.findViewById(R.id.char_des);
            characterImage = itemView.findViewById(R.id.char_image);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (listener != null){
                         Characters character = characters.get(getAdapterPosition());
                         if (getAdapterPosition() != RecyclerView.NO_POSITION){
                             listener.onClickedChar(character);
                         }
                     }
                 }
             });
        }
    }

    @NonNull
    @Override//this is the create of the inner card in the recycle view
    public CharactersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,listener,characters);

        return myViewHolder;
    }

    @Override//this is the loop in the recycle view for each item
    public void onBindViewHolder(@NonNull CharactersAdapter.MyViewHolder holder, int position) {
        holder.characterName.setText(characters.get(position).getCharacterName());
        holder.characterDes.setText(characters.get(position).getCharacterDescription());
        holder.characterImage.setImageResource(characters.get(position).getCharacterImage());

    }


    @Override
    public int getItemCount()
    {
        return characters.size();
    }
}
