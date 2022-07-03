package ro.fasttrackit.hotel.server.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.hotel.server.model.RoomDTO;
import ro.fasttrackit.hotel.server.model.RoomFilter;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoomDAO {

    private final EntityManager entityManager;

    public List<RoomDTO> findByCriteriaBuilder(RoomFilter filter){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RoomDTO> criteria = criteriaBuilder.createQuery(RoomDTO.class);
        Root<RoomDTO> root = criteria.from(RoomDTO.class);
        CriteriaQuery<RoomDTO> query = criteria.select(root);
        List<Predicate> whereConditions = filterToCondition(criteriaBuilder, root, filter);
        query.where(whereConditions.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }

    private List<Predicate> filterToCondition(CriteriaBuilder criteriaBuilder, Root<RoomDTO> root, RoomFilter filter) {
        List<Predicate> predicates = new ArrayList<>();
        Optional.ofNullable(filter.hotel())
                .map(hotelName -> criteriaBuilder.like(root.get("hotelName"),"%" + hotelName + "%"))
                .ifPresent(predicates::add);
        Optional.ofNullable(filter.number())
                .map(hotelName -> criteriaBuilder.equal(root.get("number"),filter.number()))
                .ifPresent(predicates::add);
        Optional.ofNullable(filter.number())
                .map(hotelName -> criteriaBuilder.equal(root.get("floor"),filter.floor()))
                .ifPresent(predicates::add);
        return predicates;
    }
}
