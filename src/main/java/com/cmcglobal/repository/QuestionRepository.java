package com.cmcglobal.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cmcglobal.entity.Question;
import org.springframework.data.repository.query.Param;
@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
	List<Question>  findByContentContaining(String contentSearch, Pageable pageable);
//			+ "q.category_id= :categoryID AND q.level_id = :levelID AND q.type_id = :typeID AND q.user_id_created = :userIdCreated AND q.date_created = :dateCreated AND q.tag_id = :tagID")
//	List<Question>  filterByAllAttribute(@Param("categoryID") Integer categoryID, 
//			@Param("levelID") Integer levelID, @Param("typeID") Integer typeID,  @Param("userIdCreated") Integer userIdCreated,
//			@Param("dateCreated") Date dateCreated, @Param("tagID") Integer tagID );
	
//	@Query("select q from Question q where "
//			+ "q.questionCategory.id = ?1 or q.questionLevel.id = ?2 or q.questionType.id = ?3 or q.userQuestion.id = ?4 or q.dateCreated = ?5 or q.questionTag.id = ?6")
//	List<Question>  filterByOneAttribute(Integer categoryID, 
//			Integer levelID, Integer typeID,  Integer userIdCreated,
//		Date dateCreated, Integer tagID );
//	
//	@Query("select q from Question q where "
//			+ "q.questionCategory.id = ?1 and q.questionLevel.id = ?2 and q.questionType.id = ?3 and q.userQuestion.id = ?4 and q.dateCreated = ?5 and q.questionTag.id = ?6")
//	List<Question>  filterByAllAttribute(Integer categoryID, 
//			Integer levelID, Integer typeID,  Integer userIdCreated,
//		Date dateCreated, Integer tagID );
//	
	@Query("select q from Question q where q.questionCategory.categoryName like ?1  or q.questionLevel.levelName like ?2 "
			+ "or q.questionType.typeName like ?3 or q.userQuestion.fullName like ?4 or q.dateCreated = ?5 or q.questionTag.tagName like ?6" )
	List<Question>  filterByTestString(String categoryName, String levelName, String typeName, 
			String fullName,  Date dateCreated, String tagName, Pageable pageable );
//	@Query(value="update question set category_id=?1, level_id=?2, tag_id=?3 where question_id=?4", nativeQuery=true)
//	void updateMultiQuestion(String category_id, String typeName, String level_id, String tag_id, String question_id);
	@Query("SELECT q FROM Question q")
	List<Question> pageQuestion(Pageable pageable);
}
