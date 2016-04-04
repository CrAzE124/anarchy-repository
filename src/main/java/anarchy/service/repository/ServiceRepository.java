package anarchy.service.repository;

import anarchy.service.model.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created on 03 April 2016 @ 2:15 PM
 * Component for project "service-repository"
 *
 * @author Thomas Bezuidenhout
 */
@Repository
public class ServiceRepository {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addService(ServiceModel model) {
        redisTemplate.opsForSet().add(model.getKey(), model.getServiceDefinition());
    }

    public String getService(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    public void removeService(ServiceModel model) {
        redisTemplate.opsForSet().remove(model.getKey(), model.getServiceDefinition());
    }

    public void removeEntireServiceSet(String key) {
        redisTemplate.delete(key);
    }
}
