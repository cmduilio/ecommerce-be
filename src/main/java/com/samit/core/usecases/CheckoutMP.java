package com.samit.core.usecases;

import javax.inject.Inject;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;

import java.time.LocalDateTime;

public class CheckoutMP {

    @Inject
    public CheckoutMP(){
        try {
            MercadoPago.SDK.setAccessToken("APP_USR-3786479503513650-072917-96c99c40e4d0b4c7c7b91b3f5c710318-230142422");
        } catch (MPConfException e) {
            e.printStackTrace();
        }
    }

    public String run(){
        // Crea un objeto de preferencia
        String dateCreated = LocalDateTime.now().toString();

        Preference preference = new Preference();

        // Crea un ítem en la preferencia
        Item item = new Item();
        item.setTitle("Mi producto")
                .setQuantity(1)
                .setUnitPrice((float) 75.56);
        preference.appendItem(item);

        Payer payer = new Payer();
        payer.setName("Charles")
                .setSurname("Luevano")
                .setEmail("charles@hotmail.com")
                .setDateCreated(dateCreated);
/*                .setPhone(new Phone()
                        .setAreaCode("")
                        .setPhoneNumber("949 128 866"))
                .setIdentification(new Identification()
                        .setType("DNI")
                        .setNumber("12345678"))
                .setAddress(new Address()
                        .setStreetName("Cuesta Miguel Armendáriz")
                        .setBuildingNumber("1004")
                        .setZipCode("11020"));
*/
        preference.setPayer(payer);
        try{
            preference.save();
        }catch (MPException ex){
            throw new RuntimeException();
        }

        return preference.getInitPoint();
    }
}
