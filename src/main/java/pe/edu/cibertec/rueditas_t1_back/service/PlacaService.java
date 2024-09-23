package pe.edu.cibertec.rueditas_t1_back.service;

import pe.edu.cibertec.rueditas_t1_back.dto.PlacaRequestDTO;

import java.io.IOException;

public interface PlacaService {

    String[] buscarPlaca(PlacaRequestDTO placaRequestDTO) throws IOException;
}
