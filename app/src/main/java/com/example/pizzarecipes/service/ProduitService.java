package com.example.pizzarecipes.service;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed(); // préremplissage
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {

        data.add(new Produit(
                "BARBECUED CHICKEN PIZZA",
                3.0,
                R.mipmap.pizza1,
                "35 min",
                "- 2 boneless skinless chicken breast halves (6 ounces each)\n- 1/4 teaspoon pepper\n- 1 cup barbecue sauce, divided\n- 1 tube (13.8 ounces) refrigerated pizza crust\n- 2 teaspoons olive oil\n- 2 cups shredded Gouda cheese\n- 1 small red onion, halved and thinly sliced\n- 1/4 cup minced fresh cilantro",
                "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor.",
                "STEP 1:\nSprinkle chicken with pepper and grill.\nSTEP 2:\nPrepare crust and add toppings.\nSTEP 3:\nGrill until cheese melts."
        ));

        data.add(new Produit(
                "BRUSCHETTA PIZZA",
                5.0,
                R.mipmap.pizza2,
                "35 min",
                "- Sausage, pepperoni, mozzarella, tomatoes, basil, garlic, thyme...",
                "A very flavorful Italian-style pizza loaded with tomatoes and herbs.",
                "STEP 1:\nBake crust with meat and cheese.\nSTEP 2:\nAdd bruschetta mixture on top."
        ));

        data.add(new Produit(
                "SPINACH PIZZA",
                2.0,
                R.mipmap.pizza3,
                "25 min",
                "- Alfredo sauce, spinach, chopped tomatoes, Italian cheese blend.",
                "A creamy, veggie-packed pizza that is super easy to make.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nSpread Alfredo, add veggies.\nSTEP 3:\nBake until golden."
        ));

        data.add(new Produit(
                "DEEP-DISH SAUSAGE PIZZA",
                8.0,
                R.mipmap.pizza4,
                "45 min",
                "- Yeast dough, onions, peppers, sausage, tomatoes, cheese...",
                "A hearty, thick deep-dish pizza inspired by grandma’s recipe.",
                "STEP 1:\nPrepare dough and spread in skillet.\nSTEP 2:\nLayer vegetables, sausage, cheese.\nSTEP 3:\nBake until deep golden."
        ));

        data.add(new Produit(
                "HOMEMADE PIZZA",
                4.0,
                R.mipmap.pizza5,
                "50 min",
                "- Homemade dough, tomato sauce, ground beef, vegetables, cheese...",
                "A classic homemade pizza with a crispy crust and hearty toppings.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nCook beef and veggies.\nSTEP 3:\nAssemble and bake."
        ));

        data.add(new Produit(
                "PESTO CHICKEN PIZZA",
                3.0,
                R.mipmap.pizza6,
                "50 min",
                "- Pesto, chicken, peppers, mushrooms, cheese, homemade dough...",
                "A flavorful pizza where pesto brings out the freshness of veggies.",
                "STEP 1:\nMake dough.\nSTEP 2:\nCook chicken and veggies.\nSTEP 3:\nSpread pesto, add toppings.\nSTEP 4:\nBake until golden."
        ));

        data.add(new Produit(
                "LOADED MEXICAN PIZZA",
                3.0,
                R.mipmap.pizza7,
                "30 min",
                "- Black beans, chili powder, tomatoes, jalapeño, spinach...",
                "A spicy and colorful pizza packed with Mexican flavors.",
                "STEP 1:\nPrepare bean mixture.\nSTEP 2:\nAdd tomato mix and toppings.\nSTEP 3:\nBake."
        ));

        data.add(new Produit(
                "BACON CHEESEBURGER PIZZA",
                2.0,
                R.mipmap.pizza8,
                "20 min",
                "- Beef, onion, bacon, pickles, mozzarella, cheddar...",
                "A fun mix between a cheeseburger and a pizza — perfect for kids.",
                "STEP 1:\nCook beef.\nSTEP 2:\nAssemble pizza.\nSTEP 3:\nBake until cheese melts."
        ));

        data.add(new Produit(
                "PIZZA MARGHERITA",
                1.0,
                R.mipmap.pizza9,
                "30 min",
                "- Tomatoes, basil, mozzarella, dough, olive oil...",
                "A classic Italian Pizza Margherita with fresh and simple flavors.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nAdd tomato and basil.\nSTEP 3:\nBake until golden."
        ));

        data.add(new Produit(
                "PEPPERONI-SAUSAGE STUFFED PIZZA",
                5.0,
                R.mipmap.pizza10,
                "45 min",
                "- Sausage, pepperoni, mushrooms, cheese, pizza sauce, dough...",
                "A fully stuffed pizza packed with layers of meat and cheese.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nLayer cheese and meats.\nSTEP 3:\nSeal, top and bake."
        ));
    }


    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(x -> x.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) if (p.getId() == id) return p;
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}