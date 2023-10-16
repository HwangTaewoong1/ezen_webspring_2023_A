package ezenweb.model.repository;

import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {
   MemberEntity findIdByMnameAndMphone(String mname, String mphone);
   MemberEntity findPwByMemailAndMphone(String memail, String mphone);
   MemberEntity findByMemailAndMpassword(String memail, String mpassword);
}
