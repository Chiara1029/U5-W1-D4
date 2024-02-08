package it.chiarapuleio.exercise.restaurant.dao;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperMenuDAO extends JpaRepository<SuperMenu, Long> {
}
