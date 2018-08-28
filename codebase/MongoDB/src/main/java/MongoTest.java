import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoTest {
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	DB database = mongoClient.getDB("tds");
	DBCollection collection = database.getCollection("emp");
	
	
	public  void insert() {
		BasicDBObject doc1 = new BasicDBObject();
		doc1.put("name", "Dharmendra");
		 collection.insert(doc1);
	}
	

}
