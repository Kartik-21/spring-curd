package com.kartik.curd.repository;

import com.kartik.curd.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    //Distinct
    //SELECT distinct * FROM COMPANY where first_name = 'a'
    /// createDate and updatedDate different
    List<Company> findDistinctByFirstName(String name);

    //And
    //SELECT * FROM company where first_name ='a' and last_name = 'a'
    List<Company> findByFirstNameAndLastName(String firstName,String lastName);

    //Or
    //SELECT * FROM company where first_name ='a' or last_name = 'a'
    List<Company> findByFirstNameOrLastName(String firstName,String lastName);

    //Is, Equals
    //SELECT * FROM company where first_name ='a'
    List<Company> findByFirstName(String firstName);
    List<Company> findByFirstNameIs(String firstName);
    List<Company> findByFirstNameEquals(String firstName);

    //Between
    //SELECT * FROM company where rank between 1 and 10
    List<Company> findByCompanyRankBetween(int start, int end);

    //OrderBy
    //SELECT * FROM company where rank between 1 and 10 order by rank desc
    List<Company> findByCompanyRankBetweenOrderByCompanyRankDesc(int start, int end);


    //LessThan
    //LessThanEqual
    //GreaterThan
    //GreaterThanEqual
    //SELECT * FROM curd.company where company_rank<10;
    List<Company> findByCompanyRankLessThanEqual(int rank);


    //IsNotNull, NotNull
    //IsNull, Null
    List<Company> findByCompanyAddressIsNull();
    List<Company> findByCompanyAddressIsNotNull();



    //Like (match exact same word)
    //SELECT * FROM curd.company where company_name like 'AXZ';
    //SELECT * FROM curd.company where company_name not like 'AXZ';
    List<Company> findByCompanyNameLike(String name);
    List<Company> findByCompanyNameNotLike(String name);


    //StartingWith('a%')
    //EndingWith('%b')
    //Containing('%b%')
    //SELECT * FROM curd.company where company_name not like 'AXZ';
    List<Company> findByCompanyNameStartingWith(String name);
    List<Company> findByCompanyNameEndingWith(String name);
    List<Company> findByCompanyNameContaining(String name);

    //Not
    List<Company> findByCompanyNameNot(String name);

    //NotIn
    //In
    List<Company> findByCompanyNameIn(List<? extends String> list);
    List<Company> findByCompanyNameNotIn(List<? super String> list);

    //True False (only for boolean variables)
    //findByActiveTrue();

    //IgnoreCase
    //findByFirstnameIgnoreCase(String name);

//---------------------------------------------------------------------------

//    @Query("select u from User u where u.emailAddress = ?1")
//    User findByEmailAddress(String emailAddress);

    //  @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
    //  User findByEmailAddress(String emailAddress);
}
