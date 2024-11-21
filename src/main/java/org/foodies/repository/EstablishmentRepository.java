package org.foodies.repository;

import jakarta.transaction.Transactional;
import org.foodies.model.EstablishmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends JpaRepository<EstablishmentModel, Long> {

    @Modifying
    @Query(value = "INSERT INTO establishment (name, address, contact_info, latitude, longitude, google_place_id) " +
            "VALUES (:#{#model.name}, :#{#model.address}, :#{#model.contact_info}, :#{#model.latitude}, :#{#model.longitude}, :#{#model.google_place_id})", nativeQuery = true)
    void saveEstablishment(@Param("model") final EstablishmentModel model);

    @Query(value = "SELECT * FROM establishment e WHERE e.name LIKE %:name% LIMIT 20", nativeQuery = true)
    List<EstablishmentModel> findByName(@Param("name") String name);

    @Modifying
    @Query(value = "INSERT IGNORE INTO category (name) VALUES (:type)", nativeQuery = true)
    void saveCategory(@Param("type") String type);

    @Query(value = "SELECT id FROM category WHERE name = :category", nativeQuery = true)
    Integer getCategoryId(@Param("category") String category);

    @Modifying
    @Query(value = "INSERT INTO establishmentcategory (establishment_id, category_id) VALUES " +
            "(:establishment_id, :category_id)", nativeQuery = true)
    void saveEstablishmentCategory(@Param("establishment_id") Integer establishment_id, @Param("category_id") Integer category_id);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Integer getEstablishmentId(String name);
}