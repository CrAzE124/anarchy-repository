package za.co.tifu.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import za.co.tifu.model.ServiceModel;
import za.co.tifu.repository.ServiceRepository;

/**
 * Created on 03 April 2016 @ 1:58 PM
 * Component for project "service-repository"
 *
 * @author Thomas Bezuidenhout
 */
@RestController
public class ServiceController {
    private static final Log log = LogFactory.getLog(ServiceController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ServiceRepository repository;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ServiceModel registerService(
            @RequestBody ServiceModel serviceModel
    ) {
        log.debug(environment.getProperty("spring.redis.host"));

        repository.addService(serviceModel);

        return serviceModel;
    }

    @RequestMapping(path = "/find")
    public String findService(
            @RequestParam(value = "key") String key
    ) {
        return repository.getService(key);
    }

    @RequestMapping(path = "/remove", method = RequestMethod.DELETE)
    public String removeService(
            @RequestBody ServiceModel model
    ) {
        repository.removeService(model);

        return "Service \"" + model.getServiceName() + "\" at key \"" + model.getKey() + "\" removed";
    }

    @RequestMapping(path = "/remove-all")
    public String removeAllServices(
            @RequestParam(value = "key") String key
    ) {
        repository.removeEntireServiceSet(key);

        return "All services at key \"" + key + "\" removed";
    }
}
