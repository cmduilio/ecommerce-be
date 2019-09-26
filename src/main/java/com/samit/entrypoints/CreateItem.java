package com.samit.entrypoints;

import com.google.inject.Inject;
import com.samit.core.entities.Item;
import com.samit.core.usecases.SaveItem;
import com.samit.entrypoints.validators.CreateItemValidator;
import com.samit.utils.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateItem implements Route {

    private CreateItemValidator createItemValidator;
    private SaveItem saveItem;

    @Inject
    public CreateItem(CreateItemValidator createItemValidator, SaveItem saveItem){
        this.createItemValidator = createItemValidator;
        this.saveItem = saveItem;
    }

    @Override
    public Object handle(Request request, Response response) {
        Item item = (Item) JsonUtils.fromJson(request.body(), Item.class);

        this.createItemValidator.validate(item);

        this.saveItem.run(item);

        return item;
    }
}