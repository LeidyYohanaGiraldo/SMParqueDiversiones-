package com.salitreMagico.SM_Parque_De_Diversiones.repository;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT *\n" +
            "FROM cliente\n" +
            "WHERE pers_numero_documento = :documento ", nativeQuery = true)
    Cliente findByNumeroDocumento(@Param("documento") String numeroDocumento);
    @Query(value = "SELECT pers_numero_documento\n" +
            "FROM cliente\n" +
            "WHERE pers_numero_documento = :documento ", nativeQuery = true)
    public  Object consultarDocumento(@Param("documento") String documento);
}
