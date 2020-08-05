/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Book;

/**
 * @author gimanjun
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
