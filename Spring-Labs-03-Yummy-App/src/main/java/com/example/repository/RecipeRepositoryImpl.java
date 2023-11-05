package com.example.repository;

import com.example.entity.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeRepositoryImpl implements RecipeRepository {

    public List<Recipe> recipeList = new ArrayList<>();

    @Override
    public boolean save(Recipe recipe) {
        return recipeList.add(recipe);
    }
}
