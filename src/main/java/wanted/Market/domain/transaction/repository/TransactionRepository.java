package wanted.Market.domain.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wanted.Market.domain.product.entity.ProductStatus;
import wanted.Market.domain.transaction.dto.TransactionDto;
import wanted.Market.domain.transaction.entity.Transaction;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT new wanted.Market.domain.transaction.dto.TransactionDto(t.id, t.buyerName, t.status, p.id) " +
        "FROM Transaction t JOIN t.product p " +
        "WHERE t.buyerName = :buyerName AND t.status = :status")
    Optional<List<TransactionDto>> findByBuyerNameAndStatus(@Param("buyerName") String buyerName, @Param("status") boolean status);

    @Query("SELECT new wanted.Market.domain.transaction.dto.TransactionDto(t.id, t.buyerName, t.status, p.id) " +
        "FROM Transaction t JOIN t.product p " +
        "WHERE p.sellerIdentifier = :sellerName AND t.status = :status")
    Optional<List<TransactionDto>> findByProductSellerIdentifierAndStatus(@Param("sellerName") String sellerName, @Param("status") boolean status);

    @Query("SELECT new wanted.Market.domain.transaction.dto.TransactionDto(t.id, t.buyerName, t.status, p.id) " +
        "FROM Transaction t JOIN t.product p " +
        "WHERE p.id = :productId")
    Optional<List<TransactionDto>> findByProductId(@Param("productId") long productId);
}
