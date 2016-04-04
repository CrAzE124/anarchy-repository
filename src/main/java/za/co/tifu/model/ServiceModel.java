package za.co.tifu.model;

/**
 * Created on 03 April 2016 @ 2:01 PM
 * Component for project "service-repository"
 *
 * @author Thomas Bezuidenhout
 */
public class ServiceModel {
    private final String key;
    private final String serviceName;

    public ServiceModel(String key, String serviceName) {
        this.key = key;
        this.serviceName = serviceName;
    }

    public ServiceModel() {
        key = "";
        serviceName = "";
    }

    public String getKey() {
        return key;
    }

    public String getServiceName() {
        return serviceName;
    }
}
