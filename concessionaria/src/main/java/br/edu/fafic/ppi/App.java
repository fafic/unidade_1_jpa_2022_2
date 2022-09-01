package br.edu.fafic.ppi;

import br.edu.fafic.ppi.dao.AccessoryDAO;
import br.edu.fafic.ppi.dao.CarStoreDAO;
import br.edu.fafic.ppi.dao.OwnerDAO;
import br.edu.fafic.ppi.dao.VehicleDAO;
import br.edu.fafic.ppi.domain.*;

import java.util.List;

public class App {

    public static void main(String[] args) {

        var acessoryDAO = new AccessoryDAO();
        var vehicleDAO = new VehicleDAO();
        var ownerDAO = new OwnerDAO();
        var carStoreDAO = new CarStoreDAO();


        var acessory = Accessory.builder().name("GPS").price(200.0).build();
        var accessoryList = List.of(
                Accessory.builder().name("Multimedia").price(320.0).build(),
                Accessory.builder().name("Conditional Air").price(950.0).build()
        );

//        acessoryDAO.saveOrUpdate(acessory);
//        acessoryDAO.saveList(accessoryList);

        var conditionalAir = acessoryDAO.findById(Accessory.class, 3l);
        var multimedia = acessoryDAO.findById(Accessory.class, 2l);

        var fordMustang =
                Vehicle.builder()
                        .mark("Ford")
                        .model("Mustang")
                        .value(150000.0)
                        .year(2020)
                        .accesories(List.of(conditionalAir, multimedia))
                        .build();

        var ferrari = Vehicle.builder()
                .mark("Ferrari")
                .model("Ferrari F140")
                .value(2500000.0)
                .year(2022)
                .accesories(List.of(conditionalAir))
                .build();

        var bmw = Vehicle.builder()
                .mark("BWM")
                .model("X5")
                .year(2019)
                .value(350000.0)
                .accesories(List.of(multimedia))
                .build();

     //   vehicleDAO.saveList(List.of(fordMustang, ferrari, bmw));

           bmw = vehicleDAO.findById(Vehicle.class, 3l);
           ferrari = vehicleDAO.findById(Vehicle.class, 2l);
           fordMustang = vehicleDAO.findById(Vehicle.class, 1l);

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
                 .cnpj("123456")
                 .vehicles(List.of(fordMustang, bmw, ferrari))
                 .build();

     //    carStoreDAO.saveOrUpdate(carStore);

        //recuperando a loja da base de dados
        carStore = carStoreDAO.findById(CarStore.class, 1L);

        //vinculando os veiculos a loja
//        carStore.getVehicles().addAll(List.of(ferrari,bmw, fordMustang));
//        carStoreDAO.saveOrUpdate(carStore);
        //vinculando a loja para cada veiculo
//        ferrari.setOwner(carStore);
//        fordMustang.setOwner(carStore);
//        bmw.setOwner(carStore);

      //  vehicleDAO.saveList(List.of(fordMustang, ferrari, bmw));


        //cadastrando um cliente
//        var customer = Customer.builder()
//                .cpf("95959595")
//                .name("Jose da Silva")
//                .contact(Contact.builder()
//                        .phoneNumber("9999-9999")
//                        .email("jose@hotmail.com")
//                        .build())
//                .address(Address.builder()
//                        .street("Av Principal")
//                        .number("500-A")
//                        .district("Bairro Praia Mar")
//                        .city("Joao Pessoa")
//                        .build())
//                .build();

      //  ownerDAO.saveOrUpdate(customer);

        var jose = (Customer)ownerDAO.findById(Owner.class, 2l);

        carStore.getCustomers().add(jose);
        carStore.getVehicles().remove(bmw);
        carStoreDAO.saveOrUpdate(carStore);

        jose.getVehicles().add(bmw);
        ownerDAO.saveOrUpdate(jose);

        bmw.setOwner(jose);
        vehicleDAO.saveOrUpdate(bmw);

       // System.out.println("Salvando acessorio na base de dados...");
        //acessoryDAO.saveOrUpdate(acessory);
        //acessoryDAO.saveList(accessoryList);
       // vehicleDAO.saveOrUpdate(fordMustang);
        //ownerDAO.saveOrUpdate(carStore);
        //vehicleDAO.saveList(List.of(ferrari, bmw, fordMustang));
       // carStoreDAO.saveOrUpdate(carStore);
        //ownerDAO.saveOrUpdate(customer);

        System.out.println("Operação realizada com sucesso!");

    }
}
