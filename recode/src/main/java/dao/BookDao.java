package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Book;
import entity.Type;
@Repository
public interface BookDao {
	
	@Select("select count(1) from  Book   ${where}")
	public  Integer getCount(@Param("where") String where);
	
		@Select("select Book.*,type.name typename from  Book inner join type on book.typeid=type.id   ${where}  ${limit}")
		public  List<Book> getWhere(@Param("where") String where,@Param("limit") String limit);

		@Select("select Book.* from  Book ")
		public  List<Book> getAll();

		@Select("select Book.* from Book  where id=#{id}")
		public  Book getByid(@Param("id")Integer id);

		@Delete("delete from Book where id=#{id}")
		public Integer delete(@Param("id")Integer id);

		 @Insert("insert into Book (name,sex,typeid) values(#{name},#{sex},#{typeid})")
		 public Integer insert(Book t);

		 @Update("update Book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id}")
		 public Integer update(Book t);

	}

