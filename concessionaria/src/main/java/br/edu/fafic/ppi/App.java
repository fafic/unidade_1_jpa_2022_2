package br.edu.fafic.ppi;

import br.edu.fafic.ppi.dao.AccessoryDAO;
import br.edu.fafic.ppi.dao.VehicleDAO;
import br.edu.fafic.ppi.domain.*;

import java.util.List;

public class App {

    public static void main(String[] args) {

        var acessoryDAO = new AccessoryDAO();
        var vehicleDAO = new VehicleDAO();


        //var acessory = Accessory.builder().name("GPS").price(200.0).build();
        var accessoryList = List.of(
                Accessory.builder().name("Multimedia").price(320.0).build(),
                Accessory.builder().name("Conditional Air").price(950.0).build()
        );

        var conditionalAir = acessoryDAO.findById(Accessory.class, 3l);
        var multimedia = acessoryDAO.findById(Accessory.class, 4l);

        var fordMustang =
                Vehicle.builder()
                        .mark("Ford")
                        .model("Mustang")
                        .value(150000.0)
                        .year(2020)
                        .accesories(List.of(conditionalAir, multimedia))
                        .build();

        var vehicle = vehicleDAO.findById(Vehicle.class, 1l);

         var carStore = CarStore.builder()
                 .address(Address.builder().city("Cajazeiras")
                         .district("Centro")
                         .number("120")
                         .street("Av. Major Jose Marques")
                         .build())
                 .contact(Contact.builder()
                         .email("minhaloja@gmail.com")
                         .phoneNumber("3531-3531")
                         .build())
                 .name("Super Car")
                 .vehicles(List.of(vehicle))
                 .build();


       // System.out.println("Salvando acessorio na base de dados...");
        //acessoryDAO.saveOrUpdate(acessory);
        //acessoryDAO.saveList(accessoryList);
       // vehicleDAO.saveOrUpdate(fordMustang);
        System.out.println("Operação realizada com sucesso!");

    }
}
