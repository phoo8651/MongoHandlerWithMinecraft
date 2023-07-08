package net.rorum.MongoHandlerWithMinecraft;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

class MongoConnector {
    private final String mongoUri;
    private final String mongoDatabaseName;
    private final String mongoCollectionName;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    protected MongoConnector(String mongoUri, String mongoDatabaseName, String mongoCollectionName) {
        this.mongoUri = mongoUri;
        this.mongoDatabaseName = mongoDatabaseName;
        this.mongoCollectionName = mongoCollectionName;
        try {
            this.mongoClient = MongoClients.create(mongoUri);
            this.mongoDatabase = mongoClient.getDatabase(mongoDatabaseName);
            this.collection = mongoDatabase.getCollection(mongoCollectionName);
            System.out.println("Success to connect to MongoDB<" + mongoCollectionName + ">");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to MongoDB<" + mongoCollectionName + ">");
        }
    }

    protected void MongoReConnect() {
        mongoClient.close();
        try {
            mongoClient = MongoClients.create(mongoUri);
            mongoDatabase = mongoClient.getDatabase(mongoDatabaseName);
            collection = mongoDatabase.getCollection(mongoCollectionName);
            System.out.println("Success to connect to MongoDB<" + mongoCollectionName + ">");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to MongoDB<" + mongoCollectionName + ">");
        }
    }

    protected MongoCollection<Document> getCollection() {
        collection = mongoDatabase.getCollection(mongoCollectionName);
        return collection;
    }
}

