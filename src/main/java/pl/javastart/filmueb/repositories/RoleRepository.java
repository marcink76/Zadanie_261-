package pl.javastart.filmueb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.filmueb.model.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {
        UserRole findByUsername (String username);
}
