package com.demo.serverreload.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GasolController {

    @GetMapping("/cargar")
    //Declaro mi valor a recibir
    public String cargarCombustible(@RequestParam double galones)
    {
        //Creo mis 2 variables a utilizar
        /*Una para poder hacer la conversion
          y la otra para guardar el resultado.*/
        double litros = 3.78541;
        double equivaleEnLitros;

        //Transformo galones a litros
        equivaleEnLitros = galones * litros;

        //retorno el resultado!
        return "El equivalente de "+galones+" galones a litros es: "
                +equivaleEnLitros+" Litros.";
    }



}