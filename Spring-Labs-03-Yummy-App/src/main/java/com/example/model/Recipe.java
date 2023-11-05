package com.example.model;

import com.example.enums.RecipeType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Recipe {
    private int id;
    private String name;
    private int duration;
    private List<Ingredient> ingredientList;
    private RecipeType recipeType;
}
