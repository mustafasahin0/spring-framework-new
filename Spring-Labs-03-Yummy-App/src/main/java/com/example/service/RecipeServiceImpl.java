package com.example.service;

import com.example.enums.QuantityType;
import com.example.enums.RecipeType;
import com.example.entity.Ingredient;
import com.example.entity.Recipe;
import com.example.repository.RecipeRepository;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private  final ShareService shareService;
    private final Faker faker;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
    }

    @Override
    public boolean prepareRecipe() {
        Recipe recipe = Recipe.builder().recipeType(RecipeType.APPETIZER).id(faker.idNumber().hashCode()).duration(faker.duration().hashCode()).name(faker.food().dish()).ingredientList(List.of(Ingredient.builder().name(faker.food().ingredient()).quantityType(QuantityType.TBSP).quantity(faker.hashCode()).build())).build();
        recipeRepository.save(recipe);
        shareService.share();
        return true;
    }
}
