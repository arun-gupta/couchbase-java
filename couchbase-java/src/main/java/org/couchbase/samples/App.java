package org.couchbase.samples;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        CouchbaseCluster cluster = CouchbaseCluster.create();
        Bucket bucket = cluster.openBucket("books");

        JsonObject jsonObject = JsonObject.create();
        jsonObject.put("isbn", "978-1-4919-1889-0");
        jsonObject.put("name", "Minecraft Modding with Forge");
        jsonObject.put("cost", "29.99");
        JsonDocument document = JsonDocument.create("minecraft", jsonObject);
        bucket.upsert(document);

        JsonDocument output = bucket.get("minecraft");
        System.out.println(output.content());
    }
}
