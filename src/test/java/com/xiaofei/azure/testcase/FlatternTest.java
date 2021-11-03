package com.xiaofei.azure.testcase;

import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerEncoding;

import java.io.IOException;

/**
 * @author xiaofeicao
 * @createdAt 2021-11-03 14:05
 */
public class FlatternTest {

    public static void main(String[] args) throws IOException {

        SampleResource sampleResource = JacksonAdapter.createDefaultSerializerAdapter().deserialize(
                "{\"id\":\"/subscriptions/.../resourceGroups/nhbangbang/providers/Microsoft.NotificationHubs/namespaces/.../notificationHubs/...\",\"name\":\"...-01\",\"type\":\"Microsoft.NotificationHubs/namespaces/notificationHubs\",\"location\":\"East Asia\",\"tags\":{},\"properties\":{\"registrationTtl\":\"10675199.02:48:05.4775807\",\"authorizationRules\":[]}}"
                , SampleResource.class
                , SerializerEncoding.JSON
        ); //exception thrown
        System.out.println(sampleResource.getRegistrationTtl()); // can't reach here

    }

}
