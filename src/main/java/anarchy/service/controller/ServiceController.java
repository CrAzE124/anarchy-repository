package anarchy.service.controller;

import anarchy.service.model.ServiceModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import anarchy.service.repository.ServiceRepository;

import javax.servlet.http.HttpServletRequest;

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
    private ServiceRepository repository;

    /**
     * Register a service
     * @param serviceModel ServiceModel
     * @param request HttpServletRequest
     * @return ServiceModel
     */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ServiceModel registerService(
            @RequestBody ServiceModel serviceModel,
            HttpServletRequest request
    ) {
        serviceModel.setRemoteAddress(request.getRemoteAddr());
        repository.addService(serviceModel);

        return serviceModel;
    }

    /**
     * Get any random service attached to {key}
     * @param key String
     * @return String
     */
    @RequestMapping(path = "/find")
    public String findService(
            @RequestParam(value = "key") String key
    ) {
        return repository.getService(key);
    }

    /**
     * Remove a {service} attached to the {key}
     * @param model ServiceModel
     * @return String
     */
    @RequestMapping(path = "/remove", method = RequestMethod.DELETE)
    public String removeService(
            @RequestBody ServiceModel model,
            HttpServletRequest request
    ) {
        model.setRemoteAddress(request.getRemoteAddr());
        repository.removeService(model);

        return "Service \"" + model.getPort() + "\" at key \"" + model.getKey() + "\" removed";
    }

    /**
     * Remove entire {key} set
     * @param key String
     * @return String
     */
    @RequestMapping(path = "/remove-all")
    public String removeAllServices(
            @RequestParam(value = "key") String key
    ) {
        repository.removeEntireServiceSet(key);

        return "All services at key \"" + key + "\" removed";
    }
}
