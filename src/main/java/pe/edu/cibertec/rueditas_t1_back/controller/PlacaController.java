package pe.edu.cibertec.rueditas_t1_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_t1_back.dto.PlacaRequestDTO;
import pe.edu.cibertec.rueditas_t1_back.dto.PlacaResponseDTO;
import pe.edu.cibertec.rueditas_t1_back.service.PlacaService;

@RestController
@RequestMapping("/placa")
public class PlacaController {

    @Autowired
    PlacaService placaService;

    @PostMapping("/buscar")
    public PlacaResponseDTO buscar(@RequestBody PlacaRequestDTO placaRequestDTO){
        try {
            String[] datosVehiculo = placaService.buscarPlaca(placaRequestDTO);
            if (datosVehiculo == null) {
                return new PlacaResponseDTO("01", "Error:  Placa no encontrada", "", "", "", "","");
            }
            return new PlacaResponseDTO("00", "",
                    datosVehiculo[2],
                    datosVehiculo[3],
                    datosVehiculo[4],
                    datosVehiculo[5],
                    datosVehiculo[6]
            );

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new PlacaResponseDTO("99", "Error: Ocurrió un problema al leer el archivo", "", "", "", "","");

        }
    }
}
