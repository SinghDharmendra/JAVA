package mongo.dao;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;

import mongo.entity.User;
import mongo.util.JsonUtil;

@RequestScoped
public class MongoDS {

	@Inject
	MongoConnection connection;

	public void insert(User user) {
		DBCollection collection = connection.getConnection().getCollection("emp");
		BasicDBObject doc1 = new BasicDBObject();
		doc1.put("id", user.getId());
		doc1.put("name", user.getName());
		doc1.put("email", user.getEmail());
		collection.insert(doc1);
	}

	public List<User> getUsers() {
		List<User> list = new LinkedList<>();
		DBCollection collection = connection.getConnection().getCollection("emp");
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			String name = (String) dbObject.get("name");
			String email = (String) dbObject.get("email");
			User u = new User(name, email);
			u.setId((String) dbObject.get("id"));
			list.add(u);
		}
		System.out.println(list);
		return list;
	}

}
