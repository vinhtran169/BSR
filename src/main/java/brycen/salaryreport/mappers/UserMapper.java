package brycen.salaryreport.mappers;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import brycen.salaryreport.model.User;

public interface UserMapper {
	@Select("SELECT * FROM user WHERE username = #{username}")
	public User getUserByUserName(String username);
	@Insert("INSERT INTO user(username, password, email) VALUE (#{username}, #{password}, #{email})")
	@Options(useGeneratedKeys = true, keyProperty="id", flushCache = true, keyColumn ="id")
	public void insertUser(User user);
	@Select("SELECT * FROM user")
	public List<User> getAllUser();
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User getUserByID(Long id);
	@Update("UPDATE user SET USERNAME = #{username}, PASSWORD = #{password}, EMAIL = #{email} WHERE ID=#{id}")
	public void updateUser(User user);
	@Delete("DELETE FROM user WHERE ID=#{id}")
	public void deleteUser(User user);
}
