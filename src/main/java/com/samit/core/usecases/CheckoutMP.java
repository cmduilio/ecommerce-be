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
            MercadoPago.SDK.setAccessToken("TEST-4206604904984989-091112-35090848ecc48c9cb487ded383ce2e33__LB_LD__-52967229");
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
