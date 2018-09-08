package mongo.dao;

import javax.enterprise.context.RequestScoped;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@RequestScoped
public class MongoConnection {

	private MongoClient mongoClient = new MongoClient("localhost", 27017);
	private DB connection = mongoClient.getDB("tds");

	public DB getConnection() {
		return connection;
	}

}
