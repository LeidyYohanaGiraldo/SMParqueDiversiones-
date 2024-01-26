package com.salitreMagico.SM_Parque_De_Diversiones.repository;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Cliente;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmpleadoRepository extends JpaRepository <Empleado, Long> {

    @Query(value = "SELECT rol_empleado_id_rol\n" +
            "FROM empleado\n" +
            "WHERE empleado_numero_documento = :documento ", nativeQuery = true)
    public  Object consultarDocumento(@Param("documento") String documento);

    @Query(value = "SELECT *\n" +
            "FROM empleado\n" +
            "WHERE empleado_numero_documento = :documento ", nativeQuery = true)
    public Empleado findByNumeroDocumento(@Param("documento") String numeroDocumento);
}
