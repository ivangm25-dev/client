package com.example.wimg.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuilderUtil<T> {
    @Autowired
    private ObjectMapper mapper;
    private Class<T> clazz;

    public void setClass(Class cls){
        this.clazz = cls;
    }

    /**
     * Build Object.
     * @param obj
     * @return <T>
     * @param <P>
     */
    public <P> T objectBuilder(P obj) {
        try {
            return (T) mapper.readValue(
                    mapper.writeValueAsString(obj), clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Build List Objects.
     * @param objectList
     * @return <T>
     * @param <P>
     */
    public <P> List<T> objectListBuilder(List<P> objectList) {
        List<T> responseListObjects = new ArrayList<>();
        objectList.forEach(aux -> {
            try {
                responseListObjects.add(mapper.readValue(
                        mapper.writeValueAsString(aux), clazz));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return responseListObjects;
    }
}
