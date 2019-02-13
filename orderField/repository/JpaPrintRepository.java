package com.printhouse.orderField.repository;

import com.printhouse.orderField.domain.print.Print;
import com.printhouse.orderField.domain.print.PrintRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPrintRepository extends GenericJpaRepository<Print> implements PrintRepository {

}
