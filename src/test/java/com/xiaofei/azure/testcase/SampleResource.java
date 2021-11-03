package com.xiaofei.azure.testcase;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaofeicao
 * @createdAt 2021-11-02 17:11
 */
@JsonFlatten
@Fluent
public class SampleResource {

    @JsonProperty(value = "properties.name")
    private String namePropertiesName;

    @JsonProperty(value = "properties.registrationTtl")
    private String registrationTtl;

    public SampleResource withNamePropertiesName(String namePropertiesName){
        this.namePropertiesName = namePropertiesName;
        return this;
    }

    public SampleResource withRegistrationTtl(String registrationTtl){
        this.registrationTtl = registrationTtl;
        return this;
    }

    public String getNamePropertiesName() {
        return namePropertiesName;
    }

    public String getRegistrationTtl() {
        return registrationTtl;
    }
}
