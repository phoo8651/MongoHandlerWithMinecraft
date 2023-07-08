package net.rorum.MongoHandlerWithMinecraft;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class MongoHandler {

    private final HashMap<String, MongoConnector> mongoClients = new HashMap<>();

    public void createMongoConnection(String mongoUri, String mongoDatabaseName, String mongoCollectionName) {
        MongoConnector MC = new MongoConnector(mongoUri, mongoDatabaseName, mongoCollectionName);
        mongoClients.put(mongoCollectionName, MC);
    }

    public void MongoReConnect(String mongoCollectionName) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MC.MongoReConnect();
    }

    public boolean isDocumentExistById(String mongoCollectionName, String id) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MongoCollection<Document> collection = MC.getCollection();
        Document document = collection.find(new Document("_id", id)).first();
        return document != null;
    }

    public boolean isDocumentExistByFieldName(String mongoCollectionName, String FieldName, String name) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MongoCollection<Document> collection = MC.getCollection();
        Document document = collection.find(new Document(FieldName, name)).first();
        return document != null;
    }

    public Double getDocumentDataByDouble(String mongoCollectionName, String id, String fieldName) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MongoCollection<Document> collection = MC.getCollection();
        Document document = collection.find(new Document("_id", id)).first();
        return Objects.requireNonNull(document).getDouble(fieldName);
    }

    public String getDocumentDataByString(String mongoCollectionName, String id, String fieldName) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MongoCollection<Document> collection = MC.getCollection();
        Document document = collection.find(new Document("_id", id)).first();
        return Objects.requireNonNull(document).getString(fieldName);
    }

    public boolean getDocumentDataByBoolean(String mongoCollectionName, String id, String fieldName) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MongoCollection<Document> collection = MC.getCollection();
        Document document = collection.find(new Document("_id", id)).first();
        return Objects.requireNonNull(document).getBoolean(fieldName);
    }


    public int getDocumentDataByInt(String mongoCollectionName, String id, String fieldName) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MongoCollection<Document> collection = MC.getCollection();
        Document document = collection.find(new Document("_id", id)).first();
        return Objects.requireNonNull(document).getInteger(fieldName);
    }

    public Date getDocumentDataByDate(String mongoCollectionName, String id, String fieldName) {
        MongoConnector MC = mongoClients.get(mongoCollectionName);
        MongoCollection<Document> collection = MC.getCollection();
        Document document = collection.find(new Document("_id", id)).first();
        return Objects.requireNonNull(document).getDate(fieldName);
    }

}
