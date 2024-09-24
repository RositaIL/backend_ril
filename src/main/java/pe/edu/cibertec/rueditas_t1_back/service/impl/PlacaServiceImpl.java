package pe.edu.cibertec.rueditas_t1_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_t1_back.dto.PlacaRequestDTO;
import pe.edu.cibertec.rueditas_t1_back.service.PlacaService;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class PlacaServiceImpl implements PlacaService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarPlaca(PlacaRequestDTO placaRequestDTO) throws IOException {

        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if(placaRequestDTO.nroPlaca().equals(datos[1])) {
                    datosVehiculo = datos;
                    break;
                }
            }

        } catch (IOException e){
            datosVehiculo = null;
            throw new IOException(e);

        }
        return datosVehiculo;
    }
}

