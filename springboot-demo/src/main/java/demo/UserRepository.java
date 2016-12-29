package demo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by daijiajia on 2016/12/12.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

}
