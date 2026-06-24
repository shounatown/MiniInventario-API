package com.ipn.mx.miniinventario.features.categoria.repository;

import com.ipn.mx.miniinventario.core.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaDAO extends JpaRepository<Categoria, Long> {

    @Modifying // Indica que es una consulta que altera datos (DML)
    @Query("DELETE FROM Categoria c WHERE c.idCategoria = :id")
    void eliminarDirectoPorId(@Param("id") Long id);
}
