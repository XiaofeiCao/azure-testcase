package com.xiaofei.azure.testcase;

import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Assertions;

/**
 * @author xiaofeicao
 * @createdAt 2021-11-03 14:05
 */
public class FlatternTest {

    public static void main(String[] args) {

        // with misplaced 'name' property
        // throws exception
        Assertions.assertThrows(MismatchedInputException.class, () -> {
            SampleResource sampleResource = JacksonAdapter.createDefaultSerializerAdapter().deserialize(
                "{\"id\":\"/subscriptions/.../resourceGroups/nhbangbang/providers/Microsoft.NotificationHubs/namespaces/.../notificationHubs/...\",\"name\":\"...-01\",\"type\":\"Microsoft.NotificationHubs/namespaces/notificationHubs\",\"location\":\"East Asia\",\"tags\":{},\"properties\":{\"registrationTtl\":\"10675199.02:48:05.4775807\",\"authorizationRules\":[]}}"
                , SampleResource.class
                , SerializerEncoding.JSON
            ); //exception thrown
            System.out.printf("\"name\" property outside the bag, name: %s", sampleResource.getNamePropertiesName());
        });

        // with 'name' property removed
        // no exception thrown
        Assertions.assertDoesNotThrow(() -> {
            SampleResource sampleResource = JacksonAdapter.createDefaultSerializerAdapter().deserialize(
                "{\"id\":\"/subscriptions/.../resourceGroups/nhbangbang/providers/Microsoft.NotificationHubs/namespaces/.../notificationHubs/...\",\"type\":\"Microsoft.NotificationHubs/namespaces/notificationHubs\",\"location\":\"East Asia\",\"tags\":{},\"properties\":{\"registrationTtl\":\"10675199.02:48:05.4775807\",\"authorizationRules\":[]}}"
                , SampleResource.class
                , SerializerEncoding.JSON
            );
            System.out.printf("\"name\" property removed, name: %s\n", sampleResource.getNamePropertiesName());
        });

        // with 'name' property placed inside the 'properties' bag
        // no exception thrown, and 'name' property is correctly recognized
        Assertions.assertDoesNotThrow(() -> {
            SampleResource sampleResource = JacksonAdapter.createDefaultSerializerAdapter().deserialize(
                "{\"id\":\"/subscriptions/.../resourceGroups/nhbangbang/providers/Microsoft.NotificationHubs/namespaces/.../notificationHubs/...\",\"type\":\"Microsoft.NotificationHubs/namespaces/notificationHubs\",\"location\":\"East Asia\",\"tags\":{},\"properties\":{\"name\":\"...-01\", \"registrationTtl\":\"10675199.02:48:05.4775807\",\"authorizationRules\":[]}}"
                , SampleResource.class
                , SerializerEncoding.JSON
            );
            System.out.printf("\"name\" property inside the bag, name: %s\n", sampleResource.getNamePropertiesName());
        });


    }

}
